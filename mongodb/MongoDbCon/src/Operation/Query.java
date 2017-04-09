package Operation;

import java.lang.annotation.Target;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.lang.model.element.VariableElement;
import javax.print.Doc;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.ietf.jgss.Oid;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.util.JSON;

import dataStru.QueryAndColl;
import innerface.MongoDbCon;

public class Query extends MongoDbCon {
	 //打印输出函数
	static Block<Document> printBlock = new Block<Document>() {
	       @Override
	       public void apply(final Document document) {
	           System.out.println(document.toJson());
	       }
	};
	/*input should like the following : 
	 * String a ="{ 'title':'qifei', 'like':['10','100']," + " 'detail':{'record':100 , 'active': 'true' } " ;
	 * */
	public static FindIterable<Document> userInput(String dbname, QueryAndColl query){
		Connect(dbname, query.Collection);
		FindIterable<Document> result = null; 
		if(query.Query!=""){
			Document doc = Document.parse(query.Query);
			result =collection.find(doc);
			System.out.println("以下是打印输出查询结果");
			collection.find(doc).forEach(printBlock);
			//find responding id
			Vector<Object> vid = new Vector<>();
			Object id=new Object();
			for(Document a : result){
				id=a.get("_id");
				vid.add(a.get("$oid"));
				System.out.println(a.get("_id"));
			}
			// Given id, query linked document
//			Connect("finalpr"
//					+ "oject","customer");
//			ObjectId oId = new ObjectId(id.toString());
//			System.out.println("objectId"+oId);
//			String tmp = "{'_id':"+oId+"}";
//			System.out.println("根据id查找文档"+tmp);
//			Document doc2 = Document.parse("{'_id':{'$oid':'58e2a79d6d60ab35109d98af'} }");
////			Document doc2 = Document.parse("{'type':'home'}");
//			System.out.println("doc2是"+doc2);
////			collection.find().forEach(printBlock);
//			collection.find(doc2).forEach(printBlock);
		}
		return result;
	}

	//@query: {"":""}, like where
	//@
	public static ArrayList<Document> userInput(String dbname, QueryAndColl query, QueryAndColl target){
		ArrayList<Document> result= new ArrayList<>();
		/*connect to querydb
		 * 
		*/
		Connect(dbname, query.Collection);
		Document doc = Document.parse(query.Query);
		
		//find responding document
		FindIterable<Document> queryDocList =collection.find(doc);
		
		//find responding id
		Vector<ObjectId> vid = new Vector<>();
		for(Document a : queryDocList){
			Document c_idDoc =(Document) a.get("c_id");
			ObjectId c_id = (ObjectId)c_idDoc.get("id");
			vid.add(c_id);
		}
		
		/* 
		 * Given ObjectId, query linked document
		 *
		*/
		Connect("finalproject", target.Collection);
		
		//find linked document
//		collection.find().forEach(printBlock);
		FindIterable<Document> targetDoc =collection.find();
		for(Document a : targetDoc){
			ObjectId oid_targetDoc = a.getObjectId("_id");
			if(vid.contains(oid_targetDoc)){
				result.add(a);
			}
		}
		
		//return 
		return result;
	}
	
	public static void main(String[] args){
		String a ="{'store_id': 1}";
		String b ="";
		ArrayList<Document> docList = Query.userInput("finalproject",new QueryAndColl(a,"transaction"), new QueryAndColl(b,"customer"));
		Iterator<Document> it = docList.iterator();
		while (it.hasNext()) {
			Document tmp = (Document) it.next();
			System.out.println(tmp);
		}
		
	}
}
