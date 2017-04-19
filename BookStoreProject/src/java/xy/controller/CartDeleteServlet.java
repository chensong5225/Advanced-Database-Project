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
import xy.bean.Cart;
import xy.bean.customer;
import xy.service.CartService;
import xy.service.bookService;

/**
 *
 * @author mac
 */
public class CartDeleteServlet extends HttpServlet {

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
        customer ct = new customer();
        ct = (customer) session.getAttribute("customer");
        int cid = ct.getId();
        int bid = Integer.valueOf(request.getParameter("Bid"));
        CartService cs = new CartService();
        if (cs.cartBookDelete(cid, bid)) {
            List<Cart> carts = cs.findCartList(cid);
            System.out.println(carts);
            List<Book> books = new ArrayList<Book>();
            bookService bs = new bookService();
            for (Cart item : carts) {
                Book book = new Book();
                int bidNew = item.getBid();
                List<Book> temp = new ArrayList<>();
                temp.add(bs.aBookSearch(bidNew));
                books.add(temp.get(0));
            }
            if (books != null) {
                session.setAttribute("cartList", carts);
                session.setAttribute("bookList", books);
                ServletContext SC = getServletContext();
                RequestDispatcher rd = SC.getRequestDispatcher("/shoppingCart.jsp");
                rd.forward(request, response);

            } else {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
        else{
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartDeleteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartDeleteServlet at " + request.getContextPath() + "</h1>");
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
