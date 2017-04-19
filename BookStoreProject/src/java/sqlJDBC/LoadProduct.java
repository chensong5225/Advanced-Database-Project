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
public class LoadProduct {
    static private Connection conn;
    static private ResultSet rs = null;
    
    public static String[] load(String pid) throws ClassNotFoundException{
        //product[0]:product name, product[1]:category
        String[] product = new String[2];
        PreparedStatement ps = null;       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/booksys";
            conn = DriverManager.getConnection(connectionURL, "root", "root");
            ps = conn.prepareStatement("select name, category from product where id = ?");
            ps.setObject(1, pid);
            rs = ps.executeQuery();
            if(rs.next()){
                product[0] = rs.getString(1);
                product[1] = rs.getString(2);
            }
             conn.close();            
        } catch (SQLException se) {
            se.printStackTrace();
        }       
        return product;
    }
}

