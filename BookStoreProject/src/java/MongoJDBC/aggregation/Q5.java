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
 * 
 * How do the various regions compare by sales volume?
 */
public class Q5 extends MongoDbCon{
    public HashMap<String,Double> query(){
       
        //connect
        Connect("ADB_ware","Fact");
        //query
        HashMap<String,Double> result = new HashMap();
        {
            AggregateIterable<Document>  it = collection.aggregate(
               asList(                     
                       new Document("$group", new Document("_id","$store.region").
                                                  append( "totalsale", new Document("$sum","$sales"))                                                  
                                   )                    
                     )                                     
            );
            MongoCursor<Document> mongoCursor = it.iterator();
            while(mongoCursor.hasNext()){
                Document tmp = mongoCursor.next();
                String tmpregion = (String)tmp.get("_id");
                Double tmptotalsale = (Double)tmp.get("totalsale");
                result.put(tmpregion, tmptotalsale);
            }
        }
        return result;
    }
    
//    public static void main(String args[]){
//        Q5 q = new Q5();
//        HashMap c=q.query();
//        Iterator it = c.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry entry = (Map.Entry) it.next();
//            String region = (String)entry.getKey();
//            Double sale = (Double)entry.getValue();
//             System.out.println("结果是:-->"+"region : "+region+"and sales : "+sale);
//        }
//       
//    }
}
