<%-- 
    Document   : checkOut
    Created on : Apr 1, 2017, 10:51:05 PM
    Author     : mac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>checkOut</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <link type="text/css" rel="stylesheet" href="style/cart.css">
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

<div class="shoppingCart comWidth">
    <div class="shopping_item">
        <h3 class="shopping_tit">Address</h3>
        <div class="shopping_cont padding_shop">
            <ul class="shopping_list">
                <li><span class="shopping_list_text"><em>*</em>Street:</span><input class="ipt" type="text"></li>
                <li><span class="shopping_list_text"><em>*</em>City:</span><input class="ipt" type="text"></li>
                <li><span class="shopping_list_text"><em>*</em>State:</span><input class="ipt" type="text"></li>
                <li><span class="shopping_list_text"><em>*</em>Name:</span><input class="ipt" type="text"></li>
            </ul>
        </div>
        <form action="#">
            <input class="che_btn" type="button" value="CheckOut">
        </form>
    </div>
</div>

<div class="footer">
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
</div>
</body>
</html>
