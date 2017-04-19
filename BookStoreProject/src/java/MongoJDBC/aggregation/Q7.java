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
 * 
 * What is the demand curve for each product category (i.e., the curve, that measures the propensity
of customer to pay for a product as the price changes)
 */
public class Q7 extends MongoDbCon{
    public HashMap<Double,Double> query(String prdtName){ 
         HashMap<Double,Double> result = new HashMap();
        //connect
        Connect("ADB_ware","Fact");
        //query
        AggregateIterable<Document>  it = collection.aggregate(
               asList(      
                       new Document("$match",new Document("product.name",prdtName)),
                       new Document("$group", new Document("_id", "$product.price").                                               
                                                  append("totalamount", new Document("$sum","$amount"))
                                   )                    
                     )                                     
            );
        MongoCursor<Document> mongoCursor = it.iterator();
        while(mongoCursor.hasNext()){
            Document tmp = mongoCursor.next();
            Double tmpCusName = (Double)tmp.get("_id");
            Double tmpCnt = (Double)tmp.get("totalamount");
            result.put(tmpCusName, tmpCnt);
        }
        
        return result;
    }
    
    public static void main(String args[]){
        Q7 q = new Q7();
        HashMap<Double,Double>  c=q.query("Countdown to Pearl Harbor");
        Iterator it = c.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            Double region = (Double)entry.getKey();
            Double sale = (Double)entry.getValue();
             System.out.println("结果是:-->"+"price : "+region+" and sales : "+sale);
        }
//        System.out.println("结果是:-->"+c);
    }
}
