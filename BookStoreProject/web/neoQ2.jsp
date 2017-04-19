<%-- 
    Document   : neoQ2
    Created on : Apr 17, 2017, 11:16:29 PM
    Author     : mac
--%>

<%@page import="Neo4j.beans.Q2_result"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> 
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>
    <body>

        <table class="table table-striped">
            <%
                HttpSession hs = request.getSession(true);
                // if (hs.getAttribute("q2")== null) {
                ArrayList<Q2_result> result = (ArrayList<Q2_result>) hs.getAttribute("q2");
                for (Q2_result q2 : result) {
                    String id = q2.getId();
                    String profit = q2.getProfit();


            %>
            <tr><td>ID:</td><td><%= id%></td></tr>
            <tr><td>Profit:</td><td><%= profit%></td></tr>
            <%}%>
        </table>        
    </body>
</html>
