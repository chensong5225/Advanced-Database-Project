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

public class Q8_customer {
     private Neo4jcon con;
    private  Driver driver;
    private String category;
    private String sale;
    private List result;
    public Q8_customer(){
         con = new Neo4jcon();
        driver = con.driver;
        result = new ArrayList();
    }
    public List answer(){
        try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run("match (a:Fact{product_id:{id}}),(c:Customer_D)"
                                + "where a.customer_id=c.id"
                                + "with c,sum(toFloat(a.sale))as sales"
                                + "return c.category as category,sum(sales) as sale", parameters("id",product));
                        tx.success();
                        while (sr.hasNext()) {
                            Record record = sr.next();
                            category = record.get("category").asString();
                            sale = record.get("sale").asString();
                            String temp = "";
                            temp = temp + category + "     " + sale;
                            result.add(temp);
                        }
                    }
                }
        return result;
    }
    
}
