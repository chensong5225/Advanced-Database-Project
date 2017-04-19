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
import SQL.Aggregation.Q7DemandCurve;

public class Q7_demand_curve {
    private Neo4jcon con;
    private  Driver driver;
    private float price;
    private float sale;
    private ArrayList<Float> pricelist;
    private ArrayList<Float> salelist;
    private Q7_result result;
    public Q7_demand_curve(){
        con = new Neo4jcon();
        driver = con.driver;
        result = new Q7_result();
        pricelist = new ArrayList<>();
        salelist = new ArrayList<>();
    }
    public Q7_result answer(String id){
        try (Session s = driver.session()) {
                    try (Transaction tx = s.beginTransaction()) {
                        StatementResult sr = tx.run("match(n:Fact{product_id:{id}})" + " return toInteger(n.price) as price,sum(toInteger(n.sale)) as sale", parameters("id",id));
                        tx.success();
                        while (sr.hasNext()) {
                            Record record = sr.next();
                            price = record.get("price").asFloat();
                            String price2 = Float.toString(price);
//                            System.out.println("price: "+price2);
                            sale = record.get("sale").asFloat();
                            String sale2 = Float.toString(sale);
//                            System.out.println("sale: "+sale2);
                            pricelist.add(price);
                            salelist.add(sale);
                            result.setPricelist(pricelist);
                            result.setSalelist(salelist);
                        }
                    }
                }
        return result;
    }
}
