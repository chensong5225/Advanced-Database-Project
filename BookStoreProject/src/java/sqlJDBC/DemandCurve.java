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
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author surface
 */
public class DemandCurve {
    static private Connection conn;
    static private ResultSet rs = null;
    
    public static HashMap<String, HashMap<Double, Double>> demand() throws ClassNotFoundException{
        HashMap<String, HashMap<Double, Double>> map = new HashMap<>();
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/booksys";
            conn = DriverManager.getConnection(connectionURL, "root", "root");
            ps = conn.prepareStatement("select transaction.product_id, category, transaction.price, amount from transaction, product where transaction.product_id = product.id group by transaction.product_id");            
            rs = ps.executeQuery();            
            while(rs.next()){
                String category = rs.getString(2);
                double price = rs.getDouble(3);
                    double sale = rs.getDouble(4);
                if(map.containsKey(category)){                    
                    map.get(category).put(price, sale);
                }else{
                    HashMap<Double, Double> temp = new HashMap<>();
                    temp.put(price, sale);
                    map.put(category, temp);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }       
        return map;
    }
    public static void main(String args[]) throws ClassNotFoundException{
        DemandCurve a = new DemandCurve();
        a.demand();
    }
}
