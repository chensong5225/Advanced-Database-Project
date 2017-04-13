package MongoJDBC.connectMongo;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDbCon {
	public  static MongoCollection<Document> collection=null;
        public  static AggregateIterable<Document> aggregate = null;
	public  static void Connect(String dbname, String colname){
		  // 连接到 mongodb 服务
	      MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	      // 连接到数据库 
	      MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);  
	      System.out.println("Connect to database successfully");
	      // 连接到数据库表(集合) test 
	      collection = mongoDatabase.getCollection(colname);
              System.out.println("集合"+colname+" 选择成功");
	}
}
