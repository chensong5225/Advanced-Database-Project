package MongoJDBC.src.mongFromSql;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;

import MongoJDBC.src.connectMongo.MongoDbCon;
public class ViewsType extends MongoDbCon{
	public void load(){
		//connect to mongodb
		Connect("finalproject", "typeCol");
		/*
		 * type collection
		*/
			//load data from sql
			List<String> home = new ArrayList<String>();
			List<String> business = new ArrayList<String>();
			Iterator<String> hit = home.iterator();
			Iterator<String> bit = business.iterator();
			String sdhome = new String();
			String sdbusiness = new String();
			while (hit.hasNext()) {
				String tmp = (String) hit.next();
				sdhome = sdhome +","+tmp;
			}
			while (bit.hasNext()) {
				String tmp = (String) bit.next();
				sdbusiness = sdbusiness +","+tmp;
			}
			Document Dhome = new Document("home",sdhome);
			Document Dbusiness = new Document("business",sdbusiness);
			Document test = new Document("home","['c1','c2','c3','c4']");
			this.collection.insertOne(test);
			this.collection.insertOne(Dhome);
			this.collection.insertOne(Dbusiness);
	}
	
	public static void main(String args[]){
		ViewsType a = new ViewsType();
		a.load();
	}
}
