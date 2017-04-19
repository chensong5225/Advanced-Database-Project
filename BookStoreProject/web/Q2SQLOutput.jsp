<%-- 
    Document   : Q2SQLOutput
    Created on : 2017-4-17, 20:36:48
    Author     : surface
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="arrayListBean" class="SQL.Bean.ArrayListBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SQL Output Q2</title>
    </head>
    <body>
        <table>
            <td>Increasing stores: </td>
            <%
                ArrayList<String> list = arrayListBean.getList();
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
