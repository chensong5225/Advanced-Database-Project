/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Neo4j;

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
public class NewClass1 {

    public static void main(String[] args) {

        Neo4jcon con = new Neo4jcon();
        Driver driver = con.driver;
        List<Record> list;
        try (Session s = driver.session()) {
            try (Transaction tx = s.beginTransaction()) {
                StatementResult sr = tx.run("match (n:Product_D) return n.category as category,n.name as name,n.cost as cost,n.id as id,n.price as price", parameters());
                tx.success();
                while (sr.hasNext()) {
                    Record r = sr.next();
                    System.out.println("category " + r.get("category"));
                }
            }
        }

    }
}
