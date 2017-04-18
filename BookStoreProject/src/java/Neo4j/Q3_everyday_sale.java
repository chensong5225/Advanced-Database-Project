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

public class Q3_everyday_sale {

    private Neo4jcon con;
    private Driver driver;
    private String product;
    private String sale;
    private List result;
    private String profit;

    public Q3_everyday_sale() {
        con = new Neo4jcon();
        driver = con.driver;
    }

    public List answer(String mode) {
        if (mode.equalsIgnoreCase("top")) {
            if (mode.equalsIgnoreCase("profit")) {
                try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run("match (n:Fact),(m:Product_D) "
                                + "where n.product_id = m.id with m,sum(toFloat(n.totalcost)) as cost,sum(toFloat(n.sale)) as sale,n.product_id as id "
                                + "return m.name as name,toFloat(sale)-toFloat(cost) as profit"
                                + "order by totalsale desc limit 5", parameters());
                        tx.success();
                        while (sr.hasNext()) {
                            Record record = sr.next();
                            profit = record.get("profit").asString();
                            product = record.get("name").asString();
                            String temp = "";
                            temp = temp + product + "     " + profit;
                            result.add(temp);
                        }
                    }
                }
            }
            else{
                try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run("match (n:Fact),(m:Product_D) "
                                + "where n.product_id = m.id with m,sum(toFloat(n.totalcost)) as cost,sum(toFloat(n.sale)) as sale,n.product_id as id "
                                + "return m.name as name,toFloat(sale)-toFloat(cost) as profit"
                                + "order by totalsale desc limit 5", parameters());
                        tx.success();
                        while (sr.hasNext()) {
                            Record record = sr.next();
                            profit = record.get("profit").asString();
                            product = record.get("name").asString();
                            String temp = "";
                            temp = temp + product + "     " + profit;
                            result.add(temp);
                
            }
        }
        return result;

    }
}
