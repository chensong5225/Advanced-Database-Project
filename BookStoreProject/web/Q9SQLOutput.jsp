<%-- 
    Document   : Q9SQLOutput
    Created on : 2017-4-18, 22:45:38
    Author     : surface
--%>

<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="q9bean" class="SQL.Bean.Q9Bean" scope="session"/>
<jsp:useBean id="salesBean" class="SQL.Bean.ArrayListBean" scope="session"/>
<jsp:useBean id="storeBean" class="SQL.Bean.ArrayListBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>
        
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
            <tr><td>Region compare: </td></tr>
            <%
                HashMap<String, Double> map = q9bean.getMap();
                for(String s: map.keySet()){
                    %>
                    <tr><td>
                            Store: <%=s%> </td><td>   Sales:<%=map.get(s)%>
                    </td></tr>
                    <%
                }
            %>
            
        </table>
            
    </body>
</html>
