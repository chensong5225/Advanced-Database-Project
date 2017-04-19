<%-- 
    Document   : Q3SQLOutput
    Created on : 2017-4-18, 14:40:45
    Author     : surface
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="q3bean" class="SQL.Bean.Q3Bean" scope="session"/>
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
            
            <%
                ArrayList<ArrayList<String>> list = q3bean.getList();
                 %>
                    <tr><td>
                            Top 5 Sales Product:
                    </td></tr>
                    <%
                ArrayList<String> top5Sales = list.get(0);
                %><tr><%
                for(String s: top5Sales){
                    %>
                    <td>
                            <%=s%>
                    </td>
                    <%
                }
                %></tr>
                    <tr><td>
                            Bottom 5 Sales Product:
                    </td></tr>
                <%
                ArrayList<String> bottom5Sales = list.get(1);
                %><tr><%
                for(String s: bottom5Sales){
                    %>
                    <td>
                            <%=s%>
                    </td>
                    <%
                }
                %></tr><%
                    
                ArrayList<String> top5Profit = list.get(2);
                %>
                    <tr><td>
                            Top 5 Profit Product:
                    </td></tr>
                    <tr>
                <%
                for(String s: top5Profit){
                    %>
                    <td>
                            <%=s%>
                    </td>
                    <%
                }
                %></tr><%
                
                ArrayList<String> bottom5Profit = list.get(3);
                %>
                    <tr><td>
                            Bottom 5 Profit Product:
                    </td></tr>
                    <tr>
                <%
                for(String s: top5Profit){
                    %>
                    <td>
                            <%=s%>
                    </td>
                    <%
                }
                %></tr>
               
            
        </table>
    </body>
</html>
