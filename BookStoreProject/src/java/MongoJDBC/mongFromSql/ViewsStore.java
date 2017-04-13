package MongoJDBC.mongFromSql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.bson.Document;
import MongoJDBC.connectMongo.MongoDbCon;

public class ViewsStore extends MongoDbCon{
	public void load(){
		Connect("finalproject","storeCol");
		/*
		 * Store load from Sql
		 */
		List<Document> storeList = new ArrayList<Document>();
		
		//load data from metdata
		HashMap<String,HashMap<String,String> > metadata = new HashMap<>();
				//test
//				HashMap<String, String> value = new HashMap<String,String>();
//				value.put("2017-02-13", "10");
//				value.put("2017-03-13", "20");
//				metadata.put("store1", value);
		Iterator it = metadata.entrySet().iterator();
		while (it.hasNext()) {
			 Map.Entry<String, HashMap> entry= (Map.Entry<String, HashMap>) it.next();
			 //get storeId
			String storeId = entry.getKey();
			HashMap<String, String> date_sale = entry.getValue();
			//get date&sale of this store
			Document doc_date_sale = new Document();
			Iterator it2 = date_sale.entrySet().iterator();
			while (it2.hasNext()) {
				Map.Entry<String, String> entry2= (Map.Entry<String, String>) it2.next();
				String date = (String) entry2.getKey();
				String sale = (String) entry2.getValue();
				doc_date_sale.append(date, sale);
			}
			storeList.add(new Document(storeId,doc_date_sale));
		}
		collection.insertMany(storeList);
	}
	
	public static void main(String args[]){
		ViewsStore a = new ViewsStore();
		a.load();
	}
}
