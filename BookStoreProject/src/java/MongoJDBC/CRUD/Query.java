package MongoJDBC.CRUD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;


import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import MongoJDBC.connectMongo.MongoDbCon;
import MongoJDBC.src.dataStru.QueryAndColl;

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
			collection.find(doc).forEach(printBlock);
		}
		return result;
	}

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
