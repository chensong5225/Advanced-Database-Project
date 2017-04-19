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
import java.util.List;
import Neo4j.beans.*;

public class Q6_most_business {
    private Neo4jcon con;
    private  Driver driver;
    private String category;
    private float sale;
    private ArrayList<Q6_result> result;
    public Q6_most_business(){
          con = new Neo4jcon();
        driver = con.driver;
        result = new ArrayList<>();
    }
    public ArrayList answer(String product){
         try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run("match (a:Fact{product_id:{id}}),(c:Customer_D)"
                                + " where a.customer_id=c.id"
                                + " with c,sum(toInteger(a.sale))as sales"
                                + " return c.type as category,sum(sales) as sale"
                                + " order by sale desc limit 1", parameters("id",product));
                        tx.success();
                        while (sr.hasNext()) {
                            Q6_result q6 = new Q6_result();
                            Record record = sr.next();
                            category = record.get("category").asString();
                            sale = record.get("sale").asFloat();
                            String sale2 = Float.toString(sale);
                            q6.setBusiness(category);
                            q6.setSale(sale2);
                            result.add(q6);
                        }
                    }
                }
         return result;
    }
}
