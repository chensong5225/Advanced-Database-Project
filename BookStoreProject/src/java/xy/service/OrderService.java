/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import xy.bean.TransactionXy;

/**
 *
 * @author mac
 */
public class OrderService {

    private Connection conn;
    private PreparedStatement pstmt;
    
    public OrderService() {
        conn = new xy.conn.conn().getConn();
    }
    
    public List findHisOrder(int cid) {
        List transactions = new ArrayList();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM transaction where customer_id=?");
            pstmt.setInt(1, cid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TransactionXy tt = new TransactionXy();
                tt.setCustomer_id(cid);
                tt.setTransaction_id(rs.getInt("transaction_id"));
                tt.setProduct_id(rs.getInt("product_id"));
                tt.setAmount(rs.getInt("amount"));
                tt.setPrice(rs.getFloat("price"));
                tt.setStore_id(rs.getInt("store_id"));
                tt.setTime(rs.getString("time"));
                tt.setSale(rs.getFloat("sale"));
                transactions.add(tt);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        
        return transactions;
    }
}
