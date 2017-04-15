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

public class loadProduct {
    private Driver driver;
    private Connection con;
    private ArrayList<String[]> list;
    private getProduct getp;
    private String product_id;
    private String name;
    private String cost;
    private String price;
    private String category;
    public loadProduct(){
        con = new Connection();
        driver = con.driver;
        list = new ArrayList<>();
        getp = new getProduct();
    }
    public void load(){
        list = getp.load();
         try (Session s = driver.session()) {
                try (Transaction tx = s.beginTransaction()) {
                    StatementResult sr = tx.run("match (a:Product_D) delete a", 
                            parameters());
                    tx.success();
                }
            }
        for (String[] str : list) {
            product_id = str[0];
            name = str[1];
            cost = str[2];
            price = str[3];
            category = str[4];
            try (Session s = driver.session()) {
                try (Transaction tx = s.beginTransaction()) {
                    StatementResult sr = tx.run("CREATE (a:Product_D{id:{id},name:{name},cost:{cost},price:{price},category:{category}})", 
                            parameters("id",product_id, "name",name,"cost",cost,"price",price,"category",category));
                    tx.success();
                }
            }
        }
        System.out.println("finish loading Product_D");
    }
}
