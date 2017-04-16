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

public class loadCustomer {

    private Driver driver;
    private Neo4jcon con;
    private ArrayList<String[]> list;
    private getCustomer getc;
    private String customer_id;
    private String category;

    public loadCustomer() {
        con = new Neo4jcon();
        driver = con.driver;
        list = new ArrayList<>();
        getc = new getCustomer();
    }

    public void load() {
        list = getc.load();
        try (Session s = driver.session()) {
            try (Transaction tx = s.beginTransaction()) {
                StatementResult sr = tx.run("match (a:Customer_D) delete a", parameters());
                tx.success();
            }
        }
        for (String[] str : list) {
            customer_id = str[0];
            category = str[1];
            try (Session s = driver.session()) {
                try (Transaction tx = s.beginTransaction()) {
                    StatementResult sr = tx.run("CREATE (a:Customer_D{id:{id},category:{category}})", parameters("id", customer_id, "category", category));
                    tx.success();
                }
            }
        }
        System.out.println("finish loading Customer_D");
    }
}
