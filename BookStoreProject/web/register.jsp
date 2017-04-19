<%-- 
    Document   : register
    Created on : Apr 1, 2017, 10:53:48 PM
    Author     : mac
--%>

<%@page import="xy.bean.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>register</title>
        <link type="text/css" rel="stylesheet" href="style/main.css">
        <link type="text/css" rel="stylesheet" href="style/login.css">
        <script type="text/javascript" src="js/jquery-3.2.0.js"></script>
        <script type="text/javascript" src="js/register.js"></script>
        <script type="text/javascript" language="javascript">
            /* 
             * Reference from:http://www.cnblogs.com/jiqing9006/archive/2012/09/17/2688671.html  
             * Reference from:http://www.51xuediannao.com/js/jquery/jquery_validate/
             * 
             */
            function show(obj) {
                if (obj.checked) {
                    document.getElementById("hCustomer").style.display = "block";
                    document.getElementById("pB").style.display = "none";
                } else {
                    document.getElementById("hCustomer").style.display = "hide";
                }

            }
            function showB(obj) {
                if (obj.checked) {
                    document.getElementById("bCustomer").style.display = "block";
                    document.getElementById("pH").style.display = "none";
                } else {
                    document.getElementById("bCustomer").style.display = "hide";
                }
            }


        </script>
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

        <div>
            <table>
                <% if (session.getAttribute("registerMessage") == null) {%>
                <tr><td><h3 class="hmsg"></h3></td></tr>
                        <%} else {
                            Message msg = (Message) session.getAttribute("registerMessage");%>
                <tr><td><h3 class="hmsg" style="color: #FF7700"><%= msg.getMessageInfo()%></h3></td></tr>
                <tr><td></td></tr>
                <% session.removeAttribute("registerMessage");
                    }%>
            </table>
        </div>

        <div class="chooseStatus">
            <!--Please choose your customer category?<br/><br/>-->
            <table>
                <tr><td><p id="pH"><input id="checkH" class="home_customer" value="home_customer" type="checkbox" onclick="show(this)"/>home_customer</p></td></tr>
                <tr><td><p id="pB"><input name="checkB" class="business_customer" value="business_customer" type="checkbox" onclick="showB(this)"/>business_customer</p></td></tr>
            </table>
        </div>    
        <div id="hCustomer" class="loginBox hide">
            <center>
                <form action="HomeRegisterServlet"> 
                    <table>
                        <tr><td>UserName:</td></tr>
                        <tr><td><input id="uname" name="uname" type="text"></td></tr>
                        <tr><td id="msg_uname"></td></tr>
                        <tr><td>Email:</td></tr>
                        <tr><td><input id="email" name="email" type="text"/></td></tr>
                        <tr><td id="msg_email"></td></tr>
                        <tr><td>Password:</td></tr>
                        <tr><td><input id="password" name="password" type="text"></td></tr>
                        <tr><td id="msg_pw"></td></tr>
                        <tr><td>Street:</td></tr>
                        <tr><td><input id="stet" name="stet" type="text"></td></tr>
                        <tr><td id="msg_stet"></td></tr>
                        <tr><td>City:</td></tr>
                        <tr><td><input id="city" name="city" type="text"></td></tr>
                        <tr><td id="msg_city"></td></tr>
                        <tr><td>State:</td></tr>
                        <tr><td><input id="state" name="state" type="text"></td></tr>
                        <tr><td id="msg_state"></td></tr>
                        <tr><td>Zip code:</td></tr>
                        <tr><td><input id="zip" name="zip" type="text"></td></tr>
                        <tr><td id="msg_zip"></td></tr>
                        <tr><td>Marriage status:</td></tr>
                        <tr><td><input id="ms" checked="checked" name="marriage" type="radio" value="no"/>no</td>
                            <td><input id="ms" name="marriage" type="radio" value="yes"/>yes</td>
                        </tr>
                        <tr><td>Gender:</td></tr>
                        <tr><td><input id="gr"  checked="checked" name="sex" type="radio" value="male" />male</td>
                            <td><input id="gr"   name="sex" type="radio" value="female" />female</td>
                        </tr>
                        <tr><td>age:</td></tr>
                        <tr><td><input id="age" name="age" type="text"></td></tr>
                        <tr><td>income:</td></tr>
                        <tr><td><input id="income"name="income" type="text"></td></tr>
                        <tr><td><input id="sb" type="submit" value="Register" class="reg_btn"></td></tr>
                    </table>
                </form> 
                <a href="#" class="login_link">Login&gt&gt</a>
            </center>
        </div>
        <div id="bCustomer" class="loginBox hide" >
            <center>
                <form action="BusinessRegisterServlet">
                    <table>
                        <tr><td>UserName:</td></tr>
                        <tr><td><input id="uname2" name="uname2" type="text"></td></tr>
                        <tr><td id="msg_uname"></td></tr>
                        <tr><td>Email:</td></tr>
                        <tr><td><input id="email2" name="email2" type="text"/></td></tr>
                        <tr><td id="msg_email"></td></tr>
                        <tr><td>Password:</td></tr>
                        <tr><td><input id="password2" name="password2" type="text"></td></tr>
                        <tr><td id="msg_pw"></td></tr>
                        <tr><td>Street:</td></tr>
                        <tr><td><input id="stet2" name="stet2" type="text"></td></tr>
                        <tr><td id="msg_stet"></td></tr>
                        <tr><td>City:</td></tr>
                        <tr><td><input id="city2" name="city2" type="text"></td></tr>
                        <tr><td id="msg_city"></td></tr>
                        <tr><td>State:</td></tr>
                        <tr><td><input id="state2" name="state2" type="text"></td></tr>
                        <tr><td id="msg_state"></td></tr>
                        <tr><td>Zip code:</td></tr>
                        <tr><td><input id="zip2" name="zip2" type="text"></td></tr>
                        <tr><td id="msg_zip"></td></tr>
                        <tr><td>Category:</td></tr>
                        <tr><td><select name="category">
                                    <option value="Nonprofit">Nonprofit</option>
                                    <option value="Education">Education</option>
                                    <option value="Books and magazines">Books and magazines</option>
                                    <option value="Food retail and service">Food retail and service</option>
                                    <option value="Financial services and products">Financial services and products</option>
                                </select></td></tr>
                        <tr><td>income:</td></tr>
                        <tr><td><input id="income2" name="income2" type="text"></td></tr>
                        <tr><td id="msg_income"></td></tr>
                        <tr><td><input id="sb" type="submit" value="Register" class="reg_btn"></td></tr>
                    </table>
                </form>
                Already register,<a href="login.jsp" class="login_link">Login&gt&gt</a>
            </center>
        </div>

        <div class="footer">
            <p>INFSCI 2711: Advanced Topics in Database Management</p>
            <p>University of Pittsburgh</p>
            <p>School of Information Sciences</p>
        </div>
    </body>
</html>
