<%-- 
    Document   : historyOrder
    Created on : Apr 8, 2017, 7:07:43 PM
    Author     : mac
--%>

<%@page import="java.util.Iterator"%>
<%@page import="xy.bean.Transaction"%>
<%@page import="xy.bean.Book"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>historyOrder</title>
        <link type="text/css" rel="stylesheet" href="style/main.css">
        <link type="text/css" rel="stylesheet" href="style/login.css">
    </head>
    <body>
        <div class ="headerBar">
            <div class="logoBar login_logo">
                <div class="comWidth">
                    <div class="logo fl">
                        <a href="#"><img height="50px" width="50px" src="images/BG.png" alt="Logo">Book online store</a>
                    </div>
                    <h3 class="welcome_title"></h3>
                </div>
            </div>
        </div>
        <%
            HttpSession hs = request.getSession(true);
            List<Book> bookList = (List<Book>) hs.getAttribute("bookList");
            List<Transaction> transactionList = (List<Transaction>) hs.getAttribute("transactionList");
            Iterator itb = bookList.iterator();
            Iterator itt = transactionList.iterator();
            int index = 0;
            while (itb.hasNext() && itt.hasNext()) {
                Book book = (Book) itb.next();
                Transaction tt = (Transaction) itt.next();
                index++;
        %>
    <center>
        <div class="orderView">
            <table>
                <tr><td>transaction number:<%= tt.getTransaction_id()%></td><td></td></tr>
                <tr><td>product name: <%= book.getName()%></td><td></td></tr>
                <tr><td><img height="150px" width="150px" src="<%= book.getImage()%>" alt="image1"/></td><td></td></tr>
                <tr><td>amount: <%= tt.getAmount()%> </td><td></td></tr>
                <tr><td>price: <%= tt.getPrice()%> </td><td></td></tr>
                <tr><td>time: <%= tt.getTime()%> </td><td></td></tr>
            </table>
        </div>
    </center>

    <%
        }
    %>
</body>

<div class="footer">
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
</div>
</html>
