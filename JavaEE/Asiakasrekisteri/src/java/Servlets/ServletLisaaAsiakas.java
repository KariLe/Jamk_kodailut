package Servlets;

/*
 * ServletLisaaAsiakas.java
 *
 * 
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletLisaaAsiakas", urlPatterns = {"/ServletLisaaAsiakas"})
public class ServletLisaaAsiakas extends HttpServlet {
    

        Connection conn = null;
    
    /** Initializes the servlet.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
    //yhteys kantaan tietokantaluokan avulla
        conn = TavallisetLuokat.SQL.openConnection();
    
    }
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
       
        response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        
        String nimi = request.getParameter("nimi");
        String osoite = request.getParameter("osoite");
        String puhelin = request.getParameter("puhelin");
        String email = request.getParameter("email");
        String salasana = request.getParameter("salasana");

        //Tehd��n tarkistus, jolla varmistetaan, ett� k�ytt�j� on sy�tt�nyt 
        //kaikki tietokannan vaatimat tiedot. Lis�yst� ei tehd�, jos jotain
        //vaadittavista tiedoista puuttuu.
        if (nimi == null || nimi.length() == 0 || email == null || email.length() == 0 ||
        salasana == null || salasana.length() == 0)
        {
            out.println("Nimi, salasana ja s�hk�postiosoite annettava");
        }
        else
        {
        //Esitell��n PreparedStatement-olio, johon asetetaan my�hemmin lis�yskomento.
        PreparedStatement pre_stmt = null;
        
        //Kaikki tietokantatoiminnot on teht�v� try-lohkon sis�ll�. Joten...
        try {
            //Muodostetaan tietokantakomento aluksi merkkijonoon oikean muotoisena.
            //Kysymysmerkkej� k�ytet��n parametrien paikalla.
            String sql = "INSERT INTO asiakkaat (nimi,osoite,puhelin,email,salasana) " + 
            "VALUES (?,?,?,?,?)";
            //Alustetaan olio luodulla merkkijonolla.
            pre_stmt = conn.prepareStatement(sql);

            //Asetetaan sql-komentoon parametrien paikalle k�ytt�j�n sy�tt�m�t tiedot.
            pre_stmt.setString(1, nimi);
            pre_stmt.setString(2, osoite);
            pre_stmt.setString(3, puhelin);
            pre_stmt.setString(4, email);
            pre_stmt.setString(5, salasana);

            //executeUpdate-komento suorittaa sql-komennon eli t�ss� lis�yksen tietokantaan.
            pre_stmt.executeUpdate();
            response.sendRedirect("asiakkaat.jsp");
        } catch ( SQLException e )  {
          out.println("<p> Lis�ys ep�onnistui, poikkeus " + e + " </p>");
        }
        //Finally-lohkossa suljetaan PreparedStatement-olio.
        finally {
           try {
             pre_stmt.close();   
           } catch ( SQLException e ) {
              System.out.println(e);   
           }
        }

        }
        
        out.println("</body>");
        out.println("</html>");        
       
        out.close();
    }
        
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
