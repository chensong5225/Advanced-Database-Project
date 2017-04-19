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
    private Connection conn;
    private ResultSet rs = null;
    
    public ArrayList<String> show(String product, String week) throws ClassNotFoundException{
        ArrayList<String> list = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            conn = SQLConnectSQL.getConn();
            ps = conn.prepareStatement("select customer_id, week, count(transaction_id) from transaction, product where product.id = transaction.product_id and product.name = ? and week = ? group by customer_id,week" );            
            ps.setObject(1, product);
            ps.setObject(2, week);            
            rs = ps.executeQuery();            
            while(rs.next()){
                if(rs.getInt(3) > 0){
                    list.add(rs.getString(1));
                }
            }  
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }        
        return list;
    }
}
