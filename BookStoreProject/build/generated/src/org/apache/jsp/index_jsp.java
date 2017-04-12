package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import xy.bean.customer;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>index</title>\r\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"style/reset.css\">\r\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"style/main.css\">\r\n");
      out.write("    <script>\r\n");
      out.write("        function showD(n) {\r\n");
      out.write("            document.getElementById(n).style.display=\"block\";\r\n");
      out.write("        }\r\n");
      out.write("        function hideD(n) {\r\n");
      out.write("            document.getElementById(n).style.display=\"none\";\r\n");
      out.write("        }\r\n");
      out.write("        function aOver1() {\r\n");
      out.write("            var l = document.getElementById(\"cp1\");\r\n");
      out.write("            l.setAttribute(\"src\",\"images/5.jpg\");\r\n");
      out.write("        }\r\n");
      out.write("        function aOver2() {\r\n");
      out.write("            var l = document.getElementById(\"cp2\");\r\n");
      out.write("            l.setAttribute(\"src\",\"images/7.jpg\");\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class =\"headerBar\">\r\n");
      out.write("    <div class=\"topBar\">\r\n");
      out.write("        <div class=\"comWidth\">\r\n");
      out.write("            <div class=\"leftArea\">\r\n");
      out.write("                <a href=\"#\" class=\"collection hide\">Collection</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"rightArea\">\r\n");
      out.write("                ");
 if (session.getAttribute("customer") == null) {
      out.write("\r\n");
      out.write("                Welcome to our website! <a href=\"#\">[Login]</a> <a href=\"#\">[Register]</a>\r\n");
      out.write("                ");
}else{
                        customer cst = (customer) session.getAttribute("customer");
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("                        Welcome ");
      out.print(cst.getId());
      out.write(" to our website.\r\n");
      out.write("                    ");
}
                    
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"logoBar\">\r\n");
      out.write("        <div class=\"comWidth\">\r\n");
      out.write("            <div class=\"logo fl\">\r\n");
      out.write("                <a href=\"#\"><img height=\"50px\" width=\"50px\" src=\"images/BG.png\" alt=\"Logo\">Book online store</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"search_box fl\">\r\n");
      out.write("                <input type=\"text\" class=\"search_text fl\">\r\n");
      out.write("                <input type=\"button\" value=\"Search\" class=\"search_btn fr\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"shopCar fr hide\">\r\n");
      out.write("                <span class=\"shopText fl\">Shopping Cart</span>\r\n");
      out.write("                <span class=\"shopNum fl\"> 0 </span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"navBox\">\r\n");
      out.write("        <div class=\"comWidth\">\r\n");
      out.write("            <div class=\"shopClass fl\">\r\n");
      out.write("                <h3 onmouseover=\"showD('sc')\" onmouseout=\"hideD('sc')\">All Item Classfication</h3>\r\n");
      out.write("                <div id=\"sc\" class=\"shopClass_show\">\r\n");
      out.write("                    <dl class=\"shopClass_item\">\r\n");
      out.write("                       <dt><a href=\"#\" class=\"b\">book1</a>     <a href=\"#\"  class=\"b\">book2</a> </dt>\r\n");
      out.write("                        <dd><a href=\"#\">book1</a> <a href=\"#\">book2</a></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                    <dl class=\"shopClass_item\">\r\n");
      out.write("                        <dt><a href=\"#\" class=\"b\">book1</a>     <a href=\"#\"  class=\"b\">book2</a> </dt>\r\n");
      out.write("                        <dd><a href=\"#\">book1</a> <a href=\"#\">book2</a></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                    <dl class=\"shopClass_item\">\r\n");
      out.write("                        <dt><a href=\"#\" class=\"b\">book1</a>     <a href=\"#\"  class=\"b\">book2</a> </dt>\r\n");
      out.write("                        <dd><a href=\"#\">book1</a> <a href=\"#\">book2</a></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                    <dl class=\"shopClass_item\">\r\n");
      out.write("                        <dt><a href=\"#\" class=\"b\">book1</a>     <a href=\"#\"  class=\"b\">book2</a> </dt>\r\n");
      out.write("                        <dd><a href=\"#\">book1</a> <a href=\"#\">book2</a></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                    <dl class=\"shopClass_item\">\r\n");
      out.write("                        <dt><a href=\"#\" class=\"b\">book1</a>     <a href=\"#\"  class=\"b\">book2</a> </dt>\r\n");
      out.write("                        <dd><a href=\"#\">book1</a> <a href=\"#\">book2</a></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!--<div class=\"shopClass_list\">\r\n");
      out.write("                    <div class=\"shopClass_cont\">\r\n");
      out.write("                        <dl class=\"shopList_item\">\r\n");
      out.write("                            <dt >book1</dt>\r\n");
      out.write("                            <dd>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                            </dd>\r\n");
      out.write("                        </dl>\r\n");
      out.write("                        <dl class=\"shopList_item\">\r\n");
      out.write("                            <dt >book1</dt>\r\n");
      out.write("                            <dd>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                            </dd>\r\n");
      out.write("                        </dl>\r\n");
      out.write("                        <dl class=\"shopList_item\">\r\n");
      out.write("                            <dt >book1</dt>\r\n");
      out.write("                            <dd>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                                <a href=\"#\">book1-1</a>\r\n");
      out.write("                            </dd>\r\n");
      out.write("                        </dl>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>-->\r\n");
      out.write("            </div>\r\n");
      out.write("            <ul class=\"nav fl\">\r\n");
      out.write("                <li><a href=\"#\" class=\"active\">Book</a></li>\r\n");
      out.write("                <li><a href=\"#\">Book</a></li>\r\n");
      out.write("                <li><a href=\"#\">Book</a></li>\r\n");
      out.write("                <li><a href=\"#\">Book</a></li>\r\n");
      out.write("                <li><a href=\"#\">Book</a></li>\r\n");
      out.write("                <li><a href=\"#\">Book</a></li>\r\n");
      out.write("                <li><a href=\"#\">Book</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"banner comWidth clearfix\">\r\n");
      out.write("    <div class=\"banner_bar\">\r\n");
      out.write("        <ul class=\"imgBox\">\r\n");
      out.write("            <li><a href=\"#\"><img id=\"cp1\" src=\"images/7.jpg\" alt=\"banner1\"/></a> </li>\r\n");
      out.write("            <li><a href=\"#\"><img id=\"cp2\" src=\"images/5.jpg\" alt=\"banner2\"/></a> </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <div class=\"imgNum\">\r\n");
      out.write("           <!-- <a href=\"#\" class=\"active\"></a>-->\r\n");
      out.write("            <a onmouseover=\"aOver1()\" href=\"#\"></a>\r\n");
      out.write("            <a onmouseover=\"aOver2()\" href=\"#\"></a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"shopTit comWidth\">\r\n");
      out.write("    <h3>BOOK </h3>\r\n");
      out.write("    <a href=\"#\" class=\"more\">More&gt&gt</a>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"shopList comWidth clearfix\">\r\n");
      out.write("    <div class=\"leftArea\">\r\n");
      out.write("        1\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"rightArea\">\r\n");
      out.write("        <div class=\"shopList_top clearfix\">\r\n");
      out.write("            <div class=\"shop_item\">\r\n");
      out.write("                <div class=\"shop_img\">\r\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\r\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"shop_item\">\r\n");
      out.write("                <div class=\"shop_img\">\r\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\r\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"shop_item\">\r\n");
      out.write("                <div class=\"shop_img\">\r\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\r\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"shop_item\">\r\n");
      out.write("                <div class=\"shop_img\">\r\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\r\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"shopTit comWidth\">\r\n");
      out.write("    <h3>BOOK </h3>\r\n");
      out.write("    <a href=\"#\" class=\"more\">More&gt&gt</a>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"shopList comWidth clearfix\">\r\n");
      out.write("    <div class=\"leftArea\">\r\n");
      out.write("        1\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"rightArea\">\r\n");
      out.write("        <div class=\"shopList_top clearfix\">\r\n");
      out.write("            <div class=\"shop_item\">\r\n");
      out.write("                <div class=\"shop_img\">\r\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\r\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"shop_item\">\r\n");
      out.write("                <div class=\"shop_img\">\r\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\r\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"shop_item\">\r\n");
      out.write("                <div class=\"shop_img\">\r\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\r\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"shop_item\">\r\n");
      out.write("                <div class=\"shop_img\">\r\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\r\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>\r\n");
      out.write("    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>\r\n");
      out.write("    <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
