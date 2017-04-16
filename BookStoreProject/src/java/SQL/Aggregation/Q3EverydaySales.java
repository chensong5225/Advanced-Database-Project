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
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author yuq
 */
public class Q3EverydaySales {
    public static void maintain(String date){
        Connection conn;
        PreparedStatement ps = null;
        PreparedStatement nestps = null;
        ResultSet rs = null;
        ResultSet nestrs = null;
        String tableName = "EverydayTable_" + date;
        HashMap<String, double[]> map = new HashMap<>();
        //key: product_id
        //array[0]: sales, array[1]: amount, array[2]: cost, array[3]: profit(= amount * cost) 
        try {
            conn = SQLConnectSQL.getConn();
            ps = conn.prepareStatement("Select product_id, sum(sale), amount from fact group by product_id where time = ?");
            ps.setObject(1, date);
            rs = ps.executeQuery();
            while(rs.next()){
                String productid = rs.getString(1);
                double[] array = new double[4];
                array[0] = ((int) (rs.getDouble(2) * 100)) / 100;
                array[1] = rs.getDouble(3);
                nestps = conn.prepareStatement("Select cost from product_dim where product_id = ?");
                nestps.setObject(1, productid);
                nestrs = nestps.executeQuery();
                if(nestrs.next()) array[2] = nestrs.getDouble(1);
                array[3] = array[1] * array[2];
                map.put(productid, array);
            }
            
            Node[] salesArr = new Node[map.size()];
            Node[] profitArr = new Node[map.size()];
            int i = 0;
            for(String s: map.keySet()){
                Node node = new Node(s, map.get(s)[0], map.get(s)[3]);
                salesArr[i] = node;
                profitArr[i] = node;
            }
            
            Arrays.sort(salesArr, new Comparator<Node>(){
                @Override
                public int compare(Node one, Node two){
                    return (int)(two.sales - one.sales);
                }
            });
            
            Arrays.sort(profitArr, new Comparator<Node>(){
                @Override
                public int compare(Node one, Node two){
                    return (int)(two.profit - one.profit);
                }
            });
            
            ArrayList<String> salesTop5 = new ArrayList<>();
            
            
            
            ps = conn.prepareStatement("DROP TABLE IF EXISTS " + tableName);
            ps.executeUpdate();
            ps = conn.prepareStatement("CREATE TABLE " + tableName + " (customer_id int(11) NOT NULL, type varchar(45) NOT NULL)");            
            ps.executeUpdate();
            ps = conn.prepareStatement("Insert into " + tableName + " select id, type from customer");
            ps.executeUpdate();
            
            ps = conn.prepareStatement("Select id, category from business_customer");
            rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String category = rs.getString(2);
                update = conn.prepareStatement("Update customer_dim SET type = ? where customer_id = ?");
                update.setObject(1, category);
                update.setObject(2, id);
                update.executeUpdate();
            }           
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    
    static class Node{
        String productid;
        double sales;
        double profit;
        public Node(String productid, double sales, double profit){
            this.productid = productid;
            this.sales = sales;
            this.profit = profit;
        }
    }
}
