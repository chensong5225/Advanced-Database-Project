package Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.util.JSON;

import innerface.MongoDbCon;

public class Query extends MongoDbCon {
	 //打印输出函数
	 Block<Document> printBlock = new Block<Document>() {
	       @Override
	       public void apply(final Document document) {
	           System.out.println(document.toJson());
	       }
	};
	public Query(String db, String col) {
		// TODO Auto-generated constructor stub
		this.Connect(db, col);
	}
	/*input should like the following : 
	 * String a ="{ 'title':'qifei', 'like':['10','100']," + " 'detail':{'record':100 , 'active': 'true' } " ;
	 * */
	public void userInput(String json){
		if(json!=""){
			Document doc = Document.parse(json);
			System.out.println("-----");
			System.out.println(doc);
			collection.find(doc).forEach(printBlock);
		}
		else{
			collection.find().forEach(printBlock);
		}
	}
	
	public void userInput(){
		collection.find().forEach(printBlock);
	}
	
//	public static void main(String[] args){
//		Query q = new Query("test", "site1");
//		String a ="{'title': 'mac'}";
//		q.userInput();
//	}
}
