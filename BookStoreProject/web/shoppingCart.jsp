<%-- 
    Document   : shoppingCart
    Created on : Apr 1, 2017, 10:54:15 PM
    Author     : mac
--%>

<%@page import="java.util.Iterator"%>
<%@page import="xy.bean.Cart"%>
<%@page import="xy.bean.Book"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
        <link type="text/css" rel="stylesheet" href="style/reset.css">
        <link type="text/css" rel="stylesheet" href="style/main.css">
        <link type="text/css" rel="stylesheet" href="style/cart.css">
        <script type="text/javascript" src="js/jquery-3.2.0.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script> 
        <script type="text/javascript"> //Reference from: http://www.jb51.net/article/50732.htm
            function Mongodbrequest() {
                alert("click button");
                /*先删除以前查找的内容*/
                $("#show_Sch_Rlt").empty();
                var inputSearch = $('#User_Sch_input').val();
                alert("input search -->" + inputSearch);
                var xmlhttp;
                var txt, x, i;
                if (window.XMLHttpRequest) {
                    xmlhttp = new XMLHttpRequest();
                } else {
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        xmlDoc = xmlhttp.responseText;
                        txt = "";
                        /*接受数据并且显示*/
                        NameSearchShow(xmlDoc);
                    }
                }
                xmlhttp.open("GET", "http://localhost:8080/SteamGame/NameSearch", true);
                xmlhttp.setRequestHeader("MyHeader", inputSearch);
                xmlhttp.send();
            }


            $(function () {
                //Reference from: http://www.jb51.net/article/50732.htm
                $(".add").click(function () {
                    var t = $(this).parent().find('input[class*=text_box]');
                    t.val(parseInt(t.val()) + 1)
                    setTotal();
                })
                $(".min").click(function () {
                    var t = $(this).parent().find('input[class*=text_box]');
                    t.val(parseInt(t.val()) - 1)
                    if (parseInt(t.val()) < 0) {
                        t.val(0);
                    }
                    setTotal();
                })
                function setTotal() {
                    var s = 0;
                    $("#tab td").each(function () {
                        s += parseInt($(this).find('input[class*=text_box]').val()) * parseFloat($(this).find('span[class*=price]').text());
                    });
                    $("#total").html(s.toFixed(2));
                }
                setTotal();

            })
        </script>
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
                        <a href="OrderHistoryServlet" class="collection">Order</a>
                    </div>
                    <div class="rightArea">
                        <!--   Welcome to our website! <a href="#">[Login]</a> <a href="#">[Register]</a>-->
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
        <div class="show" name="cart">
            <h2>Shopping Cart</h2>
            <%
                HttpSession hs = request.getSession(true);
                List<Book> bookList = (List<Book>) hs.getAttribute("bookList");
                List<Cart> cartList = (List<Cart>) hs.getAttribute("cartList");
                Iterator itb = bookList.iterator();
                Iterator itc = cartList.iterator();
                //int index = 0;
                float total_price = 0;
                while (itb.hasNext() && itc.hasNext()) {
                    Book book = (Book) itb.next();
                    Cart cart = (Cart) itc.next();
                    //index++;
                    total_price = total_price + (float) (book.getPrice()) * Integer.valueOf(cart.getQuantity());

            %>
            <form action="CartCheckOut"method="post">
                <table id="goods">
                    <tr>
                        <td><img src="<%= book.getImage()%>" width="200" height="100"/></td>
                        <td>Book Name: <%= book.getName()%></td>
                    </tr>
                    <tr> 
                        <td></td>
                        <td> 
                            <span>Price:</span><span class="price"><%= book.getPrice()%>&nbsp;&nbsp;&nbsp;&nbsp;</span> 
                            <input class="min" name="" type="button" value="-" /> 
                            <input class="text_box" name="amount" type="text" value="<%= cart.getQuantity()%>" /> 
                            <input class="add" name="" type="button" value="+" /> 
                        </td> 
                    </tr> 
                    <tr><td></td><td></td></tr>
                    <tr><td></td><td></td><td></td><td><a href="CartDeleteServlet?Bid=<%= book.getId()%>">Delete</a></td><td></td><td></td></tr>
                    <tr></tr>
                    <tr></tr> 
                </table>
                <%
                    }
                %>

                <table>
                    <tr><td>total:<%= total_price%></td><td></td><td></td></tr>
                    <tr><td></td><td></td><td></td></tr>
                    <tr><td></td><td></td><td></td></tr>
                    <div class="br25"></div>
                    <tr><td></td><td></td><td></td><td><a href="index.jsp">continue shopping.</a></td></tr>
                    <tr><td><input type="submit" class="cart_btn" value="Check Out"/></td></tr>
                </table>

            </form>
        </div>
    </center>
    <div class="footer">
        <p>INFSCI 2711: Advanced Topics in Database Management</p>
        <p>University of Pittsburgh</p>
        <p>School of Information Sciences</p>
    </div>
</body>
</html>
