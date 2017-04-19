<%-- 
    Document   : Q1SQLOutput
    Created on : 2017-4-17, 19:36:17
    Author     : surface
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="q1bean" class="SQL.Bean.Q1Bean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SQL Output Q1</title>
    </head>
    <body>
        <table class="table table-striped">    
            <tr><td>Customer ratio: </td><td><jsp:getProperty name="q1bean" property="home"/></td><td>:</td> <td><jsp:getProperty name="q1bean" property="business"/> </td></tr>
        </table>
        
    </body>
</html>
