<%-- 
    Document   : Q5SQLOutput
    Created on : 2017-4-17, 22:01:16
    Author     : surface
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="q5bean" class="SQL.Bean.Q5Bean" scope="session"/>
<jsp:useBean id="salesBean" class="SQL.Bean.ArrayListBean" scope="session"/>
<jsp:useBean id="regionBean" class="SQL.Bean.ArrayListBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>
        <link type="text/css" rel="stylesheet" href="style/main.css">
        <link type="text/css" rel="stylesheet" href="style/login.css">
        <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> 
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>
    <body>
        <table class="table table-striped">
            <tr><td>Region compare: </td></tr>
            <%
                HashMap<String, Double> map = q5bean.getMap();
                for(String s: map.keySet()){
                    %>
                    <tr><td>
                            Region:<%=s%> </td><td>   Sales:<%=map.get(s)%>
                    </td></tr>
                    <%
                }
            %>
            
        </table>
            <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
            <script>
                var regionVar = <%=regionBean.getList()%>;
                var salesVar = <%=salesBean.getDoublelist()%>;
                Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Region compare'
    },
    
    xAxis: {
        categories: regionVar,
        crosshair: true
    },
    yAxis: {
        min:0,
        title: {
            text: 'Sales volume'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    },
    series: [{
        name: 'sales',
        data: salesVar
    },{
        name: 'sales',
        data: salesVar
    }
    ]
});
            </script>

    </body>
</html>
