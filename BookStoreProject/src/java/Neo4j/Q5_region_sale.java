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

public class Q5_region_sale {
    private Neo4jcon con;
    private  Driver driver;
    private String sale;
    private String region;
    private List result;
    
    public Q5_region_sale(){
        con = new Neo4jcon();
        driver = con.driver;
        result = new ArrayList();
    }
    public List answer(){
        try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run("match (a:Fact),(d:Store_D)"
                                + "where a.store_id=d.id"
                                + "with d,sum(toFloat(a.sale))as sales"
                                + "return d.region as region,sum(sales) as sale", parameters());
                        tx.success();
                        while (sr.hasNext()) {
                            Record record = sr.next();
                            region = record.get("region").asString();
                            sale = record.get("sale").asString();
                            String temp = "";
                            temp = temp + region + "     " + sale;
                            result.add(temp);
                        }
                    }
                }
        return result;
    }
    
}
