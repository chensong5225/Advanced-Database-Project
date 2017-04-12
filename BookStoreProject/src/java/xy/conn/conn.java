/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xy.conn;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mac
 */
public class conn {
    public Connection getConn(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/booksys";
            String user ="root";
            String password ="123456";
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
