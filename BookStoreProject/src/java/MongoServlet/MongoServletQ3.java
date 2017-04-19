/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoServlet;

import MongoJDBC.aggregation.Q3;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * @author fei
 * 
 * 
 * Maintain every day the aggregate sales and profit of the top 5 and the bottom 5 products.
 */
public class MongoServletQ3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
         // 获取日期
        String start = request.getParameter("startdate");
        Date tmpstart = new SimpleDateFormat("yyyy-MM-dd").parse(start);
        String year1 = new SimpleDateFormat("yyyy").format(tmpstart);
        String month1 = new SimpleDateFormat("MM").format(tmpstart);
        String day1 = new SimpleDateFormat("dd").format(tmpstart);
        
        System.out.println("start date: "+year1+"--"+month1+"---"+day1);
     
        ArrayList<String> querydate = new ArrayList();
        querydate.add(year1);
        querydate.add(month1);
        querydate.add(day1);

        //运行Q3
        HttpSession session = request.getSession();        
        HashMap<String, ArrayList<String> >  result = new Q3().query(querydate);
        session.setAttribute("mongoQ3result", result);   
        
        ServletContext SC = getServletContext();
        RequestDispatcher rd = SC.getRequestDispatcher("/itemClassMongodb_3.jsp");
        rd.forward(request, response);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(MongoServletQ3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(MongoServletQ3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
