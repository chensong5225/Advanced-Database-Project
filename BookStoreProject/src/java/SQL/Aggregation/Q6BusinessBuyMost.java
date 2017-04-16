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
 * @author surface
 */
public class Q6BusinessBuyMost {
    static private Connection conn;
    static private ResultSet rs = null;
    
    public static ArrayList<String> buyMost(String product) throws ClassNotFoundException{
        ArrayList<String> res = new ArrayList<>();
        PreparedStatement ps = null;
        double max = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/booksys";
            conn = DriverManager.getConnection(connectionURL, "root", "root");
            ps = conn.prepareStatement("select customer_id, sum(sale) from fact, product_dim where fact.product_id = product_dim.product_id and product.name = ? group by customer_id order by sum(sale) desc");
            ps.setObject(1, product);
            rs = ps.executeQuery();
            ArrayList<String> list = SQLRetrieveBusinessCustomer.retrieveBusiness();
            while(rs.next()){
                if(list.contains(rs.getString(1))){
                    if(max == 0){
                        max = rs.getDouble(2);
                        res.add(rs.getString(1));
                    }else if(max == rs.getDouble(2)){
                        res.add(rs.getString(1));
                    }else{
                        break;
                    }
                }              
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }       
        return res;
    }
}
