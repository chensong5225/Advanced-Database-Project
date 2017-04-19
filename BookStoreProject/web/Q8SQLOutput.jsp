<%-- 
    Document   : Q8SQLOutput
    Created on : 2017-4-17, 23:40:41
    Author     : surface
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="q8bean" class="SQL.Bean.ArrayListBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        

    </head>
    <body>
        <table>
            
            <tr><td>Business plan:</td></tr>
            <%
                ArrayList<String> list = q8bean.getList();
                Iterator<String> it = list.iterator();
                while(it.hasNext()){
                    %>
                    <tr><td><%=it.next()%></td></tr>
                    <%
                }
            %>
            
        </table>  
        
    </body>
</html>
