package MongoJDBC.aggregation;

import org.bson.Document;
import com.mongodb.client.FindIterable;
import MongoJDBC.connectMongo.MongoDbCon;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCursor;
import static java.util.Arrays.asList;


public class Q1 extends MongoDbCon{
   
    /*
    
    What is the ratio of business to home customers?
    Q1 query by ViewsType
    */
	public  String ratio(){
		//connect to mongodb
		Connect("ADB_ware", "Viewtype");
                //unwind home
                 Integer home = 0;
                AggregateIterable<Document>  it = collection.aggregate(
                                                        asList(new Document("$unwind","$home")
                                                               ,new Document("$count","home_count")                                                     
                                                        )
                                                    );
                MongoCursor<Document> mongoCursor = it.iterator();
		 try {
                    while (mongoCursor.hasNext()) {
                      Document b = mongoCursor.next();
                      home = (Integer)b.get("home_count");                  
                      System.out.println("home_count is "+home);
                   
                     }
                  } finally {
                    mongoCursor.close();
                  }
                //unwind business
                Integer busi = 0;
                AggregateIterable<Document>  it2 = collection.aggregate(
                                                        asList(new Document("$unwind","$business")
                                                               ,new Document("$count","business_count")                                                     
                                                        )
                                                    );
                MongoCursor<Document> mongoCursor2 = it2.iterator();
		 try {
                    while (mongoCursor2.hasNext()) {
                      Document b = mongoCursor2.next();
                      busi = (Integer)b.get("business_count");                  
                      System.out.println("business_count is "+busi);
                   
                     }
                  } finally {
                    mongoCursor2.close();
                  }
		return busi+":"+home;
	}
	
//	public static void main(String args[]){
//		System.out.println(Q1.ratio());
//	}
}
