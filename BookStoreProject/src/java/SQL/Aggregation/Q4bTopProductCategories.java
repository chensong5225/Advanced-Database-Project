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
 * @author yuq
 */
public class Q4bTopProductCategories {
    public void maintain(String date){
        Connection conn;
        PreparedStatement ps = null;
        PreparedStatement nestps = null;
        ResultSet rs = null;
        ResultSet nestrs = null;
        String viewName = "TopProductCategories_" + RemoveDateSlash.remove(date);
        
        try {
            conn = SQLConnectSQL.getConn();
            
            ps = conn.prepareStatement("Drop View if exists " + viewName);
            ps.executeUpdate();
            ps = conn.prepareStatement("Create View " + viewName +  " as Select category, sum(sale) as sales from fact, product_dim where fact.product_id = product_dim.product_id and time = ? group by category order by sales desc limit 1");
            ps.setObject(1, date);
            ps.executeUpdate();
            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
