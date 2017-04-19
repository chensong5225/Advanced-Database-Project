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
<jsp:useBean id="beanq7" class="MongoBean.BeanQ7" scope="session"></jsp:useBean>
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
        
        
    <div id="container"></div>

        <script>
            var priceVar = <%=beanq7.getPrice()%>;
            var salesVar = <%=beanq7.getAmount()%>;
//            var priceVar = [1,2];
//            var salesVar = [10,9];
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
                    <input value="submit"  type="submit">
                </form>
            </div>
        </div>
         <%
            
            HttpSession hs = request.getSession(true);
            ArrayList<Double> price = new ArrayList();
            ArrayList<Double> amount = new ArrayList();
            //Q7
            HashMap<Double,Double> mongoQ7result = new HashMap();
            if(hs.getAttribute("mongoQ7result")!=null){
                 mongoQ7result = (HashMap<Double,Double>)hs.getAttribute("mongoQ7result");
                 Iterator it = mongoQ7result.entrySet().iterator();
                    while(it.hasNext()){
                        Map.Entry entry = (Map.Entry) it.next();
                        Double region = (Double)entry.getKey();
                        price.add(region);
                        Double sale = (Double)entry.getValue();
                        amount.add(sale);                        
                    }
            }
            
        %>
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
                       <td>Q7: What is the demand curve for each product? </td>
                       <td><%= mongoQ7result%></td>
                     </tr>
                     

                   </tbody>
                </table>
            </div>
            <div class="col-md-2 column"></div>
       </div>
    </body>
</html>
