/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Neo4j;

/**
 *
 * @author hom19
 */
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import java.util.ArrayList;
import static org.neo4j.driver.v1.Values.parameters;

public class Warehouse {
    Driver driver;
	Connection con;

	public Warehouse() {
		con = new Connection();
		driver = con.driver;
	}

	private void creatCustomer() {
		try (Session s = driver.session()) {
			try (Transaction tx = s.beginTransaction()) {
				StatementResult sr = tx.run("MATCH (a:Transaction) " + "RETURN a.name AS name", parameters());
				ArrayList<Record> result = (ArrayList<Record>) sr.list();
//				while (sr.hasNext()) {
//					Record record = sr.next();
//					System.out.println(String.format("%s", record.get("name").asString()));
//				}
//				for (Record record : result) {
//					System.out.println(String.format("%s", record.get("name").asString()));
//				}
			}
		}
	}
	private void creatStore(){//wait qiuyu
		try (Session s = driver.session()) {
			try (Transaction tx = s.beginTransaction()) {
				StatementResult sr = tx.run("MATCH (a:Transaction) " + "RETURN a.store AS store", parameters());
				ArrayList<Record> result = (ArrayList<Record>) sr.list();
			}
		}
	}
        private void creatProduct(){
            try (Session s = driver.session()) {
			try (Transaction tx = s.beginTransaction()) {
				StatementResult sr = tx.run("MATCH (a:Transaction) " + "RETURN a.store AS store", parameters());
				ArrayList<Record> result = (ArrayList<Record>) sr.list();
			}
		}
}
        public void closeDriver(){
            driver.close();
        }
}
