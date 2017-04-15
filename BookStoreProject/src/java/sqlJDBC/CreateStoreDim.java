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
public class CreateStoreDim {
    public static void create(){
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConnectSQL.getConn();
            ps = conn.prepareStatement("DROP TABLE IF EXISTS store_dim");
            ps.executeUpdate();
            ps = conn.prepareStatement("CREATE TABLE store_dim (store_id varchar(45) NOT NULL,vregion varchar(45) NOT NULL)");            
            ps.executeUpdate();
            ps = conn.prepareCall("Insert into store_dim select id,state from store");
            ps.executeUpdate();
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
