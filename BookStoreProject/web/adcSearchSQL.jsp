<%-- 
    Document   : adcSearchSQL
    Created on : 2017-4-17, 19:08:21
    Author     : surface
--%>
<%@page import="SQL.Bean.BookBean"%>
<%@page import="SQL.Bean.TransactionBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="trs" class="SQL.Aggregation.SQLTransactionService" scope="session"/>
<jsp:useBean id="productSearch"  class="SQL.Aggregation.SQLProductService" scope="session"/>
<jsp:useBean id="sqlBean" class="SQL.Bean.SQLMessageBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>adcSearch</title>
        <link type="text/css" rel="stylesheet" href="style/main.css">
        <link type="text/css" rel="stylesheet" href="style/login.css">
        <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> 
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                start = $( "#todayq3" ).datepicker({
                    dateFormat:"yy-mm-dd"
                });
            } );
            $( function() {               
                $( "#todayq4" ).datepicker({
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
        
        <div class="adSearch">
            
            <div class="col-md-2 column"></div>
                <div class="col-md-8 column">
                
            <table class="table table-striped">
                <thead>
                    <th></th>
                    <th>Question</th>
                    <th>Solution</th>
                </thead>
                <tbody>
                    <div class="col-md-2 column">
                        <div class="col-md-8 column">
                            <tr>
                                <td><td>Implement Data Warehouse</td></td>
                                <td><a href="Q0ServletSQL">start</a></td>
                                <td><jsp:getProperty name="sqlBean" property="message"/></td>
                            </tr>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 column">
                        <tr>
                            <td><td>1.What is the ratio of business to home customers?</td></td>
                            <td><a href="Q1ServletSQL">result</a></td>
                        </tr>
                        </div>
                    </div>
                <div class="row">
                    <div class="col-md-12 column">
                    <tr>
                        <td><td>2.What stores are increasing in sales?</td></td>
                        <form action="Q2ServletSQL">
                            <td>Start: <input type="text" id="startdate" name="startdate" placeholder="YYYY-MM--DD"/></td>
                            <td>End: <input type="text" id="enddate" name="enddate" placeholder="YYYY-MM--DD"/></td>
                        <td><input type="submit" value="submit"/></td>
                        </form></tr>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 column">    
                    <tr>
                        <td><td>3.Maintain every day the aggregate sales and profit of the top 5 and the bottom 5 products.</td></td>
                        <form action="Q3ServletSQL">
                        <td>Maintain today: <input type="text" id="todayq3" name="todayq3" placeholder="YYYY-MM--DD"/></td>
                        <td><td><input type="submit" value="submit"></form></td></td>
                    </tr>
                </div>
                </div>
                
                <div class="row">
                    <div class="col-md-12 column">    
                        <tr>
                            <td><td>4.Maintain every day the top 2 customer categories (highest sales) and the top product categories.</td></td>
                            <form action="Q4ServletSQL">
                            <td>Maintain today:<input type="text" id="todayq4" name="todayq4" placeholder="YYYY-MM--DD"/></td>
                            <td><td><input type="submit" value="submit"/></form></td></td>
                        </tr>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-md-12 column">    
                        <tr>
                            <td><td>5.How do the various regions compare by sales volume?</td></td>
                            <td><a href="Q5ServletSQL">result</a></td>
                        </tr>
                    </div>
                </div>
                
                            
                <div class="row">
                    <div class="col-md-12 column">    
                        <tr>
                            <td><td>6.Which businesses are buying given products the most?</td></td>
                            <form action="Q6ServletSQL">
                            <td><select id="sn1" name="sn1"><option value="Select" selected="selected">Select</option>   
                    <%
                        List products = productSearch.findProductList();
                        Iterator iter = products.iterator();
                     while (iter.hasNext()) {
                                    BookBean book = (BookBean) iter.next();
                                    String bname = book.getName();%>
                            <option value="<%= bname%>" ><%=  bname%></option>
                                <%}%></td>
                    <td><td><input type="submit" value="submit"></form></td></td>
                        </tr>    
                    </div>
                </div>    
                
                <div class="row">
                    <div class="col-md-12 column">    
                        <tr>
                            <td><td>7.What is the demand curve for each product category?</td></td>
                        <form action="Q7ServletSQL">
                            <td><select id="sn2" name="sn2"><option value="Scrappy Little Nobody" selected="selected">Select</option>
                    <%
                        List products2 = productSearch.findProductList();
                        Iterator iter2 = products2.iterator();
                     while (iter2.hasNext()) {
                                    BookBean book = (BookBean) iter2.next();
                                    String bname = book.getName();%>
                            <option value="<%= bname%>" ><%=  bname%></option>
                            <%}%></td>        
                            <td><td><input type="submit" value="submit"></form></td></td>
                        </tr>    
                    </div>
                </div>  
                          
                <div class="row">
                    <div class="col-md-12 column">    
                        <tr>
                            <td><td>8.Develop a direct marketing data; for each product, a list of customers that buy the product more than 2 times per week.</td></td>
                            <form action="Q8ServletSQL" >
                            <td><select id="sn3" name="sn3"><option value="DanTDM: Trayaurus and the Enchanted Crystal" selected="selected">Select</option>
                    <%
                                List products3 = productSearch.findProductList();
                                Iterator iter3 = products3.iterator();
                                while (iter3.hasNext()) {
                                    BookBean book = (BookBean) iter3.next();
                                    String bname = book.getName();%>
                            <option value="<%= bname%>" ><%=  bname%></option>
                                <%}%></td>
                            <td><select id="sn4" name="sn4"><option value="select" selected="selected">Select</option>
                                    <%
                                        List weeks = trs.findWeekList();
                                        Iterator iterW = weeks.iterator();
                                        while (iterW.hasNext()) {
                                            TransactionBean tx = (TransactionBean) iterW.next();
                                            int week = tx.getWeek();%>
                                 <option value="<%= week%>"><%= week%></option>
                                <%}%></td>
                            <td><td><input type="submit" value="submit"></form></td></td>
                        </tr>    
                    </div>
                </div>  
                    
                <div class="row">
                    <div class="col-md-12 column">    
                        <tr>
                            <td><td>9.How do the various stores compare by sales volume?</td></td>
                            <td><a href="Q9ServletSQL">result</a></td>
                        </tr>    
                    </div>
                </div>  
                    </tbody>
            
                </table>
            </div>                       
        </div>
        <div class="col-md-2 column"></div>
    </body>
</html>
