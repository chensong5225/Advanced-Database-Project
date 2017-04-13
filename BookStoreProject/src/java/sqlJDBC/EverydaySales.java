/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlJDBC;

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
public class EverydaySales {
    static private Connection conn;
    static private ResultSet rs = null;
    
    public static HashMap<String, HashMap<String, HashMap<String, Double>>> sales() throws ClassNotFoundException{
        HashMap<String, HashMap<String, HashMap<String, Double>>> map = new HashMap<>();
        PreparedStatement ps = null;       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/booksys";
            conn = DriverManager.getConnection(connectionURL, "root", "root");
            ps = conn.prepareStatement("select transaction.product_id, time, sum(sale), sum(amount), product.cost from transaction, product where transaction.product_id = product.id group by transaction.product_id, time");
            rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String time = rs.getString(2);
                int salePrev = (int) rs.getDouble(3) * 100;
                double sale = salePrev / 100;
                int amount = (int) rs.getDouble(4);
                int costPrev = (int) rs.getDouble(5) * 100;
                double cost = costPrev / 100;
                double profit = sale - amount * cost;
                if(!map.containsKey(id)){
                    HashMap<String, Double> timeMap = new HashMap<>();
                    timeMap.put("sales", sale);
                    timeMap.put("profit", profit);
                    HashMap<String, HashMap<String, Double>> productMap = new HashMap<>();
                    productMap.put(time, timeMap);
                    map.put(id, productMap);
                }else{
                    HashMap<String, Double> timeMap = new HashMap<>();
                    timeMap.put("sales", sale);
                    timeMap.put("profit", profit);
                    map.get(id).put(time, timeMap);
                }                
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }       
        return map;
    }
}
