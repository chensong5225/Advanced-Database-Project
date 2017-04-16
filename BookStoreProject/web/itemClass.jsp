<%-- 
    Document   : itemClass
    Created on : Apr 1, 2017, 10:51:48 PM
    Author     : mac
--%>

<%@page import="Neo4j.ProductTest"%>
<%@page import="Neo4j.Product"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="xy.bean.customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>itemClass</title>
        <link type="text/css" rel="stylesheet" href="style/reset.css">
        <link type="text/css" rel="stylesheet" href="style/main.css">
    </head>
    <body>
        <div class ="headerBar">
            <div class="topBar">
                <div class="comWidth">
                    <div class="leftArea">
                        <a href="OrderHistoryServlet" class="collection">Order</a>
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
                        <span class="shopText fl">Shopping Cart</span>
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
        <div class="comWidth"> </div>


        <jsp:useBean id="test" class="Neo4j.test"></jsp:useBean>

            <div id="t">
            <%
                ProductTest pt = new ProductTest();
                List products = pt.first();
                //out.print(node.size());
                Iterator iter = products.iterator();
                while (iter.hasNext()) {
                    //out.print(iter.next());
                    Product product = (Product) iter.next();
                   // String name = product.getName();
                   // String category = product.getCategory();
            %>
           <!-- <p></p>-->
            <p><%=  product.getCategory() %></p>
            <%}%>
        </div>

        <div class="footer">
            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
        </div>
    </body>
</html>
