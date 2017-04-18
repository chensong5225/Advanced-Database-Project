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

public class Q1_ratio {
    private Driver driver;
    private Neo4jcon con;
    private Float result;
    public Q1_ratio(){
        con = new Neo4jcon();
        driver = con.driver;
    }
    public Float answer(){
        try (Session s = driver.session()) {
                try (Transaction tx = s.beginTransaction()) {
                    StatementResult sr = tx.run("match (n:Customer_D),(m:Customer_D{category:'home'}) where n.category<>'home' return toFloat(count(n))/ toFloat(count(m)) as Ratio", parameters());
                    tx.success();
                    Record record = sr.next();
                    result = record.get("Ratio").asFloat();
                }
            }
        return result;
    }
}
