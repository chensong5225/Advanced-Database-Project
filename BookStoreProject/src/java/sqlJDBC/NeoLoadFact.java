/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author yuq
 */
public class NeoLoadFact {
    public static ArrayList<String[]> load(){
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String[]> list = new ArrayList<>();        
        try {
            conn = ConnectSQL.getConn();
            ps = conn.prepareStatement("select product_id,amount, store_id, customer_id, time, sum(sale) as sale from transaction group by product_id,customer_id,store_id,time");
            rs = ps.executeQuery();
            while(rs.next()){
                String[] str = new String[6];
                str[0] = rs.getString(1);
                str[1] = rs.getString(2);
                str[2] = rs.getString(3);
                str[3] = rs.getString(4);
                str[4] = rs.getString(5);
                str[5] = rs.getString(6);
                list.add(str);
            }
            
        } catch (SQLException se) {
            se.printStackTrace();
        }     
        return list;
    }
}
