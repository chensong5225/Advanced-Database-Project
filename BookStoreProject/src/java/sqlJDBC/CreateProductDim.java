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
public class CreateProductDim {
    public static void create(){
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConnectSQL.getConn();
            ps = conn.prepareStatement("DROP TABLE IF EXISTS product_dim");
            ps.executeUpdate();
            ps = conn.prepareStatement("CREATE TABLE product_dim (product_id int(11) NOT NULL,name varchar(45) NOT NULL,price float(11), cost float(11), category varchar(45) NOT NULL)");            
            ps.executeUpdate();
            ps = conn.prepareCall("Insert into product_dim select id,name, price, cost, category from product");
            ps.executeUpdate();
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
