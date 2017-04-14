package MongoJDBC.mongFromSql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.bson.Document;

import MongoJDBC.connectMongo.MongoDbCon;

public class ViewsProduct extends MongoDbCon{
	public void load(){
		//connect to MongoDb
		Connect("ADB_ware", "ViewProduct");
		/*
		 * Product collection
		 */
		List<Document> prdctList = new ArrayList<>();
		//get storeId
		Document doc_proId = new Document();
		HashMap<String, HashMap<String,HashMap<String,String>>> metadata = new HashMap<>();
		Iterator it1 = metadata.entrySet().iterator();
		while(it1.hasNext()){
			Map.Entry<String, HashMap>  entry=(Map.Entry<String, HashMap>) it1.next();
			String proId = entry.getKey();
			//get date
			Document doc_date = new Document();
			HashMap<String, HashMap> date = entry.getValue();
			Iterator it2 = date.entrySet().iterator();
			while (it2.hasNext()) {
				Map.Entry<String, HashMap> entry2 = (Map.Entry<String, HashMap>) it2.next();
				String datekey = entry2.getKey();
				//get sale and profit
				HashMap<String, String> sale_profit = entry2.getValue();
				String sales = sale_profit.get("sales");
				String profit = sale_profit.get("profit");
				doc_date.append(datekey, new Document("sales",sales).append("profit", profit));
			}
			doc_proId.append(proId,doc_date);
			prdctList.add(doc_proId);
		}
		this.collection.insertMany(prdctList);
	}
}
