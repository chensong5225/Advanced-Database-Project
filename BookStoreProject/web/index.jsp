<%-- 
    Document   : index
    Created on : Apr 1, 2017, 10:48:12 PM
    Author     : mac
--%>

<%@page import="xy.bean.Book"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="xy.bean.customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>
        <link type="text/css" rel="stylesheet" href="style/reset.css">
        <link type="text/css" rel="stylesheet" href="style/main.css">
        <script>
            function showD(n) {
                document.getElementById(n).style.display = "block";
            }
            function hideD(n) {
                document.getElementById(n).style.display = "none";
            }
            function aOver1() {
                var l = document.getElementById("cp1");
                l.setAttribute("src", "images/5.jpg");
            }
            function aOver2() {
                var l = document.getElementById("cp2");
                l.setAttribute("src", "images/7.jpg");
            }
        </script>
    </head>
    <jsp:useBean id="bookSearch" class="xy.service.bookService"></jsp:useBean>


        <body>
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
                        <h3 onmouseover="showD('sc')" onmouseout="hideD('sc')">All Item Classfication</h3>
                        <div id="sc" class="shopClass_show">
                            <dl class="shopClass_item">
                                <dt><a href="#Art" class="b">Arts & Photography</a> </dt>
                            </dl>
                            <dl class="shopClass_item">
                                <dt><a href="#Biographies" class="b">Biographies&Memoirs</a> </dt>
                            </dl>
                            <dl class="shopClass_item">
                                <dt><a href="#Child" class="b">Children Books</a> </dt>
                            </dl>
                            <dl class="shopClass_item">
                                <dt><a href="#his" class="b">History</a></dt>
                            </dl>
                        </div>
                    </div>
                    <ul class="nav fl">
                        <li><a href="#" class="active">Book</a></li>
                        <li><a href="#Art">Arts & Photography</a></li>
                        <li><a href="#Biographies">Biographies&Memoirs</a> </li>
                        <li><a href="#Child">Children Books</a></li>
                        <li><a href="#his">History</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="banner comWidth clearfix">
            <div class="banner_bar">
                <ul class="imgBox">
                    <li><a href="#"><img id="cp1" src="images/7.jpg" alt="banner1"/></a> </li>
                    <li><a href="#"><img id="cp2" src="images/5.jpg" alt="banner2"/></a> </li>
                </ul>
                <div class="imgNum">
                    <!-- <a href="#" class="active"></a>-->
                    <a onmouseover="aOver1()" href="#"></a>
                    <a onmouseover="aOver2()" href="#"></a>
                </div>
            </div>
        </div>
        <% List books = bookSearch.searchBooksByArt();
            //out.print(books.size());
            Iterator iter = books.iterator();
        %>
        <div class="shopTit comWidth">
            <h3><a href="#" name="Art" class="more">Arts & Photography</a></h3>
            <a href="#" class="more">More&gt&gt</a>
        </div>
        <div class="shopList comWidth clearfix">
            <div class="leftArea">              
            </div>
            <div class="rightArea">
                <div class="shopList_top clearfix">
                    <%  int index = 0;
                        while (iter.hasNext()) {
                            Book abook = (Book) iter.next();
                            int bookId = abook.getId();
                            String bookName = abook.getName();
                            Float bookPrice = abook.getPrice();
                            String image = abook.getImage();
                            index++;
                            if (index == 5) {
                                break;
                            }
                    %>
                    <div class="shop_item">
                        <div class="shop_img">
                            <a href="BookDetailServlet?Bid=<%=bookId%>"><img src="<%=image%>" alt="image"/></a>
                        </div>
                        <h3><%=bookName%></h3>
                        <p>$<%=bookPrice%></p>
                        <input type="hidden" value="Add to cart"/>
                    </div>  
                    <%
                        }
                    %>
                </div>
            </div>
        </div>



        <div class="shopTit comWidth">
            <h3><a href="#" name="Biographies" class="more">Biographies&Memoirs</a></h3>
            <a href="#" class="more">More&gt&gt</a>
        </div>
        <div class="shopList comWidth clearfix">
            <div class="leftArea">              
            </div>

            <div class="rightArea">
                <div class="shopList_top clearfix">
                    <%                List books2 = bookSearch.searchBooksByBio();
                        //out.print(books.size());
                        Iterator iter2 = books2.iterator();

                        int index2 = 0;
                        while (iter2.hasNext()) {
                            Book abook = (Book) iter2.next();
                            int bookId = abook.getId();
                            String bookName = abook.getName();
                            Float bookPrice = abook.getPrice();
                            String image = abook.getImage();
                            index2++;
                            if (index2 == 5) {
                                break;
                            }
                    %>
                    <div class="shop_item">
                        <div class="shop_img">
                            <a href="BookDetailServlet?Bid=<%=bookId%>"><img src="<%=image%>" alt="image"/></a>
                        </div>
                        <h3><%=bookName%></h3>
                        <p>$<%=bookPrice%></p>
                        <input type="hidden" value="Add to cart"/>
                    </div>  
                    <%
                        }
                    %>
                </div>
            </div>
        </div>


        <div class="shopTit comWidth">
            <h3><a href="#" name="Child" class="more">Children Books</a></h3>
            <a href="#" class="more">More&gt&gt</a>
        </div>
        <div class="shopList comWidth clearfix">
            <div class="leftArea">              
            </div>
            <div class="rightArea">
                <div class="shopList_top clearfix">
                    <%
                        List books3 = bookSearch.searchBooksByChild();
                        //out.print(books.size());
                        Iterator iter3 = books3.iterator();
                        int index3 = 0;
                        while (iter3.hasNext()) {
                            Book abook = (Book) iter3.next();
                            int bookId = abook.getId();
                            String bookName = abook.getName();
                            Float bookPrice = abook.getPrice();
                            String image = abook.getImage();
                            index3++;
                            if (index3 == 5) {
                                break;
                            }
                    %>
                    <div class="shop_item">
                        <div class="shop_img">
                            <a href="BookDetailServlet?Bid=<%=bookId%>"><img src="<%=image%>" alt="image"/></a>
                        </div>
                        <h3><%=bookName%></h3>
                        <p>$<%=bookPrice%></p>
                        <input type="hidden" value="Add to cart"/>
                    </div>  
                    <%
                        }
                    %>
                </div>
            </div>
        </div>


        <div class="shopTit comWidth">
            <h3><a href="#" name="his" class="more">History</a></h3>
            <a href="#" class="more">More&gt&gt</a>
        </div>
        <div class="shopList comWidth clearfix">
            <div class="leftArea">              
            </div>
            <div class="rightArea">
                <div class="shopList_top clearfix">
                    <%
                        List books4 = bookSearch.searchBooksByHis();
                        //out.print(books.size());
                        Iterator iter4 = books4.iterator();
                        int index4 = 0;
                        while (iter4.hasNext()) {
                            Book abook = (Book) iter4.next();
                            int bookId = abook.getId();
                            String bookName = abook.getName();
                            Float bookPrice = abook.getPrice();
                            String image = abook.getImage();
                            index4++;
                            if (index4 == 5) {
                                break;
                            }
                    %>
                    <div class="shop_item">
                        <div class="shop_img">
                            <a href="BookDetailServlet?Bid=<%=bookId%>"><img src="<%=image%>" alt="image"/></a>
                        </div>
                        <h3><%=bookName%></h3>
                        <p>$<%=bookPrice%></p>
                        <input type="hidden" value="Add to cart"/>
                    </div>  
                    <%
                        }
                    %>
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
