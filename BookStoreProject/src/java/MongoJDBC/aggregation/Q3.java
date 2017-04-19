/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoJDBC.aggregation;

import MongoJDBC.connectMongo.MongoDbCon;
import static MongoJDBC.connectMongo.MongoDbCon.Connect;
import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.bson.Document;

/**
 *
 * @author fei
 */
public class Q3 extends MongoDbCon{
    static Block<Document> printBlock = new Block<Document>() {
	       @Override
	       public void apply(final Document document) {
	           System.out.println(document.toJson());
	       }
    };
    /*
   /*
    maintain every day the aggregate sales and profit of top5 and bottom5 products
    */ 
    public HashMap<String, ArrayList<String> > query(ArrayList<String> olddate1){
        HashMap<String, ArrayList<String> > result = new HashMap<String, ArrayList<String> >();
         //获取日期
        String year1 = olddate1.get(0);
        String month1 = olddate1.get(1);
        String day1 = olddate1.get(2);
        System.out.println("day1-->"+day1);
        //connect Mongo
        Connect("ADB_ware", "Fact");
        /*
        sale top5 product
        */
        ArrayList<String> top5 = new  ArrayList<String>();
        AggregateIterable<Document> it =this.collection.aggregate(
                asList(new Document("$match",new Document("date.year",year1).append("date.day", day1).append("date.month", month1)),
                       new Document("$group",new Document("_id","$product.name")
                                                        .append("totalsales",new Document("$sum","$sales"))
                       ),                                                
                       new Document("$sort",new Document("totalsales",-1))
                      
                )
        );
        MongoCursor<Document> mongoCursor = it.iterator();
        while(mongoCursor.hasNext()){
            Document tmp = mongoCursor.next();
            String tmpproductname = (String)tmp.get("_id");
            top5.add(tmpproductname);
        }
        result.put("top5",top5);
        /*
        sale bottom product
        */
        ArrayList<String> bottom5 = new  ArrayList<String>();
        it =this.collection.aggregate(
                asList(new Document("$match",new Document("date.year",year1).append("date.day", day1).append("date.month", month1)),
                       new Document("$group",new Document("_id","$product.name")
                                                        .append("totalsales",new Document("$sum","$sales"))
                       ),                                                
                       new Document("$sort",new Document("totalsales",1))
                      
                )
        );
        mongoCursor = it.iterator();
        while(mongoCursor.hasNext()){
            Document tmp = mongoCursor.next();
            String tmpproductname = (String)tmp.get("_id");
            bottom5.add(tmpproductname);
        }
        result.put("bottom5",bottom5);
        return result;
    }
    
    
    
//    public void CreateViews(String date){
//        
//        
//        
//        //connect Mongo
//        Connect("ADB_ware", "Fact");
//        /*
//        sale top5
//        */
//        AggregateIterable<Document> sales5 =this.collection.aggregate(
//                asList(new Document("$match",new Document("date",date)),
//                       new Document("$group",new Document("productname","product.name")).
//                                                 append("total_sales",new Document("$sum",new Document("$multiply",asList("price_per_item","amount")))).
//                                                 append("total_cost",new Document("$sum",new Document("$multiply",asList("cost_per_item","amount")))),
//                       new Document("$sort",new Document("total_sales",-1)),
//                       new Document("$limit",5)
//                )
//        );
//         /*
//         sale low5
//         */
//        AggregateIterable<Document> salesLow5 =this.collection.aggregate(
//                asList(new Document("$group",new Document("date","$date.name")).
//                                                 append("total_sales",new Document("$sum",new Document("$multiply",asList("price_per_item","amount")))).
//                                                 append("total_cost",new Document("$sum",new Document("$multiply",asList("cost_per_item","amount")))),
//                       new Document("$sort",new Document("total_sales",1)),
//                       new Document("$limit",5)
//                )
//        );
//    
//         
//       //materialized vies
//       Connect("ADB_ware", "ViewQ3");
//       
//        MongoCursor<Document> itLow5 = salesLow5.iterator();
//         try {
//                while (itLow5.hasNext()) {
//                    Document a=itLow5.tryNext();
//                    this.collection.insertOne(a);
//                }
//            } finally {
//                 itLow5.close();
//            }
//         
//         MongoCursor<Document> itHigh5 = sales5.iterator();
//         try {
//                while (itHigh5.hasNext()) {
//                    Document a=itHigh5.tryNext();
//                    this.collection.insertOne(a);
//                }
//            } finally {
//                 itHigh5.close();
//            }
//        
//      
//    }
    
     public static void main(String args[]){
        Q3 q = new Q3();
        ArrayList<String> olddate1 =new ArrayList();
        olddate1.add("2017");
        olddate1.add("02");
        olddate1.add("18");
        System.out.println(q.query(olddate1));
            
    }
    
}
