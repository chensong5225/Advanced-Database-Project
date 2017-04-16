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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author yuq
 */
public class Q3EverydaySales {
    public static void maintain(String date){
        Connection conn;
        PreparedStatement ps = null;
        PreparedStatement nestps = null;
        ResultSet rs = null;
        ResultSet nestrs = null;
        String str = RemoveDateSlash.remove(date);
        String viewName = "";
        HashMap<String, double[]> map = new HashMap<>();
        //key: product_id
        //array[0]: sales, array[1]: amount, array[2]: cost, array[3]: profit(= amount * cost) 
        try {
            conn = SQLConnectSQL.getConn();
            
            //top 5 sales
            viewName = "EverydayTop5SalesView_" + str;
            ps = conn.prepareStatement("Drop View if exists " + viewName);
            ps.executeUpdate();
            ps = conn.prepareStatement("Create View " + viewName +  " as Select fact.product_id, name, sum(sale) as sales from fact, product_dim where product_dim.product_id = fact.product_id and fact.time=? group by fact.product_id order by sales desc limit 5");
            ps.setObject(1, date);
            ps.executeUpdate();
            
            //bottom 5 sales
            viewName = "EverydayBottom5SalesView_" + str;
            ps = conn.prepareStatement("Drop View if exists " + viewName);
            ps.executeUpdate();
            ps = conn.prepareStatement("Create View " + viewName +  " as Select fact.product_id, name, sum(sale) as sales from fact, product_dim where product_dim.product_id = fact.product_id and fact.time=? group by fact.product_id order by sales asc limit 5");
            ps.setObject(1, date);
            ps.executeUpdate();
            
            //top 5 profit
            viewName = "EverydayTop5ProfitView_" + str;
            ps = conn.prepareStatement("Drop View if exists " + viewName);
            ps.executeUpdate();
            ps = conn.prepareStatement("Create View " + viewName +  " as Select fact.product_id, name, sum(sale) - cost*amount as profit from fact, product_dim where product_dim.product_id = fact.product_id and fact.time=? group by fact.product_id order by profit desc limit 5");
            ps.setObject(1, date);
            ps.executeUpdate();
                  
            //bottom 5 profit
            viewName = "EverydayBottom5ProfitView_" + str;
            ps = conn.prepareStatement("Drop View if exists " + viewName);
            ps.executeUpdate();
            ps = conn.prepareStatement("Create View " + viewName +  " as Select fact.product_id, name, sum(sale) - cost*amount as profit from fact, product_dim where product_dim.product_id = fact.product_id and fact.time=? group by fact.product_id order by profit asc limit 5");
            ps.setObject(1, date);
            ps.executeUpdate();
            
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    
}
