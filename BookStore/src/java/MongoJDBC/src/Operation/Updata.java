package Operation;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.util.JSON;

import connectMongo.MongoDbCon;

public class Updata {
	public DBCollection collection ;
	public Updata(String dbname,String colname) {
		// TODO Auto-generated constructor stub
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("test");
		// get a single collection
		collection = db.getCollection("site1");
		System.out.println("链接成功");
	}
	public void userInput(String json, String json_New){
		BasicDBObject docold = (BasicDBObject)JSON.parse(json);
		BasicDBObject doc_new = (BasicDBObject)JSON.parse(json_New);
		System.out.println(docold);
		System.out.println(doc_new);
		collection.update(docold, doc_new);
	} 
	
	public static void main(String[] args){
		String docold = "{'title': 'MongoDB' }";
		String docnew = "{'$set': {'title':'hongyang','likes':'200','description':'male'} }";
		Updata up = new Updata("test", "site1");
		up.userInput(docold,docnew);
	}
}
