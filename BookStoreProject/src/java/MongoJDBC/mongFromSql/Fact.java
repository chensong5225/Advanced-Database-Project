/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoJDBC.mongFromSql;
import MongoJDBC.src.connectMongo.MongoDbCon;
/**
 *
 * @author fei
 */
public class Fact extends MongoDbCon{
    public void load(){
         //connect
         Connect("finalproject","Fact");
         //load transaction dim
         
    
    }
       
}
