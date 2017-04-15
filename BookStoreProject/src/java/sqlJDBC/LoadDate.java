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
/**
 *
 * @author yuq
 */
public class LoadDate {
    
    
    public static String[] load(String tid, String pid){
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String[] date = new String[3];
        //date[0]: year, date[1]: month, date[2]: day
        try {
            conn = ConnectSQL.getConn();
            ps = conn.prepareStatement("select time from transaction where transaction_id = ? and product_id = ?");
            ps.setObject(1, tid);
            ps.setObject(2, pid);
            rs = ps.executeQuery();
            if(rs.next()){
                String time = rs.getString(1);
                date = time.split("-");
            }
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return date;
    }
}
