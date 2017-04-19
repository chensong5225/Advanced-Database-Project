<%-- 
    Document   : neoQ9
    Created on : Apr 19, 2017, 12:36:30 AM
    Author     : hom19
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Neo4j.beans.Q9_result"%>
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

        <jsp:useBean id="Q9" class="Neo4j.Q9_store_sale" ></jsp:useBean>
            <table class="table table-striped">
            <%
                ArrayList<Q9_result> result = Q9.answer();
                Iterator iter = result.iterator();
                while (iter.hasNext()) {
                    Q9_result q9 = (Q9_result) iter.next();%>
            <tr><td>Store:</td><td><%= q9.getStore()%></td></tr>
            <tr><td>Sale:</td><td><%= q9.getSale()%></td></tr>
            <%
                }
            %>
        </table>



    </body>
</html>
