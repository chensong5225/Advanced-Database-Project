<%-- 
    Document   : neoQ6
    Created on : Apr 18, 2017, 5:30:39 PM
    Author     : hom19
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Neo4j.beans.Q6_result"%>
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
                // if (hs.getAttribute("q3") == null) {
                ArrayList<Q6_result> result = (ArrayList<Q6_result>) hs.getAttribute("q6");
                for (Q6_result q6 : result) {
                    String business = q6.getBusiness();
                    String sale = q6.getSale();
            %>
            <tr><td>Customer category:</td><td><%= business%></td></tr>
            <tr><td>Sale:</td><td><%= sale%></td></tr>
            <%
                }
            %>
        </table>
    </body>
</html>
