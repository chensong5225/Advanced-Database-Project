<%-- 
    Document   : Q7SQLOutput
    Created on : 2017-4-17, 22:40:17
    Author     : surface
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="q7bean" class="SQL.Bean.Q7Bean" scope="session"/>
<jsp:useBean id="inputBean" class="SQL.Bean.InputBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr><td>Sales change as prices change </td></tr>
            <%
                ArrayList<ArrayList<Double>> list = q7bean.getList();
                ArrayList<Double> price = list.get(0);
                ArrayList<Double> sales = list.get(1);
                for(int i = 0; i < price.size(); i++){
                    %> <tr><td>price: <%=price.get(i)%></td> <td>sales: <%=sales.get(i)%></tr>
                    <%
                }
            %>
            
        </table>
            <div id="container"></div>
        <script>
            var priceVar = <%=q7bean.getList().get(0)%>;
            var salesVar = <%=q7bean.getList().get(1)%>;
    Highcharts.chart('container', {

    title: {
        text: 'Demand Curve'
    },

    subtitle: {
        text: 'productName'
    },

    yAxis: {
        title: {
            text: 'Sales'
        }
    },
    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'middle'
    },

    plotOptions: {
        series: {
            data: priceVar
        }
    },

    series: [{
        name: 'Product i',
        data: salesVar
    }]

});
        </script>
    </body>
</html>
