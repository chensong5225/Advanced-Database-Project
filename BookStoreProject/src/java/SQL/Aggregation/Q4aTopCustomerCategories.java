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
public class Q4aTopCustomerCategories {
    public static void maintain(String date){
        Connection conn;
        PreparedStatement ps = null;
        String viewName = "TopProductCategories_" + RemoveDateSlash.remove(date);
        
        try {
            conn = SQLConnectSQL.getConn();
            
            ps = conn.prepareStatement("Drop View if exists " + viewName);
            ps.executeUpdate();
            ps = conn.prepareStatement("Create View " + viewName +  " as Select type, sum(sale) as sales from customer_dim, fact where fact.customer_id = customer_dim.customer_id and time = ? group by type order by sales desc limit 2");
            ps.setObject(1, date);
            ps.executeUpdate();
            
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
