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

public class loadStore {

    private Driver driver;
    private Neo4jcon con;
    private ArrayList<String[]> list;
    private getStore gets;
    private String store_id;
    private String region;

    public loadStore() {
        con = new Neo4jcon();
        driver = con.driver;
        list = new ArrayList<>();
        gets = new getStore();
    }

    public void load() {
        list = gets.load();
        try (Session s = driver.session()) {
            try (Transaction tx = s.beginTransaction()) {
                StatementResult sr = tx.run("match (a:Store_D) delete a", parameters());
                tx.success();
            }
        }
        for (String[] str : list) {
            store_id = str[0];
            region = str[1];
            try (Session s = driver.session()) {
                try (Transaction tx = s.beginTransaction()) {
                    StatementResult sr = tx.run("CREATE (a:Store_D{id:{id},region:{region}})", parameters("id", store_id, "region", region));
                    tx.success();
                }
            }
        }
        System.out.println("finish loading Store_D");
    }
}
