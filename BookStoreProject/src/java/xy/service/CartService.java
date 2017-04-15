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
import xy.bean.Cart;

/**
 *
 * @author mac
 */
public class CartService {

    private Connection conn;
    private PreparedStatement pstmt;

    public CartService() {
        conn = new xy.conn.conn().getConn();
    }

    public boolean addToCart(Cart cart) {
        try {
            pstmt = conn.prepareStatement("insert into cart(cid,bid,totoal_price,quantity) values(?,?,?,?)");
            pstmt.setInt(1, cart.getCid());
            pstmt.setInt(2, cart.getBid());
            pstmt.setFloat(3, cart.getTotoal_price());
            pstmt.setInt(4, cart.getQuantity());
            int r = pstmt.executeUpdate();
            if (r != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    public boolean findCart(Cart cart) {
        try {
            pstmt = conn.prepareStatement("select * from cart where cid=? and bid=?");
            pstmt.setInt(1, cart.getCid());
            pstmt.setInt(2, cart.getBid());
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

    public Cart findOldCart(int cid, int bid) {
        Cart oldCart = new Cart();
        oldCart.setCid(cid);
        oldCart.setBid(bid);
        try {
            pstmt = conn.prepareStatement("SELECT * FROM cart where cid=? and bid=?");
            pstmt.setInt(1, cid);
            pstmt.setInt(2, bid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                oldCart.setQuantity(rs.getInt("quantity"));
                oldCart.setTotoal_price(rs.getFloat("totoal_price"));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return oldCart;
    }

    public boolean updateCart(Cart cart) {

        try {
            pstmt = conn.prepareStatement("update cart set quantity = ?, totoal_price= ? where cid=? and bid=?");
            pstmt.setInt(1, cart.getQuantity());
            pstmt.setFloat(2, cart.getTotoal_price());
            pstmt.setInt(3, cart.getCid());
            pstmt.setInt(4, cart.getBid());
            int r = pstmt.executeUpdate();
            if (r != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }

    }

    public List findCartList(Cart cart) {

        List cartList = new ArrayList();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM cart where cid=?");
            pstmt.setInt(1, cart.getCid());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //Cart cart = new Cart();
                //cart.setCid(cid);
                cart.setBid(rs.getInt("bid"));
                cart.setTotoal_price(rs.getFloat("totoal_price"));
                cart.setQuantity(rs.getInt("quantity"));
                cartList.add(cart);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return cartList;

    }
}
