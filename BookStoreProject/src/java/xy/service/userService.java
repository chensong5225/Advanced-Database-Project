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

    public boolean validUser(customer ct) {

        try {
            pstmt = conn.prepareStatement("SELECT * FROM customer where email=? and password=?");
            pstmt.setString(1, ct.getEmail());
            pstmt.setString(2, ct.getPassword());
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

    public customer findIdType(customer ct) {
        //customer ct = new customer();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM customer where email=? and password=?");
            pstmt.setString(1, ct.getEmail());
            pstmt.setString(2, ct.getPassword());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ct.setId(rs.getInt("id"));
                ct.setType(rs.getString("type"));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return ct;
    }
}
