/*?><
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
import  Neo4j.beans.Q1_result;

public class Q1_ratio {
    private Driver driver;
    private Neo4jcon con;
    private float result;
    private String result2;
//    private Q1_result q1_result;
    public Q1_ratio(){
        con = new Neo4jcon();
        driver = con.driver;
//        q1_result = new Q1_result();
    }
    public String answer(){
        try (Session s = driver.session()) {
                try (Transaction tx = s.beginTransaction()) {
                    StatementResult sr = tx.run("match (n:Customer_D),(m:Customer_D{type:'home'}) where n.type<>'home' return toInteger(count(n))/ toInteger(count(m)) as Ratio", parameters());
                    tx.success();
                    Record record = sr.next();
                    result = record.get("Ratio").asFloat();
                    result2 = Float.toString(result);
                    
//                    q1_result.setRatio(result);
                }
            }
        return result2;
    }
}
