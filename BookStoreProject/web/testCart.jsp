<%-- 
    Document   : testCart
    Created on : Apr 13, 2017, 2:01:47 AM
    Author     : mac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script> 
        <script type="text/javascript"> //Reference from: http://www.jb51.net/article/50732.htm
            $(function () {
                $(".add").click(function () {
                    var t = $(this).parent().find('input[class*=text_box]');
                    t.val(parseInt(t.val()) + 1)
                    setTotal();
                })
                $(".min").click(function () {
                    var t = $(this).parent().find('input[class*=text_box]');
                    t.val(parseInt(t.val()) - 1)
                    if (parseInt(t.val()) < 0) {
                        t.val(0);
                    }
                    setTotal();
                })
                function setTotal() {
                    var s = 0;
                    $("#tab td").each(function () {
                        s += parseInt($(this).find('input[class*=text_box]').val()) * parseFloat($(this).find('span[class*=price]').text());
                    });
                    $("#total").html(s.toFixed(2));
                }
                setTotal();

            })
        </script> 
    </head>
    <body>
        <table id="tab"> 
            <tr> 
                <td> 
                    <span>单价:</span><span class="price">1.50</span> 
                    <input class="min" name="" type="button" value="-" /> 
                    <input class="text_box" name="" type="text" value="1" /> 
                    <input class="add" name="" type="button" value="+" /> 
                </td> 
            </tr> 
            <tr> 
                <td> 
                    <span>单价:</span><span class="price">3.95</span> 
                    <input class="min" name="" type="button" value="-" /> 
                    <input class="text_box" name="" type="text" value="1" /> 
                    <input class="add" name="" type="button" value="+" /> 
                </td> 
            </tr> 
        </table> 

        <p>总价：<label id="total"></label></p> 
    </body>
</html>
