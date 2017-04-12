package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import xy.bean.Message;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>login</title>\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"style/main.css\">\r\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"style/login.css\">\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-3.2.0.js\" ></script>\r\n");
      out.write("        <script language=\"javascript\" type=\"text/javascript\">//Reference from: https://my.oschina.net/moson/blog/147370   http://blog.csdn.net/u011031689/article/details/50866713\r\n");
      out.write("            function check_name() {\r\n");
      out.write("                var tag = document.getElementById('uname');\r\n");
      out.write("                var msg = document.getElementById('msg_uname');\r\n");
      out.write("                msg.innerHTML = \"\";\r\n");
      out.write("                tag.style.border = \"0\";\r\n");
      out.write("                reg = /^[\\w\\u4E00-\\u9FA5]{1,}$/;\r\n");
      out.write("                if (!reg.test(tag.value)) {\r\n");
      out.write("                    tag.style.border = \"2px solid #EEEE00\";\r\n");
      out.write("                    msg.style.color = \"#FF7700\";\r\n");
      out.write("                    msg.innerHTML = \"Username must be 1 or more character or number.\";\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("                return true;\r\n");
      out.write("            }\r\n");
      out.write("            function check_pwd() {\r\n");
      out.write("                var tag = document.getElementById('pwd');\r\n");
      out.write("                var msg = document.getElementById('msg_pwd');\r\n");
      out.write("                msg.innerHTML = \"\";\r\n");
      out.write("                tag.style.border = \"0\";\r\n");
      out.write("                if (tag.value == '') {\r\n");
      out.write("                    tag.style.border = \"2px solid #EEEE00\";\r\n");
      out.write("                    msg.style.color = \"#FF7700\";\r\n");
      out.write("                    msg.innerHTML = \"You must fill your password.\";\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("                return true;\r\n");
      out.write("            }\r\n");
      out.write("            function check() {\r\n");
      out.write("                return check_name() && check_pwd();\r\n");
      out.write("            }\r\n");
      out.write("            window.onload = function () {\r\n");
      out.write("                var tag = document.getElementById('uname');\r\n");
      out.write("                tag.onblur = check_name;\r\n");
      out.write("                var tag2 = document.getElementById('pwd');\r\n");
      out.write("                tag2.onblur = check_pwd;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class =\"headerBar\">\r\n");
      out.write("            <div class=\"logoBar login_logo\">\r\n");
      out.write("                <div class=\"comWidth\">\r\n");
      out.write("                    <div class=\"logo fl\">\r\n");
      out.write("                        <a href=\"#\"><img height=\"50px\" width=\"50px\" src=\"images/BG.png\" alt=\"Logo\"></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <h3 class=\"welcome_title\"></h3>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"loginBox\">\r\n");
      out.write("            <center>\r\n");
      out.write("                <form action=\"loginServlet\" onsubmit=\"return check();\">\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr><td>UserID:</td></tr>\r\n");
      out.write("                    <tr><td><input id=\"uname\" type=\"text\" name=\"uid\"></td></tr>\r\n");
      out.write("                    <tr><td id=\"msg_uname\"></td></tr>\r\n");
      out.write("                    <tr><td>Password:</td></tr>\r\n");
      out.write("                    <tr><td><input id=\"pwd\" type=\"text\" name=\"password\"></td></tr>\r\n");
      out.write("                    <tr><td id=\"msg_pwd\"></td></tr>\r\n");
      out.write("                    <tr><td><input type=\"submit\" value=\"login\" class=\"login_btn\"></td></tr>\r\n");
      out.write("                    ");
 if (session.getAttribute("msgInfo") == null) {
      out.write("\r\n");
      out.write("                    <tr><td><h3 class=\"hmsg\"></h3></td></tr>\r\n");
      out.write("                    ");
}else{
                    Message msg = (Message) session.getAttribute("msgInfo");
      out.write("\r\n");
      out.write("                    <tr><td><h3 class=\"hmsg\" style=\"color: #FF7700\">");
      out.print( msg.getMessageInfo());
      out.write("</h3></td></tr>\r\n");
      out.write("                    <tr><td>If you not have an account, please click </td></tr>\r\n");
      out.write("                    ");
 session.removeAttribute("msgInfo");
                     }
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("                </form>\r\n");
      out.write("                <a href=\"#\" class=\"reg_link\">Register&gt&gt</a>\r\n");
      out.write("            </center>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"footer\">\r\n");
      out.write("            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>\r\n");
      out.write("            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>\r\n");
      out.write("            <p>BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
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
