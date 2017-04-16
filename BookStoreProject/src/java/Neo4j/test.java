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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import static org.neo4j.driver.v1.Values.parameters;

import sqlJDBC.ConnectSQL;

public class test {

    private Driver driver;
    private Neo4jcon con;
    private List<Record> list;
    private List<Product> result;

    public test() {
        Neo4jcon con = new Neo4jcon();
        Driver driver = con.driver;
        result = new ArrayList<Product>();
    }
    public List<Product> first() {
        
        try(Session s = driver.session()){
            try (Transaction tx = s.beginTransaction()) {
                StatementResult sr = tx.run("match (n:Product_D) return n.category as category,n.name as name,n.cost as cost,n.id as id,n.price as price", parameters());
                tx.success();
                while(sr.hasNext()){
                        Record record = sr.next();
                        System.out.println(record.get("category").asString());
                        Product p = new Product();
                        p.setCategory(record.get("category").asString());
                        p.setCost(record.get("cost").asString());
                        p.setId(record.get("id").asString());
                        p.setName(record.get("name").asString());
                        p.setPrice(record.get("price").asString());
                        System.out.print(p.getCategory()+p.getCost()+p.getId()+p.getName()+p.getPrice());
                        result.add(p);
                }
            }
        }
        return result;
    }
}

    
