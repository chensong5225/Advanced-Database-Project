/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoJDBC.aggregation;

import MongoJDBC.connectMongo.MongoDbCon;
import static MongoJDBC.connectMongo.MongoDbCon.Connect;
import static MongoJDBC.connectMongo.MongoDbCon.collection;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.HashMap;
import java.util.Iterator;
import org.bson.Document;

/**
 *
 * @author fei
 * 
 * 
 * What stores are increasing in sales?
 */
public class Q2 extends MongoDbCon{
     public ArrayList<String> query(ArrayList<String> olddate1,ArrayList<String> newdate2){
        //connect
        Connect("ADB_ware","Fact");
//        //获取日期
        String year1 = olddate1.get(0);
        String month1 = olddate1.get(1);
        String day1 = olddate1.get(2);
        System.out.println("day1-->"+month1+"--"+day1);
        String year2 = newdate2.get(0);
        String month2 = newdate2.get(1);
        String day2 = newdate2.get(2);
        System.out.println("day2-->"+month2+"--"+day2);
        /*
        遍历所有店
        */
        
        //1. 获取所有店的ID
        ArrayList<String> IdList = new ArrayList();
        {
            AggregateIterable<Document>  it = collection.aggregate(asList(new Document("$group",
                                                                                                new Document("_id","$store.storeId"))
                                                                    ));
            MongoCursor<Document> mongoCursor = it.iterator();
            while(mongoCursor.hasNext()){
                Document tmp = mongoCursor.next();                
                IdList.add((String)tmp.get("_id"));
            }
        }
       
        //2. 通过ID遍历所有的document,获取那比较日期的sales
        HashMap<String,Double> old = new HashMap();
        HashMap<String,Double> newd = new HashMap();
            //初始化,防止出现空指针
            {
                Iterator itarray = IdList.iterator();              
                while(itarray.hasNext()){
                    String storeId = (String) itarray.next();
                    old.put(storeId, 0.0);
                    newd.put(storeId,0.0);
                }
            }           
            //查询 old date ,每个店的销售情况
        {
          
            AggregateIterable<Document>  it = collection.aggregate(
                   asList(
                           new Document("$match", new Document("date.day",day1)
                                                        .append("date.month", month1)
                                                        .append("date.year", year1)),
                           new Document("$group", new Document("_id","$store.storeId").
                                                        append("total_sale", new Document("$sum","$sales")).
                                                        append( "count", new Document( "$sum", 1 ))
                                       )
                         )
            );
            MongoCursor<Document> mongoCursor = it.iterator();
            while(mongoCursor.hasNext()){
                Document tmp = mongoCursor.next();
                old.put((String)tmp.get("_id"),(double)tmp.get("total_sale"));
//                System.out.println("oldtmp--->"+tmp);
//                    old.add((String)tmp.get("_id"),(Double)tmp.get("totalsales_olddate"));
            }            
         }
            //查询 new date, 每个店的销售情况
          {
          
            AggregateIterable<Document>  it = collection.aggregate(
                   asList(
                           new Document("$match", new Document("date.day",day2)
                                                        .append("date.month", month2)
                                                        .append("date.year", year2)),
                           new Document("$group", new Document("_id","$store.storeId").
                                                        append("total_sale", new Document("$sum","$sales")).
                                                        append( "count", new Document( "$sum", 1 ))
                                       )
                         )
            );
            MongoCursor<Document> mongoCursor = it.iterator();
            while(mongoCursor.hasNext()){
                Document tmp = mongoCursor.next();
                newd.put((String)tmp.get("_id"),(double)tmp.get("total_sale"));
//                System.out.println("newtmp--->"+tmp);
    //                    old.add((String)tmp.get("_id"),(Double)tmp.get("totalsales_olddate"));
            }            
         }
          
        
          
         /*
            比较哪两个店销售量上升
         */
         ArrayList<String> result = new ArrayList();
         {
              Iterator itarray = IdList.iterator();              
              while(itarray.hasNext()){
                  String id = (String)itarray.next();
//                  System.out.println("old_"+id+"--->"+old.get(id));
                  if(old.get(id)<newd.get(id)){
                      result.add(id);
                  }
              }
         
         }
       return result;
     }
     
    public static void main(String args[]){
        Q2 q = new Q2();
        ArrayList<String> olddate1 =new ArrayList();
        ArrayList<String> newdate2 =new ArrayList();
        olddate1.add("2017");
        olddate1.add("02");
        olddate1.add("18");
        
        newdate2.add("2017");
        newdate2.add("02");
        newdate2.add("28");
       
        ArrayList result = q.query( olddate1,  newdate2);
        for(int i=0;i<result.size();i++){
             System.out.println("结果是:-->"+result.get(i));
        }
//        System.out.println("结果是:-->"+c);
    }
}
