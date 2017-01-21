package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class p_005fsignup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\n");
      out.write("    <title>From </title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("            body{\n");
      out.write("                background-image: url(Drug.jpg);\n");
      out.write("                background-size: cover;\n");
      out.write("            } \n");
      out.write("            .log input[type=\"submit\"]{\n");
      out.write("                width: 120px;\n");
      out.write("                height: 30px;\n");
      out.write("                border: 0;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                -webkit-border-radius: 5px;\n");
      out.write("                background-color: skyblue;\n");
      out.write("                font-weight: bolder;\n");
      out.write("                color: navy;\n");
      out.write("            }\n");
      out.write("            .log input[type=\"reset\"]{\n");
      out.write("                width: 100px;\n");
      out.write("                height: 30px;\n");
      out.write("                border: 0;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                -webkit-border-radius: 5px;\n");
      out.write("                background-color: skyblue;\n");
      out.write("                font-weight: bolder;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("</style>            \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"log\">\n");
      out.write("<form method=\"post\" action=\"p_signup\"> \n");
      out.write("\n");
      out.write("<table style=\"width:100%; height:100%\" cellpadding=\"0\" cellspacing=\"0\" >\n");
      out.write("<tr>\n");
      out.write("<td style=\"width: 30%; height: 50px;\" ></td>\n");
      out.write("<td style=\"width: 40%; height: 50px;\" bgcolor=\"#808080\">\n");
      out.write("    \n");
      out.write("    <table style= \"width:100%; height:100%; border:0\">\n");
      out.write("<tr>\n");
      out.write("    <td><center><h2><font color=\"yellow\">Pharmacist Registration Form</font></h2></center></td>\n");
      out.write(" </tr>\n");
      out.write("<tr>\n");
      out.write("    <td style=\"width: 100%; height: 5%;\"><center><h3><b>Account Information</b></h3></center></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td style=\"width: 100%; height: 95%;\">\n");
      out.write("<table style=\"width:100%; height:100%\">\n");
      out.write("    <font color=\"#4d0000\"> Note:The fields marked with * are mandatory.</font>\n");
      out.write("<tr>\n");
      out.write("    <td>Login ID:<font color=\"red\">*</font></td>\n");
      out.write("<td><input type=\"email\" name=\"p1\" placeholder=\"Enter your valid Email id\" required ></td>\n");
      out.write("\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td>Password:<font color=\"red\">*</font></td>\n");
      out.write("<td><input type=\"password\" name=\"p2\" placeholder=\"Please enter your password\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td>Pharmacist Name:</td>\n");
      out.write("<td><input type=\"text\" name=\"p3\" placeholder=\"\" required ></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td>Email ID:<font color=\"red\">*</font></td>\n");
      out.write("<td><input type=\"text\" name=\"p4\" placeholder=\"\" required ></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td>Mobile No:<font color=\"red\">*</font></td>\n");
      out.write("<td><input type=\"text\" name=\"p5\" placeholder=\"Enter your mobile no.\" required ></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td>Date of Birth:<font color=\"red\">*</font></td>\n");
      out.write("<td><input type=\"date\" name=\"p6\" ></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("<td>Marital Status :</td>\n");
      out.write("<td>\n");
      out.write("<select name=\"p7\">\n");
      out.write("<option value=\"Null\">Please Specify</option>\n");
      out.write("<option value=\"Divorced\">Divorced</option>\n");
      out.write("<option value=\"Married\">Married</option>\n");
      out.write("<option value=\"Single\">Single</option>\n");
      out.write("</select>\n");
      out.write("</td></tr>\n");
      out.write("<tr>\n");
      out.write("<td>Address:<font color=\"red\">*</font></td>\n");
      out.write("<td><textarea rows=\"4\" cols=\"25\" name=\"p8\"></textarea></td>\n");
      out.write("</tr>\n");
      out.write("<td>Security Question:<font color=\"red\">*</font></td>\n");
      out.write("<td>\n");
      out.write("<select name=\"p9\">\n");
      out.write("<option value=\"Null\">Please Specify</option>\n");
      out.write("<option value=\"petname\">What is your pet name?</option>\n");
      out.write("<option value=\"book\">What is your favorite book? </option>\n");
      out.write("<option value=\"teacher\">Who is your first Teacher?</option>\n");
      out.write("</select>\n");
      out.write("</td\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td>Answer:<font color=\"red\">*</font></td>\n");
      out.write("<td><input type=\"text\" name=\"p10\"></td>\n");
      out.write("</tr>\n");
      out.write("<td><input type=\"submit\" value=\"Create Account\"></td>\n");
      out.write("<td><input type=\"reset\" value=\"Refresh\"></td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</td>\n");
      out.write("<td style=\"width: 30%; height: 50px;\" ></td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</form>\n");
      out.write("    </div>        \n");
      out.write("</body>\n");
      out.write("</html>");
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
