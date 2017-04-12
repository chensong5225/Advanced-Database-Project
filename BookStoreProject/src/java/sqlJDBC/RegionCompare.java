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
import java.util.HashMap;

/**
 *
 * @author surface
 */
public class RegionCompare {
    static private Connection conn;
    static private ResultSet rs = null;
    
    public static HashMap<String, Integer> regionCompare() throws ClassNotFoundException{
        
        HashMap<String, Integer> map = new HashMap<>();
        PreparedStatement ps = null;       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/mysql";
            conn = DriverManager.getConnection(connectionURL, "root", "admin");
            ps = conn.prepareStatement("select region, sum(amount) from fact, store_dim where fact.store_id = store_dim.store_id group by region");
            rs = ps.executeQuery();
            while(rs.next()){
                String region = rs.getString(1);
                int sum = (int) rs.getDouble(2);
                map.put(region, sum);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }       
        return map;
    }
}
