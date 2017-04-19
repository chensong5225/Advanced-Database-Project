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
import Neo4j.beans.Q4_result;

public class Q4_top_category {

    private Neo4jcon con;
    private Driver driver;
    private float sale;
    private String category;
    private ArrayList<Q4_result> result;

    public Q4_top_category() {
        con = new Neo4jcon();
        driver = con.driver;
        result = new ArrayList();
    }

    public ArrayList answer(String mode) {
        if (mode.contains("customer")) {
            try (Session s = driver.session()) {
                try (Transaction tx = s.beginTransaction()) {
                    StatementResult sr = tx.run("match (a:Fact),(d:Customer_D) "
                            + " where a.customer_id=d.id"
                            + " with d,sum(toInteger(a.sale))as sales"
                            + " return d.type as category,sum(sales)as sale order by sale desc limit 2", parameters());
                    tx.success();
                    while (sr.hasNext()) {
                        Q4_result q4 = new Q4_result();
                        Record record = sr.next();
                        category = record.get("category").asString();
                        sale = record.get("sale").asFloat();
                        String sale2 = Float.toString(sale);
                        q4.setCategory(category);
                        q4.setSale(sale2);
                        result.add(q4);
                    }
                }
            }
        } else {
            try (Session s = driver.session()) {
                try (Transaction tx = s.beginTransaction()) {
                    StatementResult sr = tx.run("match (a:Fact),(d:Product_D)"
                            + " where a.product_id=d.id"
                            + " with d,sum(toInteger(a.sale))as sales"
                            + " return d.category as category,sum(sales)as sale order by sale desc limit 2", parameters());
                    tx.success();
                    while (sr.hasNext()) {
                        Q4_result q4 = new Q4_result();
                        Record record = sr.next();
                        category = record.get("category").asString();
                        sale = record.get("sale").asFloat();
                        String sale2 = Float.toString(sale);
                        q4.setCategory(category);
                        q4.setSale(sale2);
                        result.add(q4);
                    }
                }
            }
        }
        return result;
    }
}
