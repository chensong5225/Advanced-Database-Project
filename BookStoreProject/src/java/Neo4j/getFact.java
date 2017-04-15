/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Neo4j;

/**
 *
 * @author hom19
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sqlJDBC.ConnectSQL;

public class getFact {
    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    public ArrayList<String[]> list;
    public getFact(){
        list = new ArrayList<>();
    }
    public ArrayList<String[]> load(){
        try {
            conn = ConnectSQL.getConn();
            // product_id,amount,cost,store_id,sale,customer_id,week
            ps = conn.prepareStatement("select product_id,amount,cost,store_id,customer_id,sale,week from product,fact where product.id=fact.product_id");
            rs = ps.executeQuery();
            while(rs.next()){
                String[] str = new String[7];
                str[0] = rs.getString(1);
                str[1] = rs.getString(2);
                str[2] = rs.getString(3);
                str[3] = rs.getString(4);
                str[4] = rs.getString(5);
                str[5] = rs.getString(6);
                str[6] = rs.getString(7);
                list.add(str);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } 
        return list;
        
}
    
}

