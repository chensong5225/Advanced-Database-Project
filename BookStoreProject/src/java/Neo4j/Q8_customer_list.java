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

public class Q8_customer_list {
    private Neo4jcon con;
    private  Driver driver;
    private String customer_id;
    private String product_id;
    private ArrayList<Q8_result> result;
    
    public Q8_customer_list(){
        con = new Neo4jcon();
        driver = con.driver;
        result = new ArrayList<>();
    }
    public ArrayList answer(String week){
        try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run(""
                                + " match(n:Fact{week:{week}})"
                                + " with count(n.product_id) as count,n.customer_id as id,n.product_id as product"
                                + " where count>2"
                                + " return id,product", parameters("week",week));
                        tx.success();
                        while (sr.hasNext()) {
                            Q8_result q8 = new Q8_result();
                            Record record = sr.next();
                            customer_id = record.get("id").asString();
                            product_id = record.get("product").asString();
                   
                            q8.setCustomer_id(customer_id);
                            q8.setProduct_id(product_id);
                            result.add(q8);

                        }
                    }
                }
        
        return result;
    }
    
}
