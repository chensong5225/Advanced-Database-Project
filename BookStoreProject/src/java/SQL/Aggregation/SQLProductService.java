/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.Aggregation;

import SQL.Bean.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author surface
 */
public class SQLProductService extends Object implements Serializable{
    private static final long serialVersionUID = 102831973239L;
    private Connection conn;
    private PreparedStatement pstmt;

    public SQLProductService() {
        conn = SQLConnectSQL.getConn();
    }
    
    public List findProductList() {

        List productList = new ArrayList();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM product");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BookBean book = new BookBean();
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
