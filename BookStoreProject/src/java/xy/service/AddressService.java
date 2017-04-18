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

/**
 *
 * @author mac
 */
public class AddressService {

    private Connection conn;
    private PreparedStatement pstmt;

    public AddressService() {
        conn = new xy.conn.conn().getConn();
    }

    public boolean insertAddress(Address add) {
        try {
            pstmt = conn.prepareStatement("INSERT INTO `address`(`street`,`city`,`state`,`zip`) VALUES (?,?,?,?)");
            pstmt.setString(1, add.getStreet());
            pstmt.setString(2, add.getCity());
            pstmt.setString(3, add.getState());
            pstmt.setString(4, add.getZip());
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

    public int getAddressId(Address add) {

        int id = 0;
        try {
            pstmt = conn.prepareStatement("select id from address where street=? and city=? and state=? and zip=?");
            pstmt.setString(1, add.getStreet());
            pstmt.setString(2, add.getCity());
            pstmt.setString(3, add.getState());
            pstmt.setString(4, add.getZip());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return id;
    }

}
