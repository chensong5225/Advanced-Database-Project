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
            
            //Q5
            HashMap<String,Double> mongoQ5result = new HashMap();
            ArrayList<String> mongoQ5resultArray = new ArrayList();
            ArrayList<Double> mongoQ5resultArray2 = new ArrayList();
            if(hs.getAttribute("mongoQ5result")!=null){                
                 mongoQ5result = (HashMap<String,Double>)hs.getAttribute("mongoQ5result");
                 Iterator it = mongoQ5result.entrySet().iterator();               
                 while(it.hasNext()){
                    Map.Entry entry = (Map.Entry) it.next();
                    String region = (String)entry.getKey();
                    Double volumes = (Double)entry.getValue();
                    mongoQ5resultArray.add(region);
                    mongoQ5resultArray2.add(volumes);
                }
            } 
            
        %>
       
        <div class="row">    
             <div class="col-md-12 column">
                <form action="cleanServlet">              
                    <input value="submit"  type="submit">
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
                       <td>Q5: various regions compare by sales volume</td>
                       
                     </tr>
                     
                     
                     <%
                        HashMap<String, Double> map = mongoQ5result;
                        for(String s: map.keySet()){
                            %>
                            <tr><td>
                                    Store: <%=s%> </td><td>   Sales:<%=map.get(s)%>
                            </td></tr>
                            <%
                        }
                    %>

                     

                   </tbody>
                </table>
            </div>
            <div class="col-md-2 column"></div>
       </div>
    </body>
</html>
