<%-- 
    Document   : Q4SQLOutput
    Created on : 2017-4-18, 15:29:46
    Author     : surface
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="q4bean" class="SQL.Bean.Q4Bean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="style/main.css">
        <link type="text/css" rel="stylesheet" href="style/login.css">
        <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> 
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="table table-striped">
            <tr><td>Top 2 Customer Categories: </td></tr>
            <tr>
            <%
                ArrayList<ArrayList<String>> list = q4bean.getList();
                ArrayList<String> topCustomer = list.get(0);
                Iterator<String> it = topCustomer.iterator();
                while(it.hasNext()){
                    %>
                    <td><%=it.next()%></td>
                    <%
                }
            %>
            </tr>
            <tr></tr><tr></tr>
        </table>
        <table class="table table-striped">
            <tr>Top Product Category:</tr>
            <tr>
            <%
                ArrayList<String> topProduct = list.get(1);
                Iterator<String> it2 = topProduct.iterator();
                while(it2.hasNext()){
                    %>
                    <td><%=it2.next()%></td>
                    <%
                }
            %>
            </tr>
            <tr></tr><tr></tr>
        </table>
    </body>
</html>
