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
import xy.bean.Book;

/**
 *
 * @author mac
 */
public class ProductService {
    private Connection conn;
    private PreparedStatement pstmt;

    public ProductService() {
        conn = new xy.conn.conn().getConn();
    }
    
    public List findProductList() {

        List productList = new ArrayList();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM product");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                productList.add(book);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return productList;
    }
    
    
}
