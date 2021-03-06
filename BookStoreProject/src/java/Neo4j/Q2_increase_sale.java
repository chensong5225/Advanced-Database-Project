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
import org.neo4j.driver.internal.value.ValueAdapter;
import Neo4j.beans.Q2_result;

public class Q2_increase_sale {
    private Driver driver;
    private Neo4jcon con;
    private ArrayList<Q2_result> result;
    private String id;
    private float change;
    public Q2_increase_sale(){
        con = new Neo4jcon();
        driver = con.driver;
        result = new ArrayList<>();
}
    public ArrayList<Q2_result> answer(String date1,String date2){
        try (Session s = driver.session()) {
                try (Transaction tx = s.beginTransaction()) {
                    StatementResult sr = tx.run("match(n:Fact{time:{time1}}),(m:Fact{time:{time2}}) "
                            + " where n.store_id=m.store_id "
                            + " with n.store_id as id,sum(toFloat(n.sale))as sale1,sum(toFloat(m.sale))as sale2 "
                            + " return id,toFloat(toInteger(sale1)-toInteger(sale2)) as change", parameters("time1",date1,"time2",date2));
                    tx.success();
                    while(sr.hasNext()){
                        Q2_result q2 = new Q2_result();
                        Record record = sr.next();
                        id = record.get("id").asString();
                        change = record.get("change").asFloat();
                        String change2 = Float.toString(change);
                        q2.setId(id);
                        q2.setProfit(change2);
                        result.add(q2);
                    }
                }
        }
        return result;
    }
}

