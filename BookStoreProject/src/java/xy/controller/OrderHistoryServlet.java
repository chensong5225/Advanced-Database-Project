/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import xy.bean.Book;
import xy.bean.Message;
import xy.bean.TransactionXy;
import xy.bean.customer;
import xy.service.OrderService;
import xy.service.bookService;

/**
 *
 * @author mac
 */
public class OrderHistoryServlet extends HttpServlet {

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

        HttpSession session = request.getSession();
        customer ct = (customer) session.getAttribute("customer");
        if (ct != null) {
            OrderService os = new OrderService();
            bookService bs = new bookService();

            List<TransactionXy> transactions = os.findHisOrder(ct.getId());
            if (transactions != null) {//size?
                List<Book> books = new ArrayList<Book>();
                for (TransactionXy item : transactions) {
                    Book book = new Book();
                    int bid = item.getProduct_id();
                    book.setId(bid);
                    books.add(bs.aBookSearch(bid));
                }
                if (books != null) {
                    session.setAttribute("transactionList", transactions);
                    session.setAttribute("bookList", books);
                    ServletContext SC = getServletContext();
                    RequestDispatcher rd = SC.getRequestDispatcher("/historyOrder.jsp");
                    rd.forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } else {
            Message msg = new Message();
            msg.setMessageInfo("Please login first.");
            session.setAttribute("msgInfo", msg);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderHistoryServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderHistoryServlet at " + request.getContextPath() + "</h1>");
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
