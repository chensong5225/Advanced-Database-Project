/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlJDBC;

/**
 *
 * @author yuq
 */
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
public class LoadSale {
    static private Connection conn;
    static private ResultSet rs = null;
    
    public static String[] load(String tid, String pid) throws ClassNotFoundException{
        //sale[0]: transaction id, sale[1]: price per item(after *discount)
        //sale[2]: cost per item, sale[3]: amount

        String[] sale = new String[4];
        sale[0] = tid;
        PreparedStatement ps = null;       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/booksys";
            conn = DriverManager.getConnection(connectionURL, "root", "root");
            ps = conn.prepareStatement("select price, amount, product_id, discount from transaction where transaction_id = ? and product_id = ?");
            ps.setObject(1, tid);
            ps.setObject(2, pid);
            rs = ps.executeQuery();
            if(rs.next()){
                sale[1] = String.valueOf(Double.parseDouble(rs.getString(1)) * Double.parseDouble(rs.getString(4)));
                sale[3] = rs.getString(2);
            }
            ps = conn.prepareStatement("select cost from product where id = ?");
            ps.setObject(1, pid);
            rs = ps.executeQuery();
            if(rs.next()){
                sale[2] = rs.getString(1);
            }
             conn.close();            
        } catch (SQLException se) {
            se.printStackTrace();
        }       
        return sale;
    }
}

