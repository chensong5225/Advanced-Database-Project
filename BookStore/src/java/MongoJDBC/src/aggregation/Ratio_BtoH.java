package MongoJDBC.src.aggregation;

import org.bson.Document;
import com.mongodb.client.FindIterable;

import MongoJDBC.src.connectMongo.MongoDbCon;

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
