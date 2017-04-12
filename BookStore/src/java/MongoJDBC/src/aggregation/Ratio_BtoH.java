package aggregation;

import java.util.ArrayList;

import javax.management.Query;
import javax.print.Doc;

import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;

import connectMongo.MongoDbCon;

public class Ratio_BtoH extends MongoDbCon{
	public static String ratio(){
		int result = 0;
		Connect("finalproject", "customer");
		Document home = Document.parse("{'type':'home'}");
		Document business = Document.parse("{'type':'business'}");
		FindIterable<Document> homefind = collection.find(home);
		FindIterable<Document> busfind = collection.find(business);
		int cnt_cus =0;
		int cnt_bus =0;
		for(Document a:homefind){
			cnt_cus++;
		}
		for(Document a:busfind){
			cnt_bus++;
		}
		return cnt_bus+":"+cnt_cus;
	}
	
	public static void main(String args[]){
		System.out.println(Ratio_BtoH.ratio());
	}
}
