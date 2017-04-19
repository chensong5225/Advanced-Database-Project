<%-- 
    Document   : neoQ8
    Created on : Apr 18, 2017, 9:40:24 PM
    Author     : hom19
--%>

<%@page import="Neo4j.beans.Q8_result"%>
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
                // if (hs.getAttribute("q3") == null) {
                ArrayList<Q8_result> result = (ArrayList<Q8_result>) hs.getAttribute("q8");
                for (Q8_result q8 : result) {
                    String customer_id = q8.getCustomer_id();
                    String product_id = q8.getProduct_id();
            %> 
            <tr><td>CustomerId:</td><td><%= customer_id%></td></tr>
            <tr><td>ProductId:</td><td><%= product_id%></td></tr>
            <%
                }
            %>
        </table>
    </body>
</html>
