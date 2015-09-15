package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class palkanlaskija_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<html>\n");
      out.write("    <head><title></title></head>\n");
      out.write("    <body>\n");
      out.write("        <p>\n");
      out.write("\n");
      out.write("            ");

                //kerätään kaikki lomakkeelta saadut tiedot tiedot-muuttujaan
                Enumeration tiedot = request.getParameterNames();
                String parametri;
                //tulostetaan kaikki tiedot silmukan avulla
                for (int i = 0; tiedot.hasMoreElements(); i++) {
                    parametri = (String) (tiedot.nextElement());
                    //
                    out.println("<b>" + parametri + "</b>" + " : " + request.getParameter(parametri) + "<br>");
                }
                
                //Lopuksi parsitaan stringeistä doublet ja lasketaan palkka
                double palkkaa;
                
                String tunnit_temp = request.getParameter("tehdyt_tunnit");
                double tunnit = Double.parseDouble(tunnit_temp);
                
                String palkka_temp = request.getParameter("tuntipalkka");
                double palkka = Double.parseDouble(palkka_temp);
                
                String verot_temp = request.getParameter("veroprosentti");
                double verot = Double.parseDouble(verot_temp);
                verot = 1.0 - (verot / 100);
                
                palkkaa = (tunnit * palkka) * verot;
                out.println("Palkkasi on " + palkkaa);

            
      out.write("\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
