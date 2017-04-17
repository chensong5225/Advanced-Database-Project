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
import java.util.ArrayList;

/**
 *
 * @author yuq
 */
public class Q8MarketingData {
    static private Connection conn;
    static private ResultSet rs = null;
    
    public static ArrayList<String> show(String product) throws ClassNotFoundException{
        ArrayList<String> list = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/booksys";
            conn = DriverManager.getConnection(connectionURL, "root", "root");
            ps = conn.prepareStatement("select fact.product_id, fact.price, sum(sale) as sales from fact, product_dim where fact.product_id = product_dim.product_id and product_dim.name = ? group by fact.price");            
            ps.setObject(1, product);
            rs = ps.executeQuery();            
            while(rs.next()){
                price.add(rs.getDouble(2));
                sales.add(rs.getDouble(3));
            }
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
        
        return list;
    }
}
