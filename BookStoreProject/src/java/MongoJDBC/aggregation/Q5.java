/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoJDBC.aggregation;

import MongoJDBC.connectMongo.MongoDbCon;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import java.util.Arrays;
import org.bson.Document;

/**
 *
 * @author fei
 */
public class Q5 extends MongoDbCon{
    /*
    which business are buying given products the most
    */
    public void query(){
        //connect
        Connect("ADB_ware","Fact");
        //
       FindIterable<Document>  it = this.collection.find(
               new Document().append("customer.name", "betty")
        );
        
                                                    
        //
    }
    
    public static void main(String args[]){
        Q5 q = new Q5();
        q.query();
    }
}
