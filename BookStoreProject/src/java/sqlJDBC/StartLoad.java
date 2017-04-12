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
public class StartLoad {
    static private Connection conn;
    static private ResultSet rs = null;
    
    public static ArrayList<String[]> load() throws ClassNotFoundException{
        
        ArrayList<String[]> list = new ArrayList<>();
        PreparedStatement ps = null;       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/booksys";
            conn = DriverManager.getConnection(connectionURL, "root", "root");
            ps = conn.prepareStatement("select transaction_id, product_id from transaction");
            rs = ps.executeQuery();
            while(rs.next()){
                String[] str = new String[2];
                str[0] = rs.getString(1);
                str[1] = rs.getString(2);
                list.add(str);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }       
        return list;
    }
}

