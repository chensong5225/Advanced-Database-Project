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
        
        <%
            
            HttpSession hs = request.getSession(true);
           
            //Q6
            String mongoQ6result = " ";  
            if(hs.getAttribute("mongoQ6result")!=null){
                 mongoQ6result = (String)hs.getAttribute("mongoQ6result");
            } 
            
            
        %>
       
        <div class="row">    
             <div class="col-md-12 column">
                <form action="cleanServlet">              
                    <input value="back"  type="submit">
                </form>
            </div>
        </div>
            
        <div class="row">
            <div class="col-md-2 column"></div>
            <div class="col-md-8 column">
                <table class="table  table-striped">
                   <caption>query result</caption>
                        <thead>
                          <tr>
                            <th>question</th>
                            <th>anwser</th>
                          </tr>
                        </thead>
                   <tbody>
                     
                     <tr>
                       <td>Q6: Which businesses are buying given products the most?</td>
                       <td><%= mongoQ6result%></td>
                     </tr>
                     

                   </tbody>
                </table>
            </div>
            <div class="col-md-2 column"></div>
       </div>
    </body>
</html>
