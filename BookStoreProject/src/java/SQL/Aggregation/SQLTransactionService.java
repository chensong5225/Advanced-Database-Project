/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.Aggregation;

import SQL.Bean.TransactionBean;
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
public class SQLTransactionService extends Object implements Serializable{
    private static final long serialVersionUID = 102831973239L;
    
    private Connection conn;
    private PreparedStatement pstmt;

    public SQLTransactionService() {
        conn = SQLConnectSQL.getConn();
    }
    
     public List findWeekList() {

        List weekList = new ArrayList();

        try {
            pstmt = conn.prepareStatement("SELECT distinct week FROM transaction");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TransactionBean txy = new TransactionBean();
                txy.setWeek(rs.getInt("week"));
                weekList.add(txy);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return weekList;
    }
    
}