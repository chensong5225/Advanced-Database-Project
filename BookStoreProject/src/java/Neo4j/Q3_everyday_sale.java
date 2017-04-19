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
import  Neo4j.beans.Q3_result;

public class Q3_everyday_sale {

    private Neo4jcon con;
    private Driver driver;
    private String product;
    private float sale;
    private ArrayList<Q3_result> result;
    private float profit;

    public Q3_everyday_sale() {
        con = new Neo4jcon();
        driver = con.driver;
        result = new ArrayList<>();
    }

    public ArrayList answer(String mode) {
        if (mode.contains("top")) {
            if (mode.contains("profit")) {
                try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run("match (n:Fact),(m:Product_D) "
                                + " where n.product_id = m.id with m,sum(toInteger(n.totalcost)) as cost,sum(toInteger(n.sale)) as sale,n.product_id as id "
                                + " return m.name as name,toInteger(sale)-toInteger(cost) as profit"
                                + " order by profit desc limit 5", parameters());
                        tx.success();
                        while (sr.hasNext()) {
                            Q3_result q3 = new Q3_result();
                            Record record = sr.next();
                            profit = record.get("profit").asFloat();
                            product = record.get("name").asString();
                            String profit2 = Float.toString(profit);
                            q3.setProduct(product);
                            q3.setProfit(profit2);
                            result.add(q3);
                        }
                    }
                }
            } else {
                try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run("match (n:Fact),(m:Product_D) "
                                + " where n.product_id = m.id "
                                + " with m,sum(toInteger(n.totalcost)) as cost,sum(toInteger(n.sale)) as sale"
                                + " return m.name as name,sale"
                                + " order by sale desc limit 5", parameters());
                        tx.success();
                        while (sr.hasNext()) {
                            Q3_result q3 = new Q3_result();
                            Record record = sr.next();
                            sale = record.get("sale").asFloat();
                            product = record.get("name").asString();
                            String sale2 = Float.toString(sale);
                            q3.setProduct(product);
                            q3.setSale(sale2);
                            result.add(q3);
                        }
                    }
                }
            }
        }
        else{
            if(mode.contains("profit")){
                try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run("match (n:Fact),(m:Product_D) "
                                + " where n.product_id = m.id with m,sum(toInteger(n.totalcost)) as cost,sum(toInteger(n.sale)) as sale,n.product_id as id "
                                + " return m.name as name,toInteger(sale)-toInteger(cost) as profit"
                                + " order by profit asc limit 5", parameters());
                        tx.success();
                        while (sr.hasNext()) {
                            Q3_result q3 = new Q3_result();
                            Record record = sr.next();
                            profit = record.get("profit").asFloat();
                            product = record.get("name").asString();
                            String profit2 = Float.toString(profit);
                            q3.setProduct(product);
                            q3.setProfit(profit2);
                            result.add(q3);
                        }
                    }
                }
            }
            else{
                try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run("match (n:Fact),(m:Product_D) "
                                + " where n.product_id = m.id "
                                + " with m,sum(toInteger(n.totalcost)) as cost,sum(toInteger(n.sale)) as sale"
                                + " return m.name as name,sale"
                                + " order by sale asc limit 5", parameters());
                        tx.success();
                        while (sr.hasNext()) {
                            Q3_result q3 = new Q3_result();
                            Record record = sr.next();
                            sale = record.get("sale").asFloat();
                            product = record.get("name").asString();
                            String sale2 = Float.toString(sale);
                            q3.setProduct(product);
                            q3.setSale(sale2);
                            result.add(q3);
                        }
                    }
                }
            }
        }
        return result;
    }
}
