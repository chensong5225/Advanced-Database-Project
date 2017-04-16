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

public class getCustomer {
    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    public ArrayList<String[]> list;
    public getCustomer(){
         list = new ArrayList<>(); 
    }
    public ArrayList<String[]> load(){
        try {
            conn = ConnectSQL.getConn();
            //customer_id,type
            ps = conn.prepareStatement("select distinct customer_id,customer.type from transaction,customer where transaction.customer_id=customer.id");
            rs = ps.executeQuery();
            while(rs.next()){
                String[] str = new String[2];
                str[0] = rs.getString(1);
                str[1] = rs.getString(2);
//                System.out.println("customer id : "+str[0]+"type : "+ str[1]);
                list.add(str);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }     
        return list;
    }
    }
    

