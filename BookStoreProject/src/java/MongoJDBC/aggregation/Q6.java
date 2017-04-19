/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoJDBC.aggregation;

import MongoJDBC.connectMongo.MongoDbCon;
import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import java.util.Arrays;
import static java.util.Arrays.asList;
import org.bson.Document;

/**
 *
 * @author fei
 * 
 * 
 * /*
    which business are buying given products the most
   
 */
 
public class Q6 extends MongoDbCon{
     static Block<Document> printBlock = new Block<Document>() {
	       @Override
	       public void apply(final Document document) {
	           System.out.println(document.toJson());
	       }
    };
    
    public String query(String productname){
        String result="";
        //connect
        Connect("ADB_ware","Fact");
        //
        AggregateIterable<Document>  it = collection.aggregate(
               asList(
                       new Document("$match", new Document("product.name",productname)),
                       new Document("$group", new Document("_id",new Document("businessCat","$customer.category")).
                                                    append("count", new Document("$sum",1))
                                                   
                                   ),
                       new Document("$sort", new Document("count",-1 ) )        
                     )                                     
       );
       MongoCursor<Document> mongoCursor = it.iterator();
      
        try {
                while (mongoCursor.hasNext()) {
//                    System.out.println(mongoCursor.next().toJson());
                    Document a=mongoCursor.tryNext();
                    Document b=(Document)a.get("_id");
                    String c = (String)b.get("businessCat");
                    if(c.equals("home")){
                        continue;
                    }
                    System.out.println("businessCat is "+c);
                    return c;
//                    System.out.println("businessCat is -->"+a.get("_id.businessCat"));
                }
            } finally {
                 mongoCursor.close();
            }
                                                   
        return result;
    }
    
    public static void main(String args[]){
        Q6 q = new Q6();
        String c=q.query("Countdown to Pearl Harbor");
        System.out.println("结果是:-->"+c);
    }
}
