/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xy.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import xy.bean.Book;
import xy.bean.customer;

/**
 *
 * @author mac
 */
public class CheckOutService {

    private Connection conn;
    private PreparedStatement pstmt;

    public CheckOutService() {
        conn = new xy.conn.conn().getConn();
    }

    public boolean validCheckOut(customer ct, Book book) {
        Random r = new Random();
        int tid = r.nextInt(200);
        int si = r.nextInt(4);
        double dis = r.nextDouble();
        BigDecimal b = new BigDecimal(dis);
        double f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tm = formatter.format(date);
        
        try {

            pstmt = conn.prepareStatement("INSERT INTO `transaction`(`transaction_id`,`product_id`,`amount`,`price`,`customer_id`,`store_id`,`time`,`sale`,`week`,`discount`) VALUES (?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, tid);
            pstmt.setInt(2, book.getId());
            pstmt.setInt(3, 1);
            pstmt.setFloat(4, book.getPrice());
            pstmt.setInt(5, ct.getId());
            pstmt.setInt(6, si);
            pstmt.setString(7, tm);
            pstmt.setFloat(8, book.getPrice());
            pstmt.setInt(9, 8);
            pstmt.setDouble(10, f1);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

}
