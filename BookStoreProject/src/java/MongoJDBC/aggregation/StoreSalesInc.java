package MongoJDBC.aggregation;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;

import MongoJDBC.src.connectMongo.MongoDbCon;

public class StoreSalesInc  extends MongoDbCon {
	static Block<Document> printBlock = new Block<Document>() {
	       @Override
	       public void apply(final Document document) {
	           System.out.println(document.toJson());
	       }
	};
	public static ArrayList<String> inc(String date1, String date2){
		ArrayList<String> result = new ArrayList<>();
		Connect("finalproject", "fact");
		
		Document date1doc = Document.parse("{'time':'"+date1+"'}");
		Document date2doc = Document.parse("{'time':'"+date2+"'}");
		ArrayList<Document> d1 = new ArrayList<Document>();
		d1.add(date1doc);
		collection.find(date1doc).forEach(printBlock);;
		AggregateIterable<Document> date1sale =collection.aggregate(d1);
		System.out.println(date1sale);
		FindIterable<Document> date2sale =collection.find(date2doc);
		
		return result;
	}
	
	public static void main(String args[]){
		StoreSalesInc.inc("2017-02-15", "");
	}
}
