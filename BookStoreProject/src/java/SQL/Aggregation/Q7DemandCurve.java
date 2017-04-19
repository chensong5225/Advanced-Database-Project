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
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author surface
 */
public class Q7DemandCurve {
    private Connection conn;
    private ResultSet rs = null;
    
    public ArrayList<ArrayList<Double>> demand(String product) throws ClassNotFoundException{
        ArrayList<ArrayList<Double>> list = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        ArrayList<Double> sales = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            conn = SQLConnectSQL.getConn();
            ps = conn.prepareStatement("select price, sum(sale) from fact, product_dim where product_dim.name = ?  and fact.product_id = product_dim.product_id group by price");            
            //ps = conn.prepareStatement("select price, sum(sale) from fact where product_id = ? group by price");
            ps.setObject(1, product);
            rs = ps.executeQuery();            
            while(rs.next()){
                price.add(rs.getDouble(1));
                sales.add(rs.getDouble(2));
            }
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        list.add(price);
        list.add(sales);
        return list;
    }
    
}
