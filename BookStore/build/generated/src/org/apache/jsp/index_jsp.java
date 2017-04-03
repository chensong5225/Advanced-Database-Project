package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>index</title>\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"style/reset.css\">\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"style/main.css\">\n");
      out.write("    <script>\n");
      out.write("        function showD(n) {\n");
      out.write("            document.getElementById(n).style.display=\"block\";\n");
      out.write("        }\n");
      out.write("        function hideD(n) {\n");
      out.write("            document.getElementById(n).style.display=\"none\";\n");
      out.write("        }\n");
      out.write("        function aOver1() {\n");
      out.write("            var l = document.getElementById(\"cp1\");\n");
      out.write("            l.setAttribute(\"src\",\"images/5.jpg\");\n");
      out.write("        }\n");
      out.write("        function aOver2() {\n");
      out.write("            var l = document.getElementById(\"cp2\");\n");
      out.write("            l.setAttribute(\"src\",\"images/7.jpg\");\n");
      out.write("        }\n");
      out.write("    </script>\n");
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
      out.write("            <div class=\"search_box fl\">\n");
      out.write("                <input type=\"text\" class=\"search_text fl\">\n");
      out.write("                <input type=\"button\" value=\"Search\" class=\"search_btn fr\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"shopCar fr\">\n");
      out.write("                <span class=\"shopText fl\">Shopping Cart</span>\n");
      out.write("                <span class=\"shopNum fl\"> 0 </span>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"navBox\">\n");
      out.write("        <div class=\"comWidth\">\n");
      out.write("            <div class=\"shopClass fl\">\n");
      out.write("                <h3 onmouseover=\"showD('sc')\" onmouseout=\"hideD('sc')\">All Item Classfication</h3>\n");
      out.write("                <div id=\"sc\" class=\"shopClass_show\">\n");
      out.write("                    <dl class=\"shopClass_item\">\n");
      out.write("                       <dt><a href=\"#\" class=\"b\">book1</a>     <a href=\"#\"  class=\"b\">book2</a> </dt>\n");
      out.write("                        <dd><a href=\"#\">book1</a> <a href=\"#\">book2</a></dd>\n");
      out.write("                    </dl>\n");
      out.write("                    <dl class=\"shopClass_item\">\n");
      out.write("                        <dt><a href=\"#\" class=\"b\">book1</a>     <a href=\"#\"  class=\"b\">book2</a> </dt>\n");
      out.write("                        <dd><a href=\"#\">book1</a> <a href=\"#\">book2</a></dd>\n");
      out.write("                    </dl>\n");
      out.write("                    <dl class=\"shopClass_item\">\n");
      out.write("                        <dt><a href=\"#\" class=\"b\">book1</a>     <a href=\"#\"  class=\"b\">book2</a> </dt>\n");
      out.write("                        <dd><a href=\"#\">book1</a> <a href=\"#\">book2</a></dd>\n");
      out.write("                    </dl>\n");
      out.write("                    <dl class=\"shopClass_item\">\n");
      out.write("                        <dt><a href=\"#\" class=\"b\">book1</a>     <a href=\"#\"  class=\"b\">book2</a> </dt>\n");
      out.write("                        <dd><a href=\"#\">book1</a> <a href=\"#\">book2</a></dd>\n");
      out.write("                    </dl>\n");
      out.write("                    <dl class=\"shopClass_item\">\n");
      out.write("                        <dt><a href=\"#\" class=\"b\">book1</a>     <a href=\"#\"  class=\"b\">book2</a> </dt>\n");
      out.write("                        <dd><a href=\"#\">book1</a> <a href=\"#\">book2</a></dd>\n");
      out.write("                    </dl>\n");
      out.write("                </div>\n");
      out.write("                <!--<div class=\"shopClass_list\">\n");
      out.write("                    <div class=\"shopClass_cont\">\n");
      out.write("                        <dl class=\"shopList_item\">\n");
      out.write("                            <dt >book1</dt>\n");
      out.write("                            <dd>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                            </dd>\n");
      out.write("                        </dl>\n");
      out.write("                        <dl class=\"shopList_item\">\n");
      out.write("                            <dt >book1</dt>\n");
      out.write("                            <dd>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                            </dd>\n");
      out.write("                        </dl>\n");
      out.write("                        <dl class=\"shopList_item\">\n");
      out.write("                            <dt >book1</dt>\n");
      out.write("                            <dd>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                                <a href=\"#\">book1-1</a>\n");
      out.write("                            </dd>\n");
      out.write("                        </dl>\n");
      out.write("                    </div>\n");
      out.write("                </div>-->\n");
      out.write("            </div>\n");
      out.write("            <ul class=\"nav fl\">\n");
      out.write("                <li><a href=\"#\" class=\"active\">Book</a></li>\n");
      out.write("                <li><a href=\"#\">Book</a></li>\n");
      out.write("                <li><a href=\"#\">Book</a></li>\n");
      out.write("                <li><a href=\"#\">Book</a></li>\n");
      out.write("                <li><a href=\"#\">Book</a></li>\n");
      out.write("                <li><a href=\"#\">Book</a></li>\n");
      out.write("                <li><a href=\"#\">Book</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"banner comWidth clearfix\">\n");
      out.write("    <div class=\"banner_bar\">\n");
      out.write("        <ul class=\"imgBox\">\n");
      out.write("            <li><a href=\"#\"><img id=\"cp1\" src=\"images/7.jpg\" alt=\"banner1\"/></a> </li>\n");
      out.write("            <li><a href=\"#\"><img id=\"cp2\" src=\"images/5.jpg\" alt=\"banner2\"/></a> </li>\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"imgNum\">\n");
      out.write("           <!-- <a href=\"#\" class=\"active\"></a>-->\n");
      out.write("            <a onmouseover=\"aOver1()\" href=\"#\"></a>\n");
      out.write("            <a onmouseover=\"aOver2()\" href=\"#\"></a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"shopTit comWidth\">\n");
      out.write("    <h3>BOOK </h3>\n");
      out.write("    <a href=\"#\" class=\"more\">More&gt&gt</a>\n");
      out.write("</div>\n");
      out.write("<div class=\"shopList comWidth clearfix\">\n");
      out.write("    <div class=\"leftArea\">\n");
      out.write("        1\n");
      out.write("    </div>\n");
      out.write("    <div class=\"rightArea\">\n");
      out.write("        <div class=\"shopList_top clearfix\">\n");
      out.write("            <div class=\"shop_item\">\n");
      out.write("                <div class=\"shop_img\">\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"shop_item\">\n");
      out.write("                <div class=\"shop_img\">\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"shop_item\">\n");
      out.write("                <div class=\"shop_img\">\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"shop_item\">\n");
      out.write("                <div class=\"shop_img\">\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"shopTit comWidth\">\n");
      out.write("    <h3>BOOK </h3>\n");
      out.write("    <a href=\"#\" class=\"more\">More&gt&gt</a>\n");
      out.write("</div>\n");
      out.write("<div class=\"shopList comWidth clearfix\">\n");
      out.write("    <div class=\"leftArea\">\n");
      out.write("        1\n");
      out.write("    </div>\n");
      out.write("    <div class=\"rightArea\">\n");
      out.write("        <div class=\"shopList_top clearfix\">\n");
      out.write("            <div class=\"shop_item\">\n");
      out.write("                <div class=\"shop_img\">\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"shop_item\">\n");
      out.write("                <div class=\"shop_img\">\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"shop_item\">\n");
      out.write("                <div class=\"shop_img\">\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"shop_item\">\n");
      out.write("                <div class=\"shop_img\">\n");
      out.write("                    <a href=\"#\" alt=\"image1\"></a>\n");
      out.write("                    <a href=\"#\" alt=\"description\">Name & price</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
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
