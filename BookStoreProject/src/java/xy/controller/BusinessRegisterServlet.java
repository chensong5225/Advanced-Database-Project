/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import xy.bean.Message;
import xy.bean.customer;
import xy.service.RegisterService;

/**
 *
 * @author mac
 */
public class BusinessRegisterServlet extends HttpServlet {

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
            throws ServletException, IOException {

        String name = request.getParameter("uname2");
        String email = request.getParameter("email2");
        String password = request.getParameter("password2");
        String street = request.getParameter("stet2");
        String city = request.getParameter("city2");
        String state = request.getParameter("state2");
        String zip = request.getParameter("zip2");
        String category = request.getParameter("category");
        String income = request.getParameter("income2");

        HashSet<Character> set = new HashSet<Character>();
        set.add(';');
        set.add(':');
        set.add(',');
        set.add('#');
        set.add('&');
        set.add('\'');
        set.add('\"');
        set.add('.');
        set.add('!');
        set.add('?');
        set.add('[');
        set.add(']');

        for (int i = 0; i < name.length(); i++) {
            char temp = name.charAt(i);
            if (set.contains(temp)) {
                Message registerMessage = new Message();
                registerMessage.setMessageInfo("You include illegal input in Username(eg: [;:,#&\'\".!?]). Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
            }
        }

        for (int i = 0; i < password.length(); i++) {
            char temp = password.charAt(i);
            if (set.contains(temp)) {
                Message registerMessage = new Message();
                registerMessage.setMessageInfo("You include illegal input in Password(eg: [;:,#&\'\".!?]). Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
            }
        }

        for (int i = 0; i < street.length(); i++) {
            char temp = street.charAt(i);
            if (set.contains(temp)) {
                Message registerMessage = new Message();
                registerMessage.setMessageInfo("You include illegal input in Street (eg: [;:,#&\'\".!?]). Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
            }
        }

        for (int i = 0; i < city.length(); i++) {
            char temp = city.charAt(i);
            if (set.contains(temp)) {
                Message registerMessage = new Message();
                registerMessage.setMessageInfo("You include illegal input in city (eg: [;:,#&\'\".!?]). Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
            }
        }

        for (int i = 0; i < zip.length(); i++) {
            char temp = zip.charAt(i);
            if (set.contains(temp)) {
                Message registerMessage = new Message();
                registerMessage.setMessageInfo("You include illegal input in zip (eg: [;:,#&\'\".!?]). Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
            }
        }

        for (int i = 0; i < state.length(); i++) {
            char temp = state.charAt(i);
            if (set.contains(temp)) {
                Message registerMessage = new Message();
                registerMessage.setMessageInfo("You include illegal input in state (eg: [;:,#&\'\".!?]). Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
            }
        }

        for (int i = 0; i < income.length(); i++) {
            char temp = income.charAt(i);
            if (set.contains(temp)) {
                Message registerMessage = new Message();
                registerMessage.setMessageInfo("You include illegal input in income (eg: [;:,#&\'\".!?]). Please check.");
                HttpSession sesson = request.getSession();
                sesson.setAttribute("registerMessage", registerMessage);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
            }
        }

        if (name.length() <= 0 || email.length() <= 0 || password.length() <= 0 || zip.length() <= 0 || street.length() <= 0 || city.length() <= 0 || income.length() <= 0 || state.length() <= 0) {
            Message registerMessage = new Message();
            registerMessage.setMessageInfo("You cannot leave required fields blank. Please check.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("registerMessage", registerMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/register.jsp");
            rd.forward(request, response);
        }

        boolean emailCheck = false;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                if (emailCheck == false) {
                    emailCheck = true;
                } else {
                    emailCheck = false;
                }
            }
        }
        if (emailCheck == false) {
            Message registerMessage = new Message();
            registerMessage.setMessageInfo("Email address is invalid. Please enter again.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("registerMessage", registerMessage);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/register.jsp");
            rd.forward(request, response);
        }

        customer ct = new customer();
        ct.setType("business");
        ct.setEmail(email);
        ct.setPassword(password);
        RegisterService rs = new RegisterService();
        if (rs.insertCustomer(ct)) {
            Message msg = new Message();
            msg.setMessageInfo("Register succuss. Please login.");
            HttpSession sesson = request.getSession();
            sesson.setAttribute("msgInfo", msg);
            ServletContext SC = getServletContext();
            RequestDispatcher rd = SC.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        } else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BusinessRegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BusinessRegisterServlet at " + "</h1>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
