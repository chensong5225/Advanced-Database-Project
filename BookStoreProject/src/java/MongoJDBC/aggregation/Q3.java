/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoJDBC.aggregation;

import MongoJDBC.connectMongo.MongoDbCon;
import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCursor;
import static java.util.Arrays.asList;
import java.util.Iterator;
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
    
    public void query(String date){
        //connect Mongo
        Connect("ADB_ware", "Fact");
        /*
        sale top5
        */
        AggregateIterable<Document> sales5 =this.collection.aggregate(
                asList(new Document("$match",new Document("date",date)),
                       new Document("$group",new Document("productname","product.name")).
                                                 append("total_sales",new Document("$sum",new Document("$multiply",asList("price_per_item","amount")))).
                                                 append("total_cost",new Document("$sum",new Document("$multiply",asList("cost_per_item","amount")))),
                       new Document("$sort",new Document("total_sales",-1)),
                       new Document("$limit",5)
                )
        );
         /*
         sale low5
         */
        AggregateIterable<Document> salesLow5 =this.collection.aggregate(
                asList(new Document("$group",new Document("date","$date.name")).
                                                 append("total_sales",new Document("$sum",new Document("$multiply",asList("price_per_item","amount")))).
                                                 append("total_cost",new Document("$sum",new Document("$multiply",asList("cost_per_item","amount")))),
                       new Document("$sort",new Document("total_sales",1)),
                       new Document("$limit",5)
                )
        );
    
         
       //materialized vies
       Connect("ADB_ware", "ViewQ3");
       
        MongoCursor<Document> itLow5 = salesLow5.iterator();
         try {
                while (itLow5.hasNext()) {
                    Document a=itLow5.tryNext();
                    this.collection.insertOne(a);
                }
            } finally {
                 itLow5.close();
            }
         
         MongoCursor<Document> itHigh5 = sales5.iterator();
         try {
                while (itHigh5.hasNext()) {
                    Document a=itHigh5.tryNext();
                    this.collection.insertOne(a);
                }
            } finally {
                 itHigh5.close();
            }
        
      
    }
    
}
