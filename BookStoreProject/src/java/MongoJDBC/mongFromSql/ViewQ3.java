/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoJDBC.mongFromSql;

import MongoJDBC.connectMongo.MongoDbCon;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author fei
 */
public class ViewQ3 extends MongoDbCon{
    public void load(){
       
        //connect to mongodb
        Connect("ADB_ware", "ViewQ3");
        this.collection.drop();
        
        //
        ArrayList<Document> q3 = new ArrayList<Document>();
        
        this.collection.insertMany(q3);
                
    }
}
