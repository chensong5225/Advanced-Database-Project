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
public class CreateCustomerDim {
    public static void create(){
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConnectSQL.getConn();
            ps = conn.prepareStatement("DROP TABLE IF EXISTS customer_dim");
            ps.executeUpdate();
            ps = conn.prepareStatement("CREATE TABLE customer_dim (customer_id int(11) NOT NULL, type varchar(45) NOT NULL)");            
            ps.executeUpdate();
            ps = conn.prepareCall("Insert into customer_dim select id, type from customer");
            ps.executeUpdate();
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
