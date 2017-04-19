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
import java.util.HashMap;

/**
 *
 * @author surface
 */
public class Q9StoreCompare{
    static private Connection conn;
    static private ResultSet rs = null;
    
    public HashMap<String, Double> storeCompare() throws ClassNotFoundException{
        
        HashMap<String, Double> map = new HashMap<>();
        PreparedStatement ps = null;       
        try {
            conn = SQLConnectSQL.getConn();
            ps = conn.prepareStatement("select store_id, sum(sale) from fact group by store_id");
            rs = ps.executeQuery();
            while(rs.next()){
                String store = rs.getString(1);
                double sum = rs.getDouble(2);
                map.put(store, sum);
            }
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }       
        return map;
    }
}
