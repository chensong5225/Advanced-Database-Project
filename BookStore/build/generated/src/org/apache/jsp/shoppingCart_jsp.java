package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class shoppingCart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Shopping Cart</title>\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"style/reset.css\">\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"style/main.css\">\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"style/cart.css\">\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-3.2.0.js\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("            function Mongodbrequest() {\n");
      out.write("                            alert(\"click button\");\n");
      out.write("                            /*先删除以前查找的内容*/\n");
      out.write("                            $(\"#show_Sch_Rlt\").empty();\n");
      out.write("                            var inputSearch = $('#User_Sch_input').val();\n");
      out.write("                            alert(\"input search -->\"+inputSearch);\n");
      out.write("                            var xmlhttp;\n");
      out.write("                            var txt, x, i;\n");
      out.write("                            if(window.XMLHttpRequest) {\n");
      out.write("                                    xmlhttp = new XMLHttpRequest();\n");
      out.write("                            } else {\n");
      out.write("                                    xmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                            }\n");
      out.write("                            xmlhttp.onreadystatechange = function() {\n");
      out.write("                                    if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {\n");
      out.write("                                            xmlDoc = xmlhttp.responseText;\n");
      out.write("                                            txt = \"\";\n");
      out.write("                                            /*接受数据并且显示*/\n");
      out.write("                                            NameSearchShow(xmlDoc);\n");
      out.write("                                    }\n");
      out.write("                            }\n");
      out.write("                            xmlhttp.open(\"GET\", \"http://localhost:8080/SteamGame/NameSearch\", true);\n");
      out.write("                            xmlhttp.setRequestHeader(\"MyHeader\", inputSearch);\n");
      out.write("                            xmlhttp.send();\n");
      out.write("            }\n");
      out.write("    </script>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        #goods{\n");
      out.write("            border: 1px solid black;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class =\"headerBar\">\n");
      out.write("    <div class=\"topBar\">\n");
      out.write("        <div class=\"comWidth\">\n");
      out.write("            <div class=\"leftArea\">\n");
      out.write("                <a href=\"#\" class=\"collection\">Collection</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"rightArea\">\n");
      out.write("                Welcome to our website! <a href=\"#\">[Login]</a> <a href=\"#\">[Register]</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"logoBar\">\n");
      out.write("        <div class=\"comWidth\">\n");
      out.write("            <div class=\"logo fl\">\n");
      out.write("                <a href=\"#\"><img height=\"50px\" width=\"50px\" src=\"images/BG.png\" alt=\"Logo\">Book online store</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<center>\n");
      out.write("    <div class=\"show\" name=\"cart\">\n");
      out.write("        <h2>Shopping Cart</h2>\n");
      out.write("        <form action=\"\"method=\"post\">\n");
      out.write("            <table id=\"goods\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><img src=\"#\" width=\"200\" height=\"100\"/></td>\n");
      out.write("                    <td>Book Name:</td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td>Amount:</td>\n");
      out.write("                    <td><input class=\"p1\" type=\"text\" name=\"number\" value=\"1\" width=\"30\" height=\"10\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr><td></td><td>Book Information:</td><td></td></tr>\n");
      out.write("                <tr></tr>\n");
      out.write("                <tr><td></td><td></td><td></td><td><a href=\"/DeleteBook?Bid=#\">Delete</a></td><td></td><td></td></tr>\n");
      out.write("                <tr><td></td><td></td><td></td><td>Price:$</td><td></td></tr>\n");
      out.write("                <tr></tr>\n");
      out.write("                <tr></tr>\n");
      out.write("            </table>\n");
      out.write("            <table>\n");
      out.write("                <tr><td>total:</td><td>$</td><td></td></tr>\n");
      out.write("                <tr><td></td><td></td><td></td></tr>\n");
      out.write("                <tr><td></td><td></td><td></td></tr>\n");
      out.write("                <div class=\"br25\"></div>\n");
      out.write("                <tr><td><input type=\"button\" class=\"cart_btn\" value=\"Check Out\"/></td></tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</center>\n");
      out.write("<div class=\"footer\">\n");
      out.write("    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>\n");
      out.write("    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>\n");
      out.write("    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
