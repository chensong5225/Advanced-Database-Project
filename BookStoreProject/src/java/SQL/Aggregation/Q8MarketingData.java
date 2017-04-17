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
    
    public static ArrayList<String> show(String product, String week) throws ClassNotFoundException{
        ArrayList<String> list = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/booksys";
            conn = DriverManager.getConnection(connectionURL, "root", "root");
            ps = conn.prepareStatement("select customer.name, week, count(transaction_id) from transaction, product, customer where customer.id = transaction.customer_id and product.id = transaction.product_id and product_name = ? and week = ? group by customer_id, week");            
            ps.setObject(1, product);
            ps.setObject(2, week);            
            rs = ps.executeQuery();            
            while(rs.next()){
                if(rs.getInt(3) > 2){
                    list.add(rs.getString(1));
                }
            }           
        } catch (SQLException se) {
            se.printStackTrace();
        }        
        return list;
    }
}
