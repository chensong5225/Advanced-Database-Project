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
    <script type="text/javascript" language="javascript">
        function show(obj){
            if(obj.checked){
                document.getElementById("hCustomer").style.display="block";
                document.getElementById("pB").style.display="none";
            }
            else{
                document.getElementById("hCustomer").style.display="hide";
            }   
            
        }
        function showB(obj){
            if(obj.checked){
                document.getElementById("bCustomer").style.display="block";
                document.getElementById("pH").style.display="none";
            }
            else{
                document.getElementById("bCustomer").style.display="hide";
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
    <div class="chooseStatus">
        <!--Please choose your customer category?<br/><br/>-->
        <p id="pH"><input id="checkH" class="home_customer" value="home_customer" type="checkbox" onclick="show(this)"/>home_customer</p>
        <p id="pB"><input name="checkB" class="business_customer" value="business_customer" type="checkbox" onclick="showB(this)"/>business_customer</p>
    </div>    
    <div id="hCustomer" class="loginBox hide">
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
                <tr><td>Marriage status:</td></tr>
                <tr><td><select>
                            <option value="yes">Yes</option>
                            <option value="no">No</option>
                        </select></td></tr>
                <tr><td>gender:</td></tr>
                <tr><td><select>
                            <option value="female">Female</option>
                            <option value="male">Male</option>
                        </select></td></tr>
                <tr><td>age:</td></tr>
                <tr><td><input type="text"></td></tr>
                <tr><td>income:</td></tr>
                <tr><td><input type="text"></td></tr>
                <tr><td><input type="button" value="Register" class="reg_btn"></td></tr>
            </table>
        </form>
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
                <tr><td><input type="button" value="Register" class="reg_btn"></td></tr>
            </table>
        </form>
        <a href="#" class="login_link">Login&gt&gt</a>
    </center>
    </div>

<div class="footer">
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
</div>
</body>
</html>
