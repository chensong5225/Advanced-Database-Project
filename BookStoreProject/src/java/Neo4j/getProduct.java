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

public class getProduct {
    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    public ArrayList<String[]> list;
    public getProduct(){
        list = new ArrayList<>();
    }
    public ArrayList<String[]> load(){
         try {
            conn = ConnectSQL.getConn();
            ps = conn.prepareStatement("select product_id,name,cost,category from product_dim");
            rs = ps.executeQuery();
            while(rs.next()){
                String[] str = new String[4];
                str[0] = rs.getString(1);
                str[1] = rs.getString(2);
                str[2] = rs.getString(3);
                str[3] = rs.getString(4);
                list.add(str);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }     
        return list;
        
    }
    
    
}
