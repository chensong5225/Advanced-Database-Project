/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author mac
 */
public class CartService {
    private Connection conn;
    private PreparedStatement pstmt;
    public CartService(){
        conn = new xy.conn.conn().getConn();
    }
    
    
    
    
}
