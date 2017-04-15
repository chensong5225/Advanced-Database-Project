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
public class bookService {

    private Connection conn;
    private PreparedStatement pstmt;

    public bookService() {
        conn = new xy.conn.conn().getConn();
    }

    public List searchAllBooks() {
        List books = new ArrayList();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM product");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getFloat("price"));
                book.setIntroduction(rs.getString("introduction"));
                book.setCategory(rs.getString("category"));
                book.setImage(rs.getString("image"));
                book.setCost(rs.getFloat("cost"));
                books.add(book);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return books;
    }

    public Book aBookSearch(int bid) {
        Book abook = new Book();
        abook.setId(bid);
        try {
            pstmt = conn.prepareStatement("SELECT * FROM product where id=?");
            pstmt.setInt(1, bid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                abook.setName(rs.getString("name"));
                abook.setAuthor(rs.getString("author"));
                abook.setPrice(rs.getFloat("price"));
                abook.setIntroduction(rs.getString("introduction"));
                abook.setCategory(rs.getString("category"));
                abook.setImage(rs.getString("image"));
                abook.setCost(rs.getFloat("cost"));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return abook;
    }

    public List findBooks(Book book) {

        List books = new ArrayList();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM product where id=?");
            pstmt.setInt(1, book.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getFloat("price"));
                book.setIntroduction(rs.getString("introduction"));
                book.setCategory(rs.getString("category"));
                book.setImage(rs.getString("image"));
                book.setCost(rs.getFloat("cost"));
                books.add(book);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return books;
    }
}
