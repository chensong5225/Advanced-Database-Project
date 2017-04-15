<%-- 
    Document   : productIntro
    Created on : Apr 1, 2017, 10:53:10 PM
    Author     : mac
--%>

<%@page import="xy.bean.customer"%>
<%@page import="xy.bean.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>productIntro</title>
        <link type="text/css" rel="stylesheet" href="style/reset.css">
        <link type="text/css" rel="stylesheet" href="style/main.css">
        <link type="text/css" rel="stylesheet" href="style/productIntro.css">
    </head>
    <body class="grey">
        <div class ="headerBar">
            <div class="topBar">
                <div class="comWidth">
                    <div class="leftArea">
                        <a href="OrderHistoryServlet" class="collection">Order</a>
                    </div>
                    <div class="rightArea">
                        <% if (session.getAttribute("customer") == null) {%>
                        Welcome to our website! <a href="login.jsp">[Login]</a> <a href="#">[Register]</a>
                        <%} else {
                            customer cst = (customer) session.getAttribute("customer");%>

                        Welcome <%=cst.getId()%> to our website.<a href="LogoutServlet">[Logout]</a>
                        <%}
                        %>
                    </div>
                </div>
            </div>
            <div class="logoBar">
                <div class="comWidth">
                    <div class="logo fl">
                        <a href="#"><img height="50px" width="50px" src="images/BG.png" alt="Logo">Book online store</a>
                    </div>
                    <div class="search_box fl">
                        <input type="text" class="search_text fl">
                        <input type="button" value="Search" class="search_btn fr">
                    </div>
                    <div class="shopCar fr">
                        <span class="shopText fl">Cart</span>
                        <span class="shopNum fl"> 0 </span>
                    </div>
                </div>
            </div>
            <div class="navBox">
                <div class="comWidth">
                    <div class="shopClass fl">
                        <h3>All Item Classfication</h3>
                        <div class="shopClass_show hide">
                            <dl class="shopClass_item">
                                <dt><a href="#" class="b">book1</a>     <a href="#"  class="b">book2</a> </dt>
                                <dd><a href="#">book1</a> <a href="#">book2</a></dd>
                            </dl>
                            <dl class="shopClass_item">
                                <dt><a href="#" class="b">book1</a>     <a href="#"  class="b">book2</a> </dt>
                                <dd><a href="#">book1</a> <a href="#">book2</a></dd>
                            </dl>
                            <dl class="shopClass_item">
                                <dt><a href="#" class="b">book1</a>     <a href="#"  class="b">book2</a> </dt>
                                <dd><a href="#">book1</a> <a href="#">book2</a></dd>
                            </dl>
                            <dl class="shopClass_item">
                                <dt><a href="#" class="b">book1</a>     <a href="#"  class="b">book2</a> </dt>
                                <dd><a href="#">book1</a> <a href="#">book2</a></dd>
                            </dl>
                            <dl class="shopClass_item">
                                <dt><a href="#" class="b">book1</a>     <a href="#"  class="b">book2</a> </dt>
                                <dd><a href="#">book1</a> <a href="#">book2</a></dd>
                            </dl>
                        </div>
                        <!--<div class="shopClass_list">
                            <div class="shopClass_cont">
                                <dl class="shopList_item">
                                    <dt >book1</dt>
                                    <dd>
                                        <a href="#">book1-1</a>
                                        <a href="#">book1-1</a>
                                        <a href="#">book1-1</a>
                                        <a href="#">book1-1</a>
                                        <a href="#">book1-1</a>
                                    </dd>
                                </dl>
                                <dl class="shopList_item">
                                    <dt >book1</dt>
                                    <dd>
                                        <a href="#">book1-1</a>
                                        <a href="#">book1-1</a>
                                        <a href="#">book1-1</a>
                                        <a href="#">book1-1</a>
                                        <a href="#">book1-1</a>
                                    </dd>
                                </dl>
                                <dl class="shopList_item">
                                    <dt >book1</dt>
                                    <dd>
                                        <a href="#">book1-1</a>
                                        <a href="#">book1-1</a>
                                        <a href="#">book1-1</a>
                                        <a href="#">book1-1</a>
                                        <a href="#">book1-1</a>
                                    </dd>
                                </dl>
                            </div>
                        </div>-->
                    </div>
                    <ul class="nav fl">
                        <li><a href="index.jsp" class="active">Book</a></li>
                        <li><a href="index.jsp">Arts & Photography</a></li>
                        <li><a href="index.jsp">Biographies&Memoirs</a> </li>
                        <li><a href="index.jsp">Children Books</a></li>
                        <li><a href="index.jsp">History</a></li>
                    </ul>
                </div>
            </div>
        </div>


        <%
            HttpSession hs = request.getSession(true);
            Book book = (Book) hs.getAttribute("book");
        %>
        <div class="description_info comWidth">
            <div class="description clearfix">
                <div class="leftArea">
                    <div class="description_imgs">
                        <img src="<%= book.getImage()%>" alt="image1">
                    </div>
                </div>
                <div class="rightArea">
                    <div class="des_content">
                        <h3><%= book.getName()%></h3>
                        <div class="dl clearfix">
                            <div class="dt">Price:</div>
                            <div class="dd"><span class="des_money">$ <%= book.getPrice()%></span></div>
                        </div>
                        <div class="dl clearfix">
                            <div class="dt">Description:</div>
                            <div class="dd"><span class="hg"> <%= book.getIntroduction()%></span></div>
                        </div>
                        <div class="dl">
                            <div class="dt">Number:</div>
                            <div class="dd clearfix">
                                <div class="des_number hide">
                                    <input type="text">
                                </div>
                                <p></p><a href="#">1</a>
                            </div>

                            <p class="pt hide">test bookId: <%= book.getId()%></p>
                        </div>
                        <div class="shop_buy">
                            <form action="AddToCartServlet" class="f1 fl">
                                <input type="submit" value="AddToCart" class="search_btn">
                            </form>
                            <form action="#" class="f2 fl">
                                <input type="submit" value="CheckOut" class="search_btn">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="footer">
            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
        </div>
    </body>
</html>
