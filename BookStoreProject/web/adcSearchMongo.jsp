<%-- 
    Document   : adcSearch
    Created on : Apr 9, 2017, 4:21:28 PM
    Author     : mac
--%>

<%@page import="xy.bean.Book"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>adcSearch</title>
        <link type="text/css" rel="stylesheet" href="style/main.css">
        <link type="text/css" rel="stylesheet" href="style/login.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script>
            $(function () {
                start = $("#startdate").datepicker({
                    dateFormat: "yy-mm-dd"
                });
            });
            $(function () {
                $("#enddate").datepicker({
                    dateFormat: "yy-mm-dd"
                });
            });
             $( function() {
                start = $( "#startdate2" ).datepicker({
                    dateFormat:"yy-mm-dd"
                });
            } );
            $( function() {               
                $( "#enddate2" ).datepicker({
                    dateFormat:"yy-mm-dd"
                });
            } );
            $( function() {
                start = $( "#startdate3" ).datepicker({
                    dateFormat:"yy-mm-dd"
                });
            } );
            $( function() {               
                $( "#enddate3" ).datepicker({
                    dateFormat:"yy-mm-dd"
                });
            } );
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
        <jsp:useBean id="productSearch"  class="xy.service.ProductService"></jsp:useBean>
        <%
            List products = productSearch.findProductList();
            Iterator iter = products.iterator();
        %>
        <div class="adSearch">
            <table>
                <tr><td>1.What is the ratio of business to home customers?</td><td><a href="itemClass.jsp">result</a></td></tr>
                
                <tr><td>2.What stores are increasing in sales?</td><td></td></tr>
                <tr><form action="MongoServletQ2"><td>Start date: 
                        <input type="text" id="startdate" name="startdate" placeholder="YYYY-MM--DD"/></td>
                    <td>End date: 
                        <input type="text" id="enddate" name="enddate" placeholder="YYYY-MM--DD"/></td></tr>
                <tr><td></td><td></td></tr>
                <tr><td></td><td><input type="submit" value="submit"/></form></td></tr>
        
        
                <tr><td>3.Maintain every day the aggregate sales and profit of the top 5 and the bottom 5 products.</td><td></td></tr>
                <tr><form action="#"><td>Start date: 
                        <input type="text" id="startdate2" name="startdate" placeholder="YYYY-MM--DD"/></td>
                    <td>End date: 
                        <input type="text" id="enddate2" name="enddate" placeholder="YYYY-MM--DD"/></td></tr>
                <tr><td></td><td><input type="submit" value="submit"></form></td></tr>
        
        
                <tr><td>4.Maintain every day the top 2 customer categories (highest sales) and the top product categories.</td><td></td></tr>
                <tr><form action="#"><td>Start date: 
                        <input type="text" id="startdate3" name="startdate" placeholder="YYYY-MM--DD"/></td>
                    <td>End date: 
                        <input type="text" id="enddate3" name="enddate" placeholder="YYYY-MM--DD"/></td></tr>
                <tr><td></td><td><input type="submit" value="submit"/></form></td></tr>
        
                <tr><td>5.How do the various regions compare by sales volume?</td><td><a href="#">result</a></td></tr>             
                
                 <tr><form action="#"><td>6.Which businesses are buying given products the most?</td><td><select id="sn1" name="sn1"><option value=""  selected="selected">please select.</option>
                            <% while (iter.hasNext()) {
                                    Book book = (Book) iter.next();
                                    int bid = book.getId();
                                    String bname = book.getName();%>
                            <option value="<%= bname%>" ><%=  bname%></option>
                            <%}%>
                        </select></td><td><input type="submit" value="submit"/></form></td></tr>
                        <%
                            List products2 = productSearch.findProductList();
                            Iterator iter2 = products2.iterator();
                        %>
            
                <tr><form action="#"><td>7.What is the demand curve for each product category?</td><td><select id="sn2" name="sn2"><option value="pls" selected="selected">please select.</option>
                
                            <%
                                while (iter2.hasNext()) {
                                    Book book2 = (Book) iter2.next();
                                    int bid2 = book2.getId();
                                    String bname2 = book2.getName();
                            %>
                            <option value="<%=bname2%>"><%=bname2%></option>
                            <%}
                            %>
                        </select></td><td><input type="submit" value="submit"/></form></td></tr>
                        <%
                            List products3 = productSearch.findProductList();
                            Iterator iter3 = products3.iterator();
                        %>
                <tr><form action="#" ><td>8.Develop a direct marketing data; for each product, a list of customers that buy the product more than 2 times per week.</td><td>
                        <select id="week" name="week"><option value="pls" selected="selected">please select.</option>

                        </select>
                    </td><td>
                        <select id="sn3" name="sn3"><option value="pls" selected="selected">please select.</option>
                            <%
                                while (iter3.hasNext()) {
                                    Book book3 = (Book) iter3.next();
                                    int bid3 = book3.getId();
                                    String bname3 = book3.getName();
                            %>
                            <option value="<%=bname3%>"><%=bname3%></option>
                            <%}
                            %>
                        </select>
                    </td><td><input type="submit" value="submit"/></form></td></tr>
                <tr><td>9.Other interesting aggregate values that you will come up with.</td><td><a href="#">result</a></td></tr>
            </table>
        </div>
        <div class="footer">
            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>
        </div>
    </body>
</html>
