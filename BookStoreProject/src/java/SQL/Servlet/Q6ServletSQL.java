/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.Servlet;

import SQL.Aggregation.*;
import SQL.Bean.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author surface
 */
public class Q6ServletSQL  extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        String product = request.getParameter("sn1");
        
        Q6BusinessBuyMost q6 = new Q6BusinessBuyMost();
        ArrayList<String> list = q6.buyMost(product);
        
        ArrayListBean q6bean = new ArrayListBean();
        q6bean.setList(list);
        
        HttpSession sesson = request.getSession();
        sesson.setAttribute("q6bean", q6bean);
        ServletContext SC = getServletContext();
        RequestDispatcher rd = SC.getRequestDispatcher("/Q6SQLOutput.jsp");
        rd.forward(request, response);       
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Q1ServletSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Q1ServletSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Q1ServletSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Q1ServletSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

