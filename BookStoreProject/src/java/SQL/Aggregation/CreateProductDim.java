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
public class CreateProductDim {
    public static void create(){
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = SQLConnectSQL.getConn();
            ps = conn.prepareStatement("DROP TABLE IF EXISTS product_dim");
            ps.executeUpdate();
            ps = conn.prepareStatement("CREATE TABLE product_dim (product_id int(11) NOT NULL, name varchar(45) NOT NULL, cost decimal(10,2), category varchar(45) NOT NULL)");            
            ps.executeUpdate();
            ps = conn.prepareStatement("Insert into product_dim select id,name, cost, category from product");
            ps.executeUpdate();
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
