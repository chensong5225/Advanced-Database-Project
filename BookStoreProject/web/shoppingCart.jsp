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
        <script type="text/javascript" src="js/jquery-3.2.0.js"></script>
        <script type="text/javascript">
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


            function checkout() {
                location.href = "index.jsp";
            }
            function add(event) {
                var id = $(event.currentTarget).attr('data-id');

                var amount = $("#" + id).text();
                $("#" + id).text(parseInt(amount) + 1);
                $("#getAmount" + id).val(parseInt(amount) + 1);
            }
            function minus(event) {
                var id = $(event.currentTarget).attr('data-id');

                var amount = $("#" + id).text();
                if (parseInt(amount) == 0) {
                    $("#" + id).text(0);
                    $("#getAmount" + id).val(0);
                } else {
                    $("#" + id).text(parseInt(amount) - 1);
                    $("#getAmount" + id).val(parseInt(amount) - 1);
                }
            }
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
                        <a href="#" class="collection">Order</a>
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
        <div class="show" name="cart">
            <h2>Shopping Cart</h2>
            <form action=""method="post">
                <table id="goods">
                    <tr>
                        <td><img src="#" width="200" height="100"/></td>
                        <td>Book Name:</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Amount:</td><td></td><td id="minus"  style="text-align:right" onclick="minus(event)">- </td><td style="text-align:left" class="amount"</td><td id="add" onclick="add(event)"> +</td>
                    </tr>
                    <tr><td></td><td>Book Information:</td><td></td></tr>
                    <tr></tr>
                    <tr><td></td><td></td><td></td><td><a href="/DeleteBook?Bid=#">Delete</a></td><td></td><td></td></tr>
                    <tr><td></td><td></td><td></td><td>Price:$</td><td></td></tr>
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
    </center>
    <div class="footer">
        <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
        <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
        <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
    </div>
</body>
</html>
