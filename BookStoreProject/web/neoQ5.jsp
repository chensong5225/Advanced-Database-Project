<%-- 
    Document   : neoQ5
    Created on : Apr 18, 2017, 5:20:28 PM
    Author     : hom19
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Neo4j.beans.Q5_result"%>
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
        <jsp:useBean id="Q5" class="Neo4j.Q5_region_sale" ></jsp:useBean>
            <table class="table table-striped">
            <%
                ArrayList<Q5_result> result = Q5.answer();
                Iterator iter = result.iterator();
                while (iter.hasNext()) {
                     Q5_result q5 = (Q5_result) iter.next();%>
            <tr><td>Region:</td><td><%= q5.getRegion()%></td></tr>
            <tr><td>Sale:</td><td><%= q5.getSale()%></td></tr>
            <%
                }
            %>
        </table>
    </body>
</html>
