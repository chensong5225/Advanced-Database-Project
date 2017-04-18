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
import xy.bean.TransactionXy;

/**
 *
 * @author mac
 */
public class TransactionService {
    private Connection conn;
    private PreparedStatement pstmt;

    public TransactionService() {
        conn = new xy.conn.conn().getConn();
    }
    
     public List findWeekList() {

        List weekList = new ArrayList();

        try {
            pstmt = conn.prepareStatement("SELECT distinct week FROM transaction");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TransactionXy txy = new TransactionXy();
                txy.setWeek(rs.getInt("week"));
                weekList.add(txy);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return weekList;
    }
    
}
