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
import static org.neo4j.driver.v1.Values.parameters;
import java.util.ArrayList;

public class loadFact {

    private Driver driver;
    private Connection con;
    private ArrayList<String[]> list;
    private getFact getf;
    private String product_id;
    private String amount;
    private String cost;
    private String store_id;
    private String customer_id;
    private String sale;
    private String week;

    public loadFact() {
        con = new Connection();
        driver = con.driver;
        list = new ArrayList<>();
        getf = new getFact();
    }

    public void load() {
        list = getf.load();
        try (Session s = driver.session()) {
            try (Transaction tx = s.beginTransaction()) {
                StatementResult sr = tx.run("match (a:Fact) delete a",parameters());
                tx.success();
            }
        }
        for (String[] str : list) {
            product_id = str[0];
            amount = str[1];
            cost = str[2];
            store_id = str[3];
            customer_id = str[4];
            sale = str[5];
            week = str[6];
            try (Session s = driver.session()) {
                try (Transaction tx = s.beginTransaction()) {
                    
                    StatementResult sr = tx.run("CREATE(a:Fact{product_id:{id},amount:{amount},cost:{cost},store_id:{store_id},customer_id:{customer_id},sale:{sale},week:{week}})",
                            parameters("id", product_id, "amount", amount, "cost", cost, "store_id", store_id, "customer_id", customer_id, "sale", sale, "week", week));
                    tx.success();
                    
                }
            }
        }
        System.out.println("finish loading Fact");
    }
}
