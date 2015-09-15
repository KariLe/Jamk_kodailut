package Servlets;

/*
 * KyselynKasittelijaServlet.java
 * Servletti joka tekee saman kuin KyselynKasittelija.jsp
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "KyselynKasittelijaServlet", urlPatterns = {"/KyselynKasittelijaServlet"})
public class KyselynKasittelijaServlet extends HttpServlet {

    /**
     * Initializes the servlet.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    /**
     * Destroys the servlet.
     */
    @Override
    public void destroy() {

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //kerätäään kaikki lomakkeelta saadut tiedot arvot-muuttujaan
        Enumeration arvot = request.getParameterNames();
        String parametri;
        //tulostetaan kaikki tiedot silmukan avulla
        for (int i = 0; arvot.hasMoreElements(); i++) {
            parametri = (String) (arvot.nextElement());
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
                out.println("<b>Palkkasi on: " + palkkaa + "<b>");
        
        out.close();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return 
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
