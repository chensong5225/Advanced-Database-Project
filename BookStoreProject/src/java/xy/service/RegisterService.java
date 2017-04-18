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
import xy.bean.Address;
import xy.bean.customer;

/**
 *
 * @author mac
 */
public class RegisterService {
    private Connection conn;
    private PreparedStatement pstmt;

    public RegisterService() {
        conn = new xy.conn.conn().getConn();
    }
    
    public boolean insertCustomer(customer ct) {
        try {
            pstmt = conn.prepareStatement("INSERT INTO `customer`(`type`,`email`,`password`) VALUES (?,?,?)");
            pstmt.setString(1, ct.getType());
            pstmt.setString(2, ct.getEmail());
            pstmt.setString(3, ct.getPassword());
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
    
    public int getCustomerId(customer ct) {
        int id = 0;
        try {
            pstmt = conn.prepareStatement("SELECT id FROM customer where email=?");
            pstmt.setString(1, ct.getEmail());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return id;
    }
    
    
    
    public boolean insertHCustomer(customer ct){
        try {
            pstmt = conn.prepareStatement("INSERT INTO `home_customer`(`id`,`name`,`addressid`,`gender`,`marriage_status`,`age`,`income`) VALUES (?,?,?,?,?,?,?)");
            pstmt.setInt(1, ct.getId());
            pstmt.setString(2, ct.getName());
            pstmt.setInt(3, ct.getAddressid());
            pstmt.setString(4, ct.getGender());
            pstmt.setString(5, ct.getMarriage_status());
            pstmt.setInt(6, ct.getAge());
            pstmt.setString(7, ct.getIncome());
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
