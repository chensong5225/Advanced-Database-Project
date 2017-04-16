<%-- 
    Document   : register
    Created on : Apr 1, 2017, 10:53:48 PM
    Author     : mac
--%>

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






            function check(obj) {
                $(":radio").removeAttr("checked");
                obj.setAttribute("checked", "checked");
            }
            $(document).ready(function () {
                $("#sb").click(function () {

                    var valid1 = 0;
                    var valid2 = 0;
                    var valid3 = 1;
                    var Gender = null;
                    var Marriage = null;
                    $("#gr").each(function () {
                        if ($(this).attr("checked") === "checked") {
                            Gender = $(this).attr("value");
                        }
                    });
                    $("#ms").each(function () {
                        if ($(this).attr("checked") === "checked") {
                            Marriage = $(this).attr("value");
                        }
                    });

                    hcname = document.getElementById("name1").value;
                    password = document.getElementById("pwd1").value;
                    street = document.getElementById("street").value;
                    city = document.getElementById("city").value;
                    state = document.getElementById("state").value;
                    zip = document.getElementById("zip").value;
                    age = document.getElementById("age").value;
                    income = document.getElementById("income").value;

                    if (hcname === '') {
                        alert("username could not be null");
                        valid3 = 0;
                        document.getElementById("name1").style.borderColor = "#FF7700";
                    }


                });
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
        <div class="chooseStatus">
            <!--Please choose your customer category?<br/><br/>-->
            <table>
                <tr><td><p id="pH"><input id="checkH" class="home_customer" value="home_customer" type="checkbox" onclick="show(this)"/>home_customer</p></td></tr>
                <tr><td><p id="pB"><input name="checkB" class="business_customer" value="business_customer" type="checkbox" onclick="showB(this)"/>business_customer</p></td></tr>
            </table>
        </div>    

        <div id="hCustomer" class="loginBox hide">
            <center>
                <!--  <form action="#"> -->
                <table>
                    <tr><td>UserName:</td></tr>
                    <tr><td><input id="name1" type="text"></td></tr>
                    <tr><td>Password:</td></tr>
                    <tr><td><input id="pwd1" type="password"></td></tr>
                    <tr><td>Street:</td></tr>
                    <tr><td><input id="street" type="text"></td></tr>
                    <tr><td>City:</td></tr>
                    <tr><td><input id="city" type="text"></td></tr>
                    <tr><td>State:</td></tr>
                    <tr><td><input id="state" type="text"></td></tr>
                    <tr><td>Zip code:</td></tr>
                    <tr><td><input id="zip" type="text"></td></tr>
                    <tr><td>Marriage status:</td></tr>
                    <tr><td><input id="ms" onclick="check(this)" checked="checked" name="marriage" type="radio" value="no"/>no</td>
                        <td><input id="ms" onclick="check(this)" name="marriage" type="radio" value="yes"/>yes</td>
                    </tr>
                    <tr><td>Gender:</td></tr>
                    <tr><td><input id="gr" onclick="check(this)" checked="checked" name="sex" type="radio" value="male" />male</td>
                        <td><input id="gr" onclick="check(this)"  name="sex" type="radio" value="female" />female</td>
                    </tr>
                    <tr><td>age:</td></tr>
                    <tr><td><input id="age" type="text"></td></tr>
                    <tr><td>income:</td></tr>
                    <tr><td><input id="income" type="text"></td></tr>
                    <tr><td><input id="sb" type="submit" value="Register" class="reg_btn"></td></tr>
                </table>
                <!--   </form> -->
                <a href="#" class="login_link">Login&gt&gt</a>
            </center>
        </div>
        <div id="bCustomer" class="loginBox hide" >
            <center>
                <form action="#">
                    <table>
                        <tr><td>UserName:</td></tr>
                        <tr><td><input type="text"></td></tr>
                        <tr><td>Password:</td></tr>
                        <tr><td><input type="text"></td></tr>
                        <tr><td>Street:</td></tr>
                        <tr><td><input type="text"></td></tr>
                        <tr><td>City:</td></tr>
                        <tr><td><input type="text"></td></tr>
                        <tr><td>State:</td></tr>
                        <tr><td><input type="text"></td></tr>
                        <tr><td>Zip code:</td></tr>
                        <tr><td><input type="text"></td></tr>
                        <tr><td>Category:</td></tr>
                        <tr><td><select>
                                    <option value="Nonprofit">Nonprofit</option>
                                    <option value="Education">Education</option>
                                    <option value="Books and magazines">Books and magazines</option>
                                    <option value="Food retail and service">Food retail and service</option>
                                    <option value="Financial services and products">Financial services and products</option>
                                </select></td></tr>
                        <tr><td>income:</td></tr>
                        <tr><td><input type="text"></td></tr>
                        <tr><td><input id="sb" type="submit" value="Register" class="reg_btn"></td></tr>
                    </table>
                </form>
                Already register,<a href="#" class="login_link">Login&gt&gt</a>
            </center>
        </div>

        <div class="footer">
            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
        </div>
    </body>
</html>
