/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author yuq
 */
public class CreateFact {
    public static void create(){
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConnectSQL.getConn();
            ps = conn.prepareStatement("DROP TABLE IF EXISTS fact");
            ps.executeUpdate();
            ps = conn.prepareStatement("CREATE TABLE fact(product_id varchar(45) NOT NULL, amount int(11) NOT NULL, store_id varchar(45) NOT NULL, customer_id varchar(45) NOT NULL, time varchar(45), sale float(11) NOT NULL)");            
            ps.executeUpdate();
            ps = conn.prepareCall("Insert into fact select product_id,amount, store_id, customer_id, time, sum(sale) from transaction group by product_id,customer_id,store_id,time");
            ps.executeUpdate();
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
