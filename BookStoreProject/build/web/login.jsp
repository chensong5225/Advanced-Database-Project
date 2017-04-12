<%-- 
    Document   : login
    Created on : Apr 1, 2017, 10:52:28 PM
    Author     : mac
--%>

<%@page import="xy.bean.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link type="text/css" rel="stylesheet" href="style/main.css">
        <link type="text/css" rel="stylesheet" href="style/login.css">
        <script type="text/javascript" src="js/jquery-3.2.0.js" ></script>
        <script language="javascript" type="text/javascript">//Reference from: https://my.oschina.net/moson/blog/147370   http://blog.csdn.net/u011031689/article/details/50866713
            function check_name() {
                var tag = document.getElementById('uname');
                var msg = document.getElementById('msg_uname');
                msg.innerHTML = "";
                tag.style.border = "0";
                reg = /^[\w\u4E00-\u9FA5]{1,}$/;
                if (!reg.test(tag.value)) {
                    tag.style.border = "2px solid #EEEE00";
                    msg.style.color = "#FF7700";
                    msg.innerHTML = "Username must be 1 or more character or number.";
                    return false;
                }
                return true;
            }
            function check_pwd() {
                var tag = document.getElementById('pwd');
                var msg = document.getElementById('msg_pwd');
                msg.innerHTML = "";
                tag.style.border = "0";
                if (tag.value == '') {
                    tag.style.border = "2px solid #EEEE00";
                    msg.style.color = "#FF7700";
                    msg.innerHTML = "You must fill your password.";
                    return false;
                }
                return true;
            }
            function check() {
                return check_name() && check_pwd();
            }
            window.onload = function () {
                var tag = document.getElementById('uname');
                tag.onblur = check_name;
                var tag2 = document.getElementById('pwd');
                tag2.onblur = check_pwd;
            }
            
        </script>
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
                <form action="loginServlet" onsubmit="return check();">
                <table>
                    <tr><td>UserID:</td></tr>
                    <tr><td><input id="uname" type="text" name="uid"></td></tr>
                    <tr><td id="msg_uname"></td></tr>
                    <tr><td>Password:</td></tr>
                    <tr><td><input id="pwd" type="text" name="password"></td></tr>
                    <tr><td id="msg_pwd"></td></tr>
                    <tr><td><input type="submit" value="login" class="login_btn"></td></tr>
                    <% if (session.getAttribute("msgInfo") == null) {%>
                    <tr><td><h3 class="hmsg"></h3></td></tr>
                    <%}else{
                    Message msg = (Message) session.getAttribute("msgInfo");%>
                    <tr><td><h3 class="hmsg" style="color: #FF7700"><%= msg.getMessageInfo()%></h3></td></tr>
                    <tr><td>If you not have an account, please click </td></tr>
                    <% session.removeAttribute("msgInfo");
                     }%>
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
