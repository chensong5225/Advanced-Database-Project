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
public class Q5ServletSQL  extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
        Q5RegionCompare q5 = new Q5RegionCompare();
        HashMap<String, Double> map = q5.regionCompare();
        Q5Bean q5bean = new Q5Bean();
        q5bean.setMap(map);
        ArrayListBean regionBean = new ArrayListBean();
        ArrayListBean salesBean = new ArrayListBean();
        ArrayList<String> regionList = new ArrayList<>();
        ArrayList<Double> salesList = new ArrayList<>();
        for(String s: map.keySet()){
            regionList.add(s);
            salesList.add(map.get(s));
        }
        regionBean.setList(regionList);
        salesBean.setDoublelist(salesList);
        HttpSession sesson = request.getSession();
        sesson.setAttribute("regionBean", regionBean);
        sesson.setAttribute("salesBean", salesBean);
        sesson.setAttribute("q5bean", q5bean);
        ServletContext SC = getServletContext();
        RequestDispatcher rd = SC.getRequestDispatcher("/Q5SQLOutput.jsp");
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

