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
import java.util.ArrayList;
import net.sf.cglib.core.EmitUtils;
import static org.neo4j.driver.v1.Values.parameters;

public class Warehouse {
    private loadCustomer load_C;
    private loadFact load_F;
    private loadProduct load_P;
    private loadStore load_S;

	public Warehouse() {
            load_C = new loadCustomer();
            load_F = new loadFact();
            load_P = new loadProduct();
            load_S = new loadStore();
	}
       public void loadWarehouse(){
           load_C.load();
           load_F.load();
           load_P.load();
           load_S.load();
       }
	}
