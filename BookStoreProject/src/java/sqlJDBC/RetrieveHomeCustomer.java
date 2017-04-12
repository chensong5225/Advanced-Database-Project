/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuq6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author surface
 */
public class RetrieveHomeCustomer {
    static private Connection conn;
    static private ResultSet rs = null;
    static private Statement st;
    public static ArrayList<String> retrieveHome() throws ClassNotFoundException{
        PreparedStatement ps = null;
        String type1 = "home";
        ArrayList<String> homeList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/mysql";
            conn = DriverManager.getConnection(connectionURL, "root", "admin");
            ps = conn.prepareStatement("SELECT customer_id  from customer_dim where type=?");
            
            ps.setObject(1,type1);           
            rs = ps.executeQuery();
            while(rs.next()){
                homeList.add(rs.getString(1));
            }
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return homeList;
    }
}