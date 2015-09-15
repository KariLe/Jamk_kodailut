/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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

/**
 *
 * @author Kari
 */
@WebServlet(name = "ServletPoistaAsiakas", urlPatterns = {"/ServletPoistaAsiakas"})
public class ServletPoistaAsiakas extends HttpServlet {
    
    Connection conn = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
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
        
        //poistaa asiakkaan tiedot
        //response.setContentType("text/html;charset=UTF-8");        
        response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter out = response.getWriter();        
        
        String email = request.getParameter("email");        

        //Tehd��n tarkistus, jolla varmistetaan, ett� k�ytt�j� on sy�tt�nyt 
        //kaikki tietokannan vaatimat tiedot. Lis�yst� ei tehd�, jos jotain
        //vaadittavista tiedoista puuttuu.
        if (email == null || email.length() == 0 )
        {
            out.println("S�hk�postiosoite annettava");
        }
        else
        {
        //Esitell��n PreparedStatement-olio, johon asetetaan my�hemmin lis�yskomento.
        PreparedStatement pre_stmt2 = null;
        
        //Kaikki tietokantatoiminnot on teht�v� try-lohkon sis�ll�. Joten...
        try {
            //Muodostetaan tietokantakomento aluksi merkkijonoon oikean muotoisena.
            //Kysymysmerkkej� k�ytet��n parametrien paikalla.
            
            //tähän delete lausekkeen lisäys
            String sql = "DELETE FROM asiakkaat WHERE email='" + email +"'";
            //Alustetaan olio luodulla merkkijonolla.
            //"INSERT INTO asiakkaat (nimi,osoite,puhelin,email,salasana) " + 
           // "VALUES (?,?,?,?,?)";
            
            pre_stmt2 = conn.prepareStatement(sql);

            //Asetetaan sql-komentoon parametrien paikalle k�ytt�j�n sy�tt�m�t tiedot.
            //pre_stmt2.setString(1, email);
            

            //executeUpdate-komento suorittaa sql-komennon eli t�ss� lis�yksen tietokantaan.
            pre_stmt2.executeUpdate();
            response.sendRedirect("poistaAsiakas.jsp");
        } catch ( SQLException e )  {
          out.println("<p> Poisto ep�onnistui, poikkeus " + e + " </p>");
        }
    //Finally-lohkossa suljetaan PreparedStatement-olio.
        finally {
           try {
             pre_stmt2.close();   
           } catch ( SQLException e ) {
              System.out.println(e);   
           }
        }

        }
        
        out.println("</body>");
        out.println("</html>");        
       
        out.close();
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
