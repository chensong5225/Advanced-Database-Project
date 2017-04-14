/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoJDBC.aggregation;

import MongoJDBC.connectMongo.MongoDbCon;
import com.mongodb.Block;
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
    maintain every day the aggregate sales adn profit of top5 and bottom5 products
    */ 
    
    public void query(String date){
        //connect Mongo
        Connect("ADB_ware", "ViewQ3");
        //
    }
    
}
