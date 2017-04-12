/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlJDBC;

/**
 *
 * @author yuq
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author surface
 */
public class LoadCustomer {
    static private Connection conn;
    static private ResultSet rs = null;
    
    public static String[] load(String tid, String pid) throws ClassNotFoundException{
        
        String[] customer = new String[2];
        PreparedStatement ps = null;       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/booksys";
            conn = DriverManager.getConnection(connectionURL, "root", "root");
            ps = conn.prepareStatement("select customer_id from transaction where transaction_id = ? and product_id = ?");
            ps.setObject(1, tid);
            ps.setObject(2, pid);
            rs = ps.executeQuery();
            String cid = "";
            if(rs.next()) cid = rs.getString(1);
            ps = conn.prepareStatement("select type from customer where id = ?");
            ps.setObject(1, cid);   
            rs = ps.executeQuery();
            String type = "";
            if(rs.next()) type = rs.getString(1);
            if(type.equals("home")){
                ps = conn.prepareStatement("select name from home_customer where id = ?");
                ps.setObject(1, cid);
                rs = ps.executeQuery();
                if(rs.next()){
                    customer[0] = rs.getString(1);
                    customer [1] = "home";
                }                
            }else if(type.equals("business")){
                ps = conn.prepareStatement("select name, category from business_customer where id = ?");
                ps.setObject(1, cid);
                rs = ps.executeQuery();
                if(rs.next()){
                    customer[0] = rs.getString(1);
                    customer[1] = rs.getString(2);
                }
            }
            
        } catch (SQLException se) {
            se.printStackTrace();
        }       
        return customer;
    }
}
