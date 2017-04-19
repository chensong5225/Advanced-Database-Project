/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.Aggregation;

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
public class Q5RegionCompare {
    static private Connection conn;
    static private ResultSet rs = null;
    
    public HashMap<String, Double> regionCompare() throws ClassNotFoundException{
        
        HashMap<String, Double> map = new HashMap<>();
        PreparedStatement ps = null;       
        try {
            conn = SQLConnectSQL.getConn();
            ps = conn.prepareStatement("select region, sum(sale) from fact, store_dim where fact.store_id = store_dim.store_id group by region");
            rs = ps.executeQuery();
            while(rs.next()){
                String region = rs.getString(1);
                double sum = rs.getDouble(2);
                map.put(region, sum);
            }
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }       
        return map;
    }
}
