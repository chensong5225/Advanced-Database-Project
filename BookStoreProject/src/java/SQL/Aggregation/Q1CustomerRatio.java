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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author yuq
 */
public class Q1CustomerRatio {
    static private Connection conn;
    static private ResultSet rs = null;
    static private Statement st;
    public static int[] ratio() throws ClassNotFoundException{
        PreparedStatement ps = null;
        int[] ratio = new int[2];
        //int[0]: number of home, int[1]: number of business
        try {
            
            conn = SQLConnectSQL.getConn();
            ps = conn.prepareStatement("SELECT type from customer_dim");                      
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString(1).equals("home")){
                    ratio[0]++;
                }else{
                    ratio[1]++;
                }
            }
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return ratio;
    }
}
