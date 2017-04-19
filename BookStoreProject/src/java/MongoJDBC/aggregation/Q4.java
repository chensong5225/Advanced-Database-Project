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
import java.util.HashMap;
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
    public HashMap<String,ArrayList<String>> query(ArrayList<String> olddate1){
        HashMap<String,ArrayList<String> > result = new HashMap<String,ArrayList<String>>();
        //获取日期
        String year1 = olddate1.get(0);
        String month1 = olddate1.get(1);
        String day1 = olddate1.get(2);
        System.out.println("day1-->"+day1);
        //connect Mongo
        Connect("ADB_ware", "Fact");
        /*
         top2 customer
        */
        AggregateIterable<Document>  it = collection.aggregate(asList(  new Document("$match",new Document("date.year",year1).append("date.day", day1).append("date.month", month1)),
                                                                        new Document("$group",new Document("_id", "$customer.category")                                                                                             
                                                                                            .append("total_sales", new Document("$sum","$sales"))
                                                                                    ),
                                                                        new Document("$sort",new Document("total_sales",-1)),
                                                                        new Document("$limit",2)
        ));
        
        MongoCursor<Document> mongoCursor = it.iterator();
        ArrayList<String> top2_customer = new ArrayList<String>(); 
        while(mongoCursor.hasNext()){
            Document tmp = mongoCursor.next();
            String tmpproductname = (String)tmp.get("_id");
            top2_customer.add(tmpproductname);
        }
        /*
         top2 product
        */
        it = collection.aggregate(asList(  new Document("$match",new Document("date.year",year1).append("date.day", day1).append("date.month", month1)),
                                                                        new Document("$group",new Document("_id", "$product.category")                                                                                             
                                                                                            .append("total_sales", new Document("$sum","$sales"))
                                                                                    ),
                                                                        new Document("$sort",new Document("total_sales",-1)),
                                                                        new Document("$limit",2)
        ));
        mongoCursor = it.iterator();
        ArrayList<String> top2_product = new ArrayList<String>(); 
        while(mongoCursor.hasNext()){
            Document tmp = mongoCursor.next();
            String tmpproductname = (String)tmp.get("_id");
            top2_product.add(tmpproductname);
        }
        //result
        result.put("top2customer", top2_customer);
        result.put("top2product", top2_product);
        System.out.println("reuslt-->"+result);
        return result;
        
<<<<<<< HEAD
=======
        //筛选出前2的product
<<<<<<< HEAD
<<<<<<< HEAD
        collection.find();
=======
        collection.aggregate("",);
>>>>>>> e0c9165d45fab33384ee6b9ad2c51f2d97cc73ae
=======
//        collection.aggregate("",);
>>>>>>> 703f25989c99a54a7787804108a4b7d7b4ed9171
>>>>>>> a08ecd25716d95888ad6a94bc1be634dfb29852b
        
    }
    
    public static void main(String args[]){
        Q4 q = new Q4();
        ArrayList<String> olddate1 =new ArrayList();
        olddate1.add("2017");
        olddate1.add("03");
        olddate1.add("18");
        q.query(olddate1);
    }
}
