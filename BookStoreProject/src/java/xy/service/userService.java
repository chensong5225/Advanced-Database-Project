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
import xy.bean.customer;

/**
 *
 * @author mac
 */
public class userService {

    private Connection conn;
    private PreparedStatement pstmt;

    public userService() {
        conn = new xy.conn.conn().getConn();
    }

    public boolean validUser(String email, String password) {

        try {
            pstmt = conn.prepareStatement("SELECT * FROM customer where email=? and password=?");
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }

    }

    public customer findIdType(String email, String password) {
        customer ct = new customer();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM customer where email=? and password=?");
            pstmt.setString(1, ct.getEmail());
            pstmt.setString(2, ct.getPassword());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ct.setId(rs.getInt("id"));
                ct.setType(rs.getString("type"));
                ct.setEmail(email);
                ct.setPassword(password);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return ct;
    }

    public String findHName(customer ct) {
        String name = null;
        try {
            pstmt = conn.prepareStatement("SELECT name FROM home_customer where id=?");
            pstmt.setInt(1, ct.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return name;
    }

    public String findBName(customer ct) {
        String name =null;
        try {
            pstmt = conn.prepareStatement("SELECT name FROM business_customer where id=?");
            pstmt.setInt(1, ct.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return name;

    }
}
