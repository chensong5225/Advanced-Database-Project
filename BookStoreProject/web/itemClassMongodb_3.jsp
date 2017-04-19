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
            
            //Q3
            HashMap<String,ArrayList<String>> mongoQ3result = new HashMap<String,ArrayList<String>>();
            ArrayList<String> top5 = new ArrayList<String>();
            ArrayList<String> bottom5 = new ArrayList<String>();
            if(hs.getAttribute("mongoQ3result")!=null){
                 mongoQ3result = (HashMap<String,ArrayList<String>>)hs.getAttribute("mongoQ3result");
                 top5 = mongoQ3result.get("top5");
                 bottom5 = mongoQ3result.get("bottom5");
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
            
            <div class="col-md-12 column">
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
                       <td>Q3-1:sales and profit of the top 5 products </td>
                       <% 
                           for(String s:top5){
                       %>
                       <td><%= s%></td>
                       <%
                            }
                       %>
                     </tr>
                     <tr>
                       <td>Q3-2:sales and profit of the bottom 5 products </td>
                       <% 
                           for(String s:bottom5){
                       %>
                       <td><%= s%></td>
                       <%
                            }
                       %>
                     </tr>
                     

                   </tbody>
                </table>
            </div>
           
       </div>
    </body>
</html>
