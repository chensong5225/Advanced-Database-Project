/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoServlet;

import MongoJDBC.aggregation.Q2;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fei
 */
public class MongoServletQ2 extends HttpServlet {

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
        
        System.out.println("start date: "+start);
        
        String end = request.getParameter("enddate");
        Date tmpend = new SimpleDateFormat("yyyy-MM-dd").parse(end);
        String year2 = new SimpleDateFormat("yyyy").format(tmpend);
        String month2 = new SimpleDateFormat("MM").format(tmpend);
        String day2 = new SimpleDateFormat("dd").format(tmpend);
        
        ArrayList<String> olddate1 = new ArrayList();
        olddate1.add(year1);
        olddate1.add(month1);
        olddate1.add(day1);
        
        ArrayList<String> newdate2 = new ArrayList();
        newdate2.add(year2);
        newdate2.add(month2);
        newdate2.add(day2);
        
        //设置data
        HttpSession session = request.getSession();
        
        ArrayList<String> result = new Q2().query(olddate1,newdate2);
        session.setAttribute("mongoQ2result", result);
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MongoServletQ2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MongoServletQ2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
            Logger.getLogger(MongoServletQ2.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MongoServletQ2.class.getName()).log(Level.SEVERE, null, ex);
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
