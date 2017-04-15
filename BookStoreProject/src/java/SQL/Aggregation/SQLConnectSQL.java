/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.Aggregation;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author yuq
 */
public class SQLConnectSQL {
    public static Connection getConn(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/booksys";
            String user ="root";
            String password ="root";
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn.getMetaData().getURL());
            
            return conn;
        }
        catch (Exception ec){
            ec.printStackTrace();
            return null;
        }
    }
}
