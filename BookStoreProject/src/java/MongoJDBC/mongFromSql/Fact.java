/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoJDBC.mongFromSql;

import MongoJDBC.connectMongo.MongoDbCon;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import sqlJDBC.LoadCustomer;
import sqlJDBC.LoadDate;
import sqlJDBC.LoadProduct;
import sqlJDBC.LoadSale;
import sqlJDBC.LoadStore;
import sqlJDBC.StartLoad;
/**
 *
 * @author fei
 */
public class Fact extends MongoDbCon{
    public void load() throws ClassNotFoundException{
         //connect
         Connect("ADB_ware","Fact");
         //IF EXISTS, Drop
         this.collection.drop();
         /*
         load transaction_id and product_id
         */
         ArrayList<String[]> tran_pro_id = new StartLoad().load();
         List<Document> factDocument = new ArrayList<Document>();
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
             custmerDocument.append("name",costmerDoc[0])
                            .append("category",costmerDoc[1]);
             System.out.println("costmerDoc-->"+costmerDoc[0]+"  ,  "+costmerDoc[1]);
             /*
             load store Document
             */
             Document storeDocument = new Document();
             String[] storeDoc = new LoadStore().load(tId,pId);
             storeDocument.append("storeId",storeDoc[0])
                          .append("region",storeDoc[1]);
             System.out.println("storeDoc-->"+storeDoc[0]+"  ,  "+storeDoc[1]);
             /*
             load product Document
             */
             Document productDocument = new Document();
             String[] productDoc = new LoadProduct().load(pId);
             //
             String[] sale_amount_price = new LoadSale().load(tId,pId);
             //price after discounted
             Double price_per_itemF = Double.valueOf(sale_amount_price[1])*100/100;
             Double price_per_item = (price_per_itemF.intValue()) * 1.0;
             Double cost_per_itemF = Double.valueOf(sale_amount_price[2])*100/100;
             Double cost_per_item = (cost_per_itemF.intValue()) * 1.0;
             
             productDocument.append("name",productDoc[0])
                            .append("category",productDoc[1])
                            .append("price",price_per_item)
                            .append("cost", cost_per_item);
                     
             System.out.println("productDocument-->"+productDoc[0]+"  ,  "+productDoc[1]);
             /*
             load sale measure, price_per_item and cost_per_item are discounted
             */
             sale_amount_price = new LoadSale().load(tId,pId);           
             Double amount = Double.valueOf(sale_amount_price[3])*100/100;
             Double sales = amount*price_per_item;
             Double costs = amount*cost_per_item;
             Double profits = sales -  costs;
            
             /*
             load date measure
             */
             String[] date = new LoadDate().load(tId,pId);
             String year = date[0];
             String month = date[1];
             String day = date[2];
             String week = date[3];
             Document dateDoc = new Document()
                                    .append("year",year)
                                    .append("month", month)
                                    .append("day",day)
                                    .append("week",week);
                     
             /*
             load all the dimension and measure
             */
             factDocument.add(new Document("Transaction_id",tId)
                                            .append("customer",custmerDocument)
                                            .append("store", storeDocument)
                                            .append("product", productDocument)
                                            .append("sales",sales)
                                            .append("costs", costs)
                                            .append("amount",amount) 
                                            .append("profits", profits)
                                            .append("date",dateDoc)
             );
         }
         
         //fact load done
         this.collection.insertMany(factDocument);
    }
    
    public static void main(String args[]) throws ClassNotFoundException{
        Fact f = new Fact();
        f.load();
    }
       
}
