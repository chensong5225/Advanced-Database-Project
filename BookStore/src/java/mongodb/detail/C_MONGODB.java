package detail;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

/**
 * 对于MongoDB 数据库操作的方法
 */
public class C_MONGODB  {

    /**
     * 将数据存储到MongoDB中。
     *
     * @param json       要存储到MongoDB数据库的字符串
     * @param collection MongoDB中集合的名称
     * @return 插入数据的主键
     * @throws Exception
     */
	public  DBCollection coll;
	public C_MONGODB(String dbname, String colname){
		  // 连接到 mongodb 服务
	      MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	      
	      // 连接到数据库 
	      DB db = mongoClient.getDB(dbname);  
	      System.out.println("Connect to database successfully");
	      // 连接到数据库表(集合) test 
	      coll = db.getCollection(colname);
	      System.out.println("集合"+colname+" 选择成功");
	}
	
    public String saveObjectByJson(String json, String collection) throws Exception {
//      DBCollection coll = MongoDBUtil.getCollection(collection);
        DBObject dbobject = (DBObject) JSON.parse(json);
        coll.save(dbobject);
        String oid = dbobject.get("_id").toString();
        
        return oid;
    }
}

