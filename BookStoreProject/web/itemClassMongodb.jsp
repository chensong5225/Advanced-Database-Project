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
            //Q1
            String mongoQ1result = " ";
            if(hs.getAttribute("mongoQ1result")!=null){
                 mongoQ1result = (String)hs.getAttribute("mongoQ1result");
            }
            //Q2
            ArrayList<String> mongoQ2result =  new ArrayList();
             if(hs.getAttribute("mongoQ2result")!=null){
                 mongoQ2result = (ArrayList)hs.getAttribute("mongoQ2result");
            }
            //Q3
            ArrayList<String> mongoQ3result = new ArrayList();
            if(hs.getAttribute("mongoQ3result")!=null){
                 mongoQ3result = (ArrayList)hs.getAttribute("mongoQ3result");
            }  
            //Q4
            HashMap<String,ArrayList<String> > mongoQ4result = new  HashMap<String,ArrayList<String> >();
            ArrayList<String> top2customer = new ArrayList();
            ArrayList<String> top2product = new ArrayList();
            if(hs.getAttribute("mongoQ4result")!=null){
                 mongoQ4result = (HashMap<String,ArrayList<String>>)hs.getAttribute("mongoQ4result");
                 top2customer = mongoQ4result.get("top2customer");
                 top2product = mongoQ4result.get("top2product");
            } 
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
            //Q6
            String mongoQ6result = " ";  
            if(hs.getAttribute("mongoQ6result")!=null){
                 mongoQ6result = (String)hs.getAttribute("mongoQ6result");
            } 
            
            //Q7
            HashMap<Double,Double> mongoQ7result = new HashMap();
            if(hs.getAttribute("mongoQ7result")!=null){
                 mongoQ7result = (HashMap<Double,Double>)hs.getAttribute("mongoQ7result");
            }
            //Q8
            HashMap<String,Integer> mongoQ8result = new HashMap();
            ArrayList<String> mongoQ8resultArray = new ArrayList();
            ArrayList<Integer> mongoQ8resultArray2 = new ArrayList();
            if(hs.getAttribute("mongoQ8result")!=null){
                 mongoQ8result =(HashMap<String,Integer>) hs.getAttribute("mongoQ8result");
                 mongoQ8resultArray = new ArrayList();
                 Iterator it = mongoQ8result.entrySet().iterator();
                 
                 while(it.hasNext()){
                    Map.Entry entry = (Map.Entry) it.next();
                    String region = (String)entry.getKey();
                    Integer i = (Integer)entry.getValue();
                    mongoQ8resultArray.add(region);
                    mongoQ8resultArray2.add(i);
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
                       <td>Q1:ratio of business to home customers</td>
                       <td><%= mongoQ1result%></td>
                     </tr>
                     <tr>
                       <td>Q2:What stores are increasing in sales</td>
                       <td><%= mongoQ2result%></td>
                     </tr>
                     <tr>
                       <td>Q3-1:sales and profit of the top 5 products </td>
                       <td><%= mongoQ3result%></td>
                     </tr> 
                     <tr>
                       <td>Q3-2:sales and profit of the bottom 5 product</td>
                       <td><%= mongoQ3result%></td>
                     </tr> 
                     <tr>
                       <td>Q4-1: top 2 customer categories (highest sales)</td>
                       <td><%= top2customer%></td>
                     </tr>
                      <tr>
                       <td>Q4-2: top 2  product categories</td>
                       <td><%= top2product%></td>
                     </tr>
                     <tr>
                       <td>Q5: various regions compare by sales volume</td>
                       <td><%= mongoQ5result%></td>
                     </tr>
                     <tr>
                       <td>Q6: Which businesses are buying given products the most?</td>
                       <td><%= mongoQ6result%></td>
                     </tr>
                     <tr>
                       <td>Q7: What is the demand curve for each product? </td>
                       <td><%= mongoQ7result%></td>
                     </tr>
                     <tr>
                       <td>Q8: for each product,customers that buy the product more than 2 times per week.</td>
                       <td><%= mongoQ8resultArray%></td>
                     </tr>

                   </tbody>
                </table>
            </div>
            <div class="col-md-2 column"></div>
       </div>
    </body>
</html>
