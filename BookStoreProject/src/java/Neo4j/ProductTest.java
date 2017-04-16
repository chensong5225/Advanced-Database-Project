/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Neo4j;

import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import static org.neo4j.driver.v1.Values.parameters;

/**
 *
 * @author hom19
 */
public class ProductTest {
    private List product;
    private Neo4jcon con;
    private Driver driver;
    public ProductTest(){
        product = new ArrayList();
        con = new Neo4jcon();
        driver = con.driver;
    }
    public List first(){
        try(Session s = driver.session()){
            try(Transaction tx = s.beginTransaction()){
                StatementResult sr = tx.run("match (n:Product_D) return n.category as category,n.name as name,n.cost as cost,n.id as id,n.price as price", parameters());
                tx.success();
                Record record;
                while(sr.hasNext()){
                    record = sr.next();
                    Product p = new Product();
                    p.setCategory(record.get("category").asString());
                    product.add(p);
                    
                }
            }
        }
        return  product;
    }
}
