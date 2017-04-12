package MongoJDBC.src.Operation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import MongoJDBC.src.connectMongo.MongoDbCon;


public  class Insert extends MongoDbCon{
	 //打印输出函数
	 Block<Document> printBlock = new Block<Document>() {
	       @Override
	       public void apply(final Document document) {
	           System.out.println(document.toJson());
	       }
	};
	//database you want operate
	public  Insert(String dbname, String colname){
		  // 连接到 mongodb 服务
	      MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	      // 连接到数据库 
	      MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);  
	      System.out.println("Connect to database successfully");
	      // 连接到数据库表(集合) test 
	      this.collection = mongoDatabase.getCollection(colname);
	      System.out.println("集合"+colname+" 选择成功");
		 Connect(dbname,colname);
		
	}
	//insert operation
	public void insert(Document doc){
//		 Document document = new Document("name", "MongoDB").  
//				 			append("description", "database").  
//				 			append("likes", 100).  
//				 			append("by", "Fly"); 
	     List<Document> documents = new ArrayList<Document>();  
	     documents.add(doc);  
	     collection.insertMany(documents);  
	     System.out.println("文档插入成功"); 
	}
	
	public void userInput(){
		Document doc =new Document();
		String exit = "no";
		while (true) {
			System.out.println("输入key : ");
			Scanner sc=new Scanner(System.in); 
			String key=sc.next();
			System.out.println("输入key : ");
			String val=sc.next();
			doc=new Document(key,val);
			insert(doc);
			System.out.println("如果输入结束，请输入yes");
			exit=sc.next();
			if(exit.equals("yes"))
				break;
		}
	}
	
	public void userInput(String json){
		//json to BasicDBOject
		BasicDBObject dbObject = (BasicDBObject)JSON.parse(json);
		//BasicDBOject to string, then to doc
		Document doc = Document.parse(dbObject.toString());
		collection.insertOne(doc);
		System.out.println("插入成功");
	}
//	public static void main(String[] args){
//		Insert insert = new Insert("test", "site1");
//		insert.userInput("{'title': 'adbclass'}");
//	}
}
