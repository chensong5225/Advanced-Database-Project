<%-- 
    Document   : shoppingCart
    Created on : Apr 1, 2017, 10:54:15 PM
    Author     : mac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <link type="text/css" rel="stylesheet" href="style/cart.css">
    <style type="text/css">
        #goods{
            border: 1px solid black;
        }
    </style>
</head>
<body>
<div class ="headerBar">
    <div class="topBar">
        <div class="comWidth">
            <div class="leftArea">
                <a href="#" class="collection">Collection</a>
            </div>
            <div class="rightArea">
                Welcome to our website! <a href="#">[Login]</a> <a href="#">[Register]</a>
            </div>
        </div>
    </div>
    <div class="logoBar">
        <div class="comWidth">
            <div class="logo fl">
                <a href="#"><img height="50px" width="50px" src="images/BG.png" alt="Logo">Book online store</a>
            </div>

        </div>
    </div>
</div>
<center>
    <%
    HttpSession hs = request.getSession(true);
    List bookList =(List) hs.getAttribute("bookList");
    Iterator it = bookList.iterator();
    while(it.hasNext()){
    Book book = (Book) it.next();
    %>
    <div class="show" name="cart">
        <h2>Shopping Cart</h2>
        <form action=""method="post">
            <table id="goods">
                <tr>
                    <td><img src="<%= book.getImage() %>" width="200" height="100"/></td>
                    <td>Book Name:</td>
                    <td><%= book.getName() %></td>
                </tr>
                <tr>
                    <td></td>
                    <td>Amount:</td>
                    <td><input class="p1" type="text" name="number" value="1" width="30" height="10"/></td>
                </tr>
                <tr><td></td><td>Book Information:</td><td><%= book.getIntroducation() %></td></tr>
                <tr></tr>
                <tr><td></td><td></td><td></td><td><a href="/DeleteBook?Bid=<%book.getBID();%>">Delete</a></td><td></td><td></td></tr>
                <tr><td></td><td></td><td></td><td>Price:<%= book.getPrice() %> $</td><td></td></tr>
                <tr></tr>
                <tr></tr>
            </table>
            <table>
                <tr><td>total:</td><td>$</td><td></td></tr>
                <tr><td></td><td></td><td></td></tr>
                <tr><td></td><td></td><td></td></tr>
                <div class="br25"></div>
                <tr><td><input type="button" class="cart_btn" value="Check Out"/></td></tr>
            </table>
        </form>
    </div>
    <%
    }
    %>
</center>
<div class="footer">
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
</div>
</body>
</html>
