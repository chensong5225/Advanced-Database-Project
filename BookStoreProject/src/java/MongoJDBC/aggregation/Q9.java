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
import static java.util.Arrays.asList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.bson.Document;

/**
 *
 * @author fei
 */
public class Q9 extends MongoDbCon{
    public HashMap<String,Double> query(){      
        //connect
        Connect("ADB_ware","Fact");
        //query
        HashMap<String,Double> result = new HashMap<String,Double>();
        {
            AggregateIterable<Document>  it = collection.aggregate(
               asList(    
                       new Document("$group", new Document("_id","$store.storeId").
                                                  append("amount",new Document("$sum","$sales"))                                               
                                   )
                     )                                     
            );
            MongoCursor<Document> mongoCursor = it.iterator();
            while(mongoCursor.hasNext()){
                Document tmp = mongoCursor.next();
                String tmpCusName = (String)tmp.get("_id");    
                Double tmpcnt = (Double)tmp.get("amount");    
                result.put(tmpCusName,tmpcnt);
            }
        }
        return result;
    }
   
    
    public static void main(String args[]){
        Q9 q = new Q9();
       
        HashMap<String,Double>  c=q.query();
        Iterator it = c.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            String region = (String)entry.getKey();
            Double sale = (Double)entry.getValue();
             System.out.println("结果是:-->"+"customer : "+region+" and amount : "+sale);
        }
        
    }
}
