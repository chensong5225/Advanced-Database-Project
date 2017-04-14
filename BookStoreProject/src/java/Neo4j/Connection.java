/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Neo4j;

/**
 *
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
public class Connection {
    public Driver driver;
	private static String username = "neo4j";
	private static String password = "130127";
	
	public Connection(){
		driver = GraphDatabase.driver("bolt://localhost:7687",AuthTokens.basic(username, password));
	}
    
}
