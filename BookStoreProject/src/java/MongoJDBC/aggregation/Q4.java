/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoJDBC.aggregation;

import MongoJDBC.connectMongo.MongoDbCon;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author fei
 * 
 * 
 * 
 * Maintain every day the top 2 customer categories (highest sales) and the top product categories.
 */
public class Q4 extends MongoDbCon{
    public void VieswsQ4(){
       //connect to mongodb Fact
        Connect("ADB_ware", "Fact");
        AggregateIterable<Document>  it = collection.aggregate(asList(new Document("$group",new Document("_id", new Document("cat","$customer.category") 
                                                                                            .append("date","$date")
                                                                        ).append("total_sales", new Document("$sum",new Document("$multiply",asList("$price_per_item","$amount"))))
                                                ),
                                    new Document("$sort",new Document("total_sales",-1))                                   
        ));
        
        //create new collection
        Connect("ADB_ware", "tmp");
        List<Document> Q4Document = new ArrayList<Document>();
        MongoCursor<Document> mongoCursor = it.iterator();
        try {
           while (mongoCursor.hasNext()) {
             Document b = mongoCursor.next();
             Q4Document.add(b);
             System.out.println("home_count is "+b);
            }
         } finally {
           mongoCursor.close();
         }
        collection.insertMany(Q4Document);
        
        //筛选出前2的product
        collection.aggregate("",);
        
    }
    
//    public static void main(String args[]){
//        Q4 q = new Q4();
//        q.VieswsQ4();
//    }
}
