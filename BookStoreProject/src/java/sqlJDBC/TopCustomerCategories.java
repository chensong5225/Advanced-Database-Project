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
public class TopCustomerCategories {
    public static void maintain(String date){
        Connection conn;
        PreparedStatement ps = null;
        String viewName = "TopProductCategories_" + CopyRemoveDateSlash.remove(date);
        ResultSet rs = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            conn = ConnectSQL.getConn();
            
            ps = conn.prepareStatement("Select type, sum(sale) as sales from customer, transaction where transaction.customer_id = customer.id and time = ? group by type order by sales desc limit 2");
            ps.setObject(1, date);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString(1));
            }
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
