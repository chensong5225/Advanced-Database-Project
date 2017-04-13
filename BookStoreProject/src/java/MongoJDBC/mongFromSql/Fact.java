/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoJDBC.mongFromSql;

import MongoJDBC.src.connectMongo.MongoDbCon;
import java.util.ArrayList;
import org.bson.Document;
import sqlJDBC.LoadCustomer;
import sqlJDBC.LoadStore;
import sqlJDBC.StartLoad;
/**
 *
 * @author fei
 */
public class Fact extends MongoDbCon{
    public void load() throws ClassNotFoundException{
         //connect
         Connect("finalproject","Fact");
         /*
         load transaction_id and product_id
         */
         ArrayList<String[]> tran_pro_id = new StartLoad().load();
         Document factDocument = new Document();
         for(int i=0;i<tran_pro_id.size();i++){
             String[] tran_proArray= tran_pro_id.get(i);
             //get transaction_id && product_id
             String tId = tran_proArray[0];
             String pId = tran_proArray[1];
             System.out.println("tId-->"+tId+"   pId-->"+pId);
             /*
             load customer Document
             */
             Document custmerDocument = new Document();
             String[] costmerDoc = new LoadCustomer().load(tId,pId);
             custmerDocument.append(costmerDoc[0],costmerDoc[1]);
             System.out.println("costmerDoc-->"+costmerDoc[0]+"  ,  "+costmerDoc[1]);
             /*
             load store Document
             */
             Document storeDocument = new Document();
             String[] storeDoc = new LoadStore().load(tId,pId);
             storeDocument.append(storeDoc[0],storeDoc[1]);
             System.out.println("storeDoc-->"+storeDoc[0]+"  ,  "+storeDoc[1]);
             /*
             load product Document
             */
         }
    }
    
    public static void main(String args[]) throws ClassNotFoundException{
        Fact f = new Fact();
        f.load();
    }
       
}
