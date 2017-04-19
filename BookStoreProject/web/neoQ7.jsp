<%-- 
    Document   : neoQ7
    Created on : Apr 18, 2017, 10:59:56 PM
    Author     : mac
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="q7" class="Neo4j.beans.Q7_result" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>


        <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> 
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>
    <body>
        <table class="table table-striped">
            <tr><td>Sales change as prices change </td></tr>
            <%
                ArrayList<Float> pricelist = q7.getPricelist();
                ArrayList<Float> salelist = q7.getSalelist();
                for (int i = 0; i < pricelist.size(); i++) {
            %> <tr><td>price: <%=pricelist.get(i)%></td> <td>sales: <%=salelist.get(i)%></tr>
            <%
                }
            %>

        </table>
        <div id="container"></div>
        <script>
            var priceVar = <%=q7.getPricelist()%>;
            var salesVar = <%=q7.getSalelist()%>;
            Highcharts.chart('container', {title: {
                    text: 'Demand Curve'
                }, subtitle: {
                    text: 'productName'
                }, yAxis: {
                    title: {
                        text: 'Sales'
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle'
                }, plotOptions: {
                    series: {
                        data: priceVar
                    }
                }, series: [{
                        name: 'Product i',
                        data: salesVar
                    }]});
        </script>
    </body>
</html>
