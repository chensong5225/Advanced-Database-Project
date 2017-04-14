package MongoJDBC.mongFromSql;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;

import MongoJDBC.connectMongo.MongoDbCon;
import java.util.Arrays;
import sqlJDBC.RetrieveBusinessCustomer;
import sqlJDBC.RetrieveHomeCustomer;


public class ViewsType extends MongoDbCon{
	public void load() throws ClassNotFoundException{
		//connect to mongodb
		Connect("ADB_ware", "Viewtype");
                this.collection.drop();
		/*
		 * type collection
		*/
                    //load data from sql
                    List<String> home = new RetrieveBusinessCustomer().retrieveBusiness();
                    List<String> business = new RetrieveHomeCustomer().retrieveHome();
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
                    Document Dhome = new Document("home",home);
                    Document Dbusiness = new Document("business",business);
                    
                 
                    this.collection.insertOne(Dhome);
                    this.collection.insertOne(Dbusiness);
	}
	
	public static void main(String args[]) throws ClassNotFoundException{
		ViewsType a = new ViewsType();
		a.load();
	}
}
