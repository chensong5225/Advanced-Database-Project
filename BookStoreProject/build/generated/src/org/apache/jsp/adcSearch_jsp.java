package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adcSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>adcSearch</title>\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"style/main.css\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"style/login.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class =\"headerBar\">\n");
      out.write("            <div class=\"logoBar login_logo\">\n");
      out.write("                <div class=\"comWidth\">\n");
      out.write("                    <div class=\"logo fl\">\n");
      out.write("                        <a href=\"#\"><img height=\"50px\" width=\"50px\" src=\"images/BG.png\" alt=\"Logo\">Book online store</a>\n");
      out.write("                    </div>\n");
      out.write("                    <h3 class=\"welcome_title\"></h3>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"adSearch\">\n");
      out.write("            <form>\n");
      out.write("                <table>\n");
      out.write("                    <tr><td>What is the ratio of business to home customers?</td><td><input type=\"button\" value=\"Search\"/></td></tr>\n");
      out.write("                    <tr><td>What stores are increasing in sales?</td><td><input type=\"button\" value=\"Search\"/></td></tr>\n");
      out.write("                    <tr><td>Maintain every day the aggregate sales and profit of the top 5 and the bottom 5 products.</td><td><input type=\"button\" value=\"Search\"/></td></tr>\n");
      out.write("                    <tr><td>Maintain every day the top 2 customer categories (highest sales) and the top product categories.</td><td><input type=\"button\" value=\"Search\"/></td></tr>\n");
      out.write("                    <tr><td>How do the various regions compare by sales volume?</td><td><input type=\"button\" value=\"Search\"/></td></tr>\n");
      out.write("                    <tr><td>Which businesses are buying given products the most?</td><td><input type=\"button\" value=\"Search\"/></td></tr>\n");
      out.write("                    <tr><td>What is the demand curve for each product category?</td><td><input type=\"button\" value=\"Search\"/></td></tr>\n");
      out.write("                    <tr><td>Develop a direct marketing data; for each product, a list of customers that buy the product more than 2 times per week.</td><td><input type=\"button\" value=\"Search\"/></td></tr>\n");
      out.write("                    <tr><td>Other interesting aggregate values that you will come up with.</td><td><input type=\"button\" value=\"Search\"/></td></tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer\">\n");
      out.write("            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>\n");
      out.write("            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>\n");
      out.write("            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
