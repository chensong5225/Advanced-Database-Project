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

public class Q4_top_category {
    private Neo4jcon con;
    private  Driver driver;
    private String sale;
    private String category;
    private List result;
    public Q4_top_category(){
        con = new Neo4jcon();
        driver = con.driver;
        result = new ArrayList();
    }
    public List answer(String mode){
        if(mode.contains("customer")){
            try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run("match (a:Fact),(d:Customer_D) "
                                + "where a.customer_id=d.id"
                                + "with d,sum(toFloat(a.sale))as sales"
                                + "return d.category as category,sum(sales)as sale order by sale desc limit 2", parameters());
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
        }
        else{
            try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run("match (a:Fact),(d:Product_D)"
                                + "where a.product_id=d.id"
                                + "with d,sum(toFloat(a.sale))as sales"
                                + "return d.category as category,sum(sales)as sale order by sale desc limit 2", parameters());
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
        }
        
        return null;
    
}
}
