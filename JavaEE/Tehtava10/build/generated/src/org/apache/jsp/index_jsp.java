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
      out.write("        <title>Anna tietosi</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Syötä tiedot</h1>\n");
      out.write("        <form name=\"tiedot\" action=\"response.jsp\">\n");
      out.write("            \n");
      out.write("            ");
      org.mypackage.Tehtava10.TietoKasittelija hakeeBean = null;
      synchronized (session) {
        hakeeBean = (org.mypackage.Tehtava10.TietoKasittelija) _jspx_page_context.getAttribute("hakeeBean", PageContext.SESSION_SCOPE);
        if (hakeeBean == null){
          hakeeBean = new org.mypackage.Tehtava10.TietoKasittelija();
          _jspx_page_context.setAttribute("hakeeBean", hakeeBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write(" \n");
      out.write("            Nimi: <input type=\"text\" name=\"nimi\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((org.mypackage.Tehtava10.TietoKasittelija)_jspx_page_context.findAttribute("hakeeBean")).getNimi())));
      out.write("\"/><br>\n");
      out.write("            Osoite: <input type=\"text\" name=\"osoite\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((org.mypackage.Tehtava10.TietoKasittelija)_jspx_page_context.findAttribute("hakeeBean")).getOsoite())));
      out.write("\"/><br> \n");
      out.write("            Kotikunta: <input type=\"text\" name=\"kotikunta\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((org.mypackage.Tehtava10.TietoKasittelija)_jspx_page_context.findAttribute("hakeeBean")).getKotikunta())));
      out.write("\"/><br>\n");
      out.write("            Email: <input type=\"text\" name=\"email\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((org.mypackage.Tehtava10.TietoKasittelija)_jspx_page_context.findAttribute("hakeeBean")).getEmail())));
      out.write("\" /><br>\n");
      out.write("           <input type=\"submit\" value=\"Lähetä\" name=\"submit\" />\n");
      out.write("        </form>\n");
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
