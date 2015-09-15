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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ServletMuokkaaAsiakas", urlPatterns = {"/ServletMuokkaaAsiakas"})
public class ServletMuokkaaAsiakas extends HttpServlet {
    
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //tänne tulee update lause
            
            
        //response.setContentType("text/html;charset=UTF-8");        
        response.setContentType("text/html;charset=ISO-8859-1");
       
        String nimi = request.getParameter("nimi");   
        String osoite = request.getParameter("osoite");   
        String email = request.getParameter("email");   
        String puhnumero = request.getParameter("puhnumero");   
        String salasana = request.getParameter("salasana"); 
        String uusisalasana = request.getParameter("uusisalasana"); 
        
        //hakee kannasta vanhan salasanan vertailuun
        String sql_salasana = "SELECT salasana FROM asiakkaat WHERE email='" + email +"'";
        
        PreparedStatement pre_stmt3 = null;
        
        
        try {
             //String vanha_salasana = pre_stmt3.executeQuery().toString();            
            
            pre_stmt3 = conn.prepareStatement(sql_salasana);
            ResultSet vastaus = pre_stmt3.executeQuery();
            String vanha_salasana = "";
            
            
            while(vastaus.next()) {
                // ... get column values from this record
                vanha_salasana = vastaus.getString    ("salasana");
            }           
             
              if ( salasana.equals(vanha_salasana))
              {
            
                //Esitell��n PreparedStatement-olio, johon asetetaan my�hemmin lis�yskomento.
            //PreparedStatement pre_stmt2 = null;
            PreparedStatement pre_stmt4 = null;

            //Kaikki tietokantatoiminnot on teht�v� try-lohkon sis�ll�. Joten...
            try {
            //Muodostetaan tietokantakomento aluksi merkkijonoon oikean muotoisena.
            //Kysymysmerkkej� k�ytet��n parametrien paikalla.
            
            //tähän update lausekkeen lisäys
            /*
            String sql_nimi = "UPDATE asiakkaat SET nimi='" + nimi + "' WHERE nimi='" + nimi + "'";
            String sql_email = "UPDATE asiakkaat SET email='" + email + "' WHERE nimi='" + email + "'";
            String sql_osoite = "UPDATE asiakkaat SET osoite='" + osoite + "' WHERE osoite='" + osoite + "'";
            String sql_puhelin = "UPDATE asiakkaat SET puhelin='" + puhnumero + "' WHERE puhelin='" + puhnumero + "'";
            String sql_salasana2 = "UPDATE asiakkaat SET salasana='" + uusisalasana + "' WHERE salasana='" + uusisalasana + "'";
            */
            
            //Alustetaan olio luodulla merkkijonolla.
            //"INSERT INTO asiakkaat (nimi,osoite,puhelin,email,salasana) " + 
           // "VALUES (?,?,?,?,?)";
            
            //Muodostetaan tietokantakomento aluksi merkkijonoon oikean muotoisena.
            //Kysymysmerkkej� k�ytet��n parametrien paikalla.
            String sql =  "UPDATE Asiakkaat SET nimi=?, osoite=?, puhelin=?, email=?, salasana=? WHERE email=?";
                    
                    
            //        "UPDATE asiakkaat (nimi,osoite,puhelin,email,salasana) " + 
            //"VALUES (?,?,?,?,?)";
            //Alustetaan olio luodulla merkkijonolla.
            pre_stmt4 = conn.prepareStatement(sql);

            //Asetetaan sql-komentoon parametrien paikalle k�ytt�j�n sy�tt�m�t tiedot.
            pre_stmt4.setString(1, nimi);
            pre_stmt4.setString(2, osoite);
            pre_stmt4.setString(3, puhnumero);
            pre_stmt4.setString(4, email);
            pre_stmt4.setString(5, uusisalasana);
            pre_stmt4.setString(6, email);

            //executeUpdate-komento suorittaa sql-komennon eli t�ss� lis�yksen tietokantaan.
            pre_stmt4.executeUpdate();
            
            
            
            
            
            //pre_stmt2 = conn.prepareStatement(sql_email);
            //pre_stmt2.executeUpdate();

            //Asetetaan sql-komentoon parametrien paikalle k�ytt�j�n sy�tt�m�t tiedot.
            //pre_stmt2.setString(1, email);
            

            //executeUpdate-komento suorittaa sql-komennon eli t�ss� lis�yksen tietokantaan.
            
            response.sendRedirect("asiakkaat.jsp");
        } catch ( SQLException e )  {
          out.println("<p> Muokkaus ep�onnistui, poikkeus " + e + " </p>");
        }
    //Finally-lohkossa suljetaan PreparedStatement-olio.
        finally {
           try {
             pre_stmt4.close();   
           } catch ( SQLException e ) {
              System.out.println(e);   
           }
        }

        }         
           
        
        else
        {
             out.println(pre_stmt3.executeQuery());
             out.println("Väärä salasana");
        }
        } catch (SQLException ex) {
            Logger.getLogger(ServletMuokkaaAsiakas.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
       
        //Tehd��n tarkistus, jolla varmistetaan, ett� k�ytt�j� on sy�tt�nyt 
        //kaikki tietokannan vaatimat tiedot. Lis�yst� ei tehd�, jos jotain
        //vaadittavista tiedoista puuttuu.
       
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
