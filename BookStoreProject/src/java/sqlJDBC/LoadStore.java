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
public class LoadStore {
    static private Connection conn;
    static private ResultSet rs = null;
    
    public static String[] load(String tid, String pid) throws ClassNotFoundException{
        //store[0]:store id, store[1]:region
        String[] store = new String[2];
        PreparedStatement ps = null;       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/booksys";
            conn = DriverManager.getConnection(connectionURL, "root", "root");
            ps = conn.prepareStatement("select store_id from transaction where transaction_id = ? and product_id = ?");
            ps.setObject(1, tid);
            ps.setObject(2, pid);
            rs = ps.executeQuery();
            String sid = "";
            if(rs.next()) sid = rs.getString(1);
            ps = conn.prepareStatement("select state from store where id = ?");
            ps.setObject(1, sid);   
            rs = ps.executeQuery();
            if(rs.next()){
                store[0] = sid;
                store[1] = rs.getString(1);
            }
             conn.close();            
        } catch (SQLException se) {
            se.printStackTrace();
        }       
        return store;
    }
}
