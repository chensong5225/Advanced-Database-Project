/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.Aggregation;

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
        PreparedStatement update = null;
        ResultSet rs = null;
        try {
            conn = SQLConnectSQL.getConn();
            ps = conn.prepareStatement("DROP TABLE IF EXISTS customer_dim");
            ps.executeUpdate();
            ps = conn.prepareStatement("CREATE TABLE customer_dim (customer_id int(11) NOT NULL, type varchar(45) NOT NULL)");            
            ps.executeUpdate();
            ps = conn.prepareStatement("Insert into customer_dim select id, type from customer");
            ps.executeUpdate();
            
            ps = conn.prepareStatement("Select id, category from business_customer");
            rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String category = rs.getString(2);
                update = conn.prepareStatement("Update customer_dim SET type = ? where customer_id = ?");
                update.setObject(1, category);
                update.setObject(2, id);
                update.executeUpdate();
            }           
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
