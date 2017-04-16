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
import org.bson.Document;

/**
 *
 * @author fei
 * 
 * 
 * Develop a direct marketing data; for each product, a list of customers that buy the product more
than 2 times per week.
 */
public class Q7 extends MongoDbCon{
    public HashMap<String,String> query(String prdtName){      
        //connect
        Connect("ADB_ware","Fact");
        //query
        HashMap<String,String> result = new HashMap();
        {
            AggregateIterable<Document>  it = collection.aggregate(
               asList(      
                       new Document("$match",new Document("product.name",prdtName)),
                       new Document("$group", new Document("_id","$customer.name").
                                                  append("count",new Document("$sum",1))                                               
                                   )                    
                     )                                     
            );
            MongoCursor<Document> mongoCursor = it.iterator();
            while(mongoCursor.hasNext()){
                Document tmp = mongoCursor.next();
                String tmpCusName = (String)tmp.get("_id");
                String tmpCnt = (String)tmp.get("totalsale");
                result.put(tmpCusName, tmpCnt);
            }
        }
        return result;
    }
    
    public ArrayList productList(){
         //connect
        Connect("ADB_ware","Fact");
        //query
        ArrayList<String> result = new ArrayList();
        {
            AggregateIterable<Document>  it = collection.aggregate(
               asList(                            
                       new Document("$group", new Document("_id","$product.name") )                                                                                                                                            
                     )                                     
            );
            MongoCursor<Document> mongoCursor = it.iterator();
            while(mongoCursor.hasNext()){
                Document tmp = mongoCursor.next();
                String tmpProName = (String)tmp.get("_id");                 
                result.add(tmpProName);
            }
        }
        return result;
    }
    
    public static void main(String args[]){
        Q7 q = new Q7();
        HashMap<String,String> c=q.query("Leonardo and the Last Supper");    
        ArrayList proList = q.productList();
        System.out.println("proList结果是:-->"+proList);
        for(int i=0;i<proList.size();i++){
             HashMap<String,String> tmp=q.query((String)proList.get(i));    
        }
    }
}
