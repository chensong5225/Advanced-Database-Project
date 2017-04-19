/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.Aggregation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author surface
 */
public class Q4RetrieveViews {
    public ArrayList<ArrayList<String>> retrieve(String date){
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ArrayList<String>> resList = new ArrayList<>();
         
        try {
            //TopCustomerCategories
            conn = SQLConnectSQL.getConn();
            String viewName = "TopCustomerCategories_" + RemoveDateSlash.remove(date);
            ps = conn.prepareStatement("Select type from " + viewName);
            rs = ps.executeQuery();
            ArrayList<String> topCustomer = new ArrayList<>();
            while(rs.next()){
                topCustomer.add(rs.getString(1));
            }
            resList.add(topCustomer);
            
            //TopProductCategories
            viewName = "TopProductCategories_" + RemoveDateSlash.remove(date);
            ps = conn.prepareStatement("Select category from " + viewName);
            rs = ps.executeQuery();
            ArrayList<String> topProduct = new ArrayList<>();
            while(rs.next()){
                topProduct.add(rs.getString(1));
            }
            resList.add(topProduct);
            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return resList;
    }
}
