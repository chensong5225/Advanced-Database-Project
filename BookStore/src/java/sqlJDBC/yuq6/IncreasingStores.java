/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuq6;

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
public class IncreasingStores {
    static private Connection conn;
    static private ResultSet rs = null;
    static private Statement st;
    public static HashMap<String, HashMap<String, String>> stores() throws ClassNotFoundException{
        HashMap<String, HashMap<String, String>> map = new HashMap<String, HashMap<String, String>>();
        ArrayList<String> storeList = new ArrayList<>();
        PreparedStatement ps = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/mysql";
            conn = DriverManager.getConnection(connectionURL, "root", "admin");
            ps = conn.prepareStatement("SELECT distinct store_id  from fact");
            rs = ps.executeQuery();
            while(rs.next()){
                storeList.add(rs.getString(1));
            }
            ps = conn.prepareStatement("SELECT time, sum(sale) from fact where store_id =? group by time");
            for(String s: storeList){
                 HashMap<String, String> store = new  HashMap<String, String>();
                 ps.setObject(1, s);
                 rs = ps.executeQuery();
                 while(rs.next()){
                    store.put(rs.getString(1), rs.getString(2));
                }
                 map.put(s, store);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        
        return map;
    }
}
