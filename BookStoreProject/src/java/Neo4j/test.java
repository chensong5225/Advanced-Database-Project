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

public class test {
    public static void main(String[] args){
         Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
//        ArrayList<String[]> list = new ArrayList<>(); 
        String[] str;
        try {
            conn = ConnectSQL.getConn();
            ps = conn.prepareStatement("select customer_id, customer.type from transaction,customer where transaction.customer_id=customer.id");
            rs = ps.executeQuery();
            while(rs.next()){
                str = new String[2];
                str[0] = rs.getString(1);
                str[1] = rs.getString(2);
                System.out.println("customer id : "+str[0]+"type : "+ str[1]);
//                list.add(str);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }     
//        return list;
    }
        
    }
    

