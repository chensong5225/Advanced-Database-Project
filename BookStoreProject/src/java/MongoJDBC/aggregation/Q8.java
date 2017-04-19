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
import java.util.Map;
import org.bson.Document;

/**
 *
 * @author fei
 * 
 * 
 * Q8:Develop a direct marketing data; for each product, a list of customers that buy the product more
than 2 times per week.
 */
public class Q8 extends MongoDbCon{
    public HashMap<String,Integer> query(String prdtName,String week){      
        //connect
        Connect("ADB_ware","Fact");
        //query
        HashMap<String,Integer> result = new HashMap<String,Integer>();
        {
            AggregateIterable<Document>  it = collection.aggregate(
               asList(      
                       new Document("$match",new Document("product.name",prdtName).append("date.week", week)),
                       new Document("$group", new Document("_id","$customer.name").
                                                  append("count",new Document("$sum",1))                                               
                                   )
//                       new Document("$project",new Document("count",new Document("$gte",2)))
                     )                                     
            );
            MongoCursor<Document> mongoCursor = it.iterator();
            while(mongoCursor.hasNext()){
                Document tmp = mongoCursor.next();
                String tmpCusName = (String)tmp.get("_id");    
                Integer tmpcnt = (Integer)tmp.get("count");    
                result.put(tmpCusName,tmpcnt);
            }
        }
        return result;
    }
   
    
    public static void main(String args[]){
        Q8 q = new Q8();
        String week = "3";
        HashMap<String,Integer>  c=q.query("Leonardo and the Last Supper",week);
        Iterator it = c.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            String region = (String)entry.getKey();
            Integer sale = (Integer)entry.getValue();
             System.out.println("结果是:-->"+"customer : "+region+" and amount : "+sale);
        }
        
    }
}
