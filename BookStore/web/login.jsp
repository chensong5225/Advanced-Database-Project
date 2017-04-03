<%-- 
    Document   : login
    Created on : Apr 1, 2017, 10:52:28 PM
    Author     : mac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <link type="text/css" rel="stylesheet" href="style/login.css">
</head>
<body>
<div class ="headerBar">
    <div class="logoBar login_logo">
        <div class="comWidth">
            <div class="logo fl">
                <a href="#"><img height="50px" width="50px" src="images/BG.png" alt="Logo"></a>
            </div>
            <h3 class="welcome_title"></h3>
        </div>
    </div>
</div>
<div class="loginBox">
    <center>
        <form action="#">
            <table>
                <tr><td>UserName:</td></tr>
                <tr><td><input type="text"></td></tr>
                <tr><td>Password:</td></tr>
                <tr><td><input type="text"></td></tr>
                <tr><td><input type="button" value="login" class="login_btn"></td></tr>
            </table>
        </form>
        <a href="#" class="reg_link">Register&gt&gt</a>
    </center>
</div>

<div class="footer">
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
</div>
</body>
</html>
