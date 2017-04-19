<%-- 
    Document   : itemClass
    Created on : Apr 1, 2017, 10:51:48 PM
    Author     : mac
--%>

<%@page import="java.lang.Double"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="xy.bean.customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>itemClass</title>
        <link type="text/css" rel="stylesheet" href="style/reset.css">
        <link type="text/css" rel="stylesheet" href="style/main.css">
        <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        
        
        
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>
        
        <script>

        <script>
            var priceVar = ;
            var salesVar =;
         
            Highcharts.chart('container', {    title: {
                text: 'Demand Curve'
            },    subtitle: {
                text: 'productName'
            },    yAxis: {
                title: {
                    text: 'Sales'
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle'
            },    plotOptions: {
                series: {
                    data: priceVar
                }
            },    series: [{
                name: 'Product i',
                data: salesVar
            }]});
        </script>
      
        
    </head>
    <body>
        
         <div class="row">    
             <div class="col-md-12 column">
                <form action="cleanServlet">              
                    <input value="back"  type="submit">
                </form>
            </div>
        </div>
      
        <table class="table table-striped">
            <tr><td>Region compare: </td></tr>
            <%
                HttpSession hs = request.getSession(true);
            
                //Q2
                ArrayList<String> mongoQ2result =  new ArrayList();
                if(hs.getAttribute("mongoQ2result")!=null){
                     mongoQ2result = (ArrayList)hs.getAttribute("mongoQ2result");
                }
                for(String s: mongoQ2result){
                    %>
                    <tr><td>
                            Store: <%=s%> </td><td>  
                    </td></tr>
                    <%
                }
            %>
            
        </table>
            
   
    </body>
</html>
