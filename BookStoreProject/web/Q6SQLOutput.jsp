<%-- 
    Document   : Q6SQLOutput
    Created on : 2017-4-17, 22:18:31
    Author     : surface
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="q6bean" class="SQL.Bean.ArrayListBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <td>Business buying most:</td>
            <%
                ArrayList<String> list = q6bean.getList();
                Iterator<String> it = list.iterator();
                while(it.hasNext()){
                    %>
                    <td><%=it.next()%></td>
                    <%
                }
            %>
            
        </table>
    </body>
</html>
