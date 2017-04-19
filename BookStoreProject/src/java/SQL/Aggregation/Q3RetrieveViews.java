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
import java.util.HashMap;

/**
 *
 * @author surface
 */
public class Q3RetrieveViews {
    public ArrayList<ArrayList<String>> retrieve(String date){
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String str = RemoveDateSlash.remove(date);
        String viewName = "";
        ArrayList<ArrayList<String>> resList = new ArrayList<>();
         
        try {
            conn = SQLConnectSQL.getConn();
            
            //top 5 sales
            viewName = "EverydayTop5SalesView_" + str;
            ps = conn.prepareStatement("Select name from " + viewName);
            rs = ps.executeQuery();
            ArrayList<String> top5Sales = new ArrayList<>();
            while(rs.next()){
                top5Sales.add(rs.getString(1));
            }
            
            //bottom 5 sales
            viewName = "EverydayBottom5SalesView_" + str;
            ps = conn.prepareStatement("Select name from " + viewName);
            rs = ps.executeQuery();
            ArrayList<String> bottom5Sales = new ArrayList<>();
            while(rs.next()){
                bottom5Sales.add(rs.getString(1));
            }
            
            //top 5 profit
            viewName = "EverydayTop5ProfitView_" + str;
            ps = conn.prepareStatement("Select name from " + viewName);
            rs = ps.executeQuery();
            ArrayList<String> top5Profit = new ArrayList<>();
            while(rs.next()){
                top5Profit.add(rs.getString(1));
            }
                  
            //bottom 5 profit
            viewName = "EverydayBottom5ProfitView_" + str;
            ps = conn.prepareStatement("Select name from " + viewName);
            rs = ps.executeQuery();
            ArrayList<String> bottom5Profit = new ArrayList<>();
            while(rs.next()){
                bottom5Profit.add(rs.getString(1));
            }
            
            resList.add(top5Sales);
            resList.add(bottom5Sales);
            resList.add(top5Profit);
            resList.add(bottom5Profit);
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return resList;
    }
}
