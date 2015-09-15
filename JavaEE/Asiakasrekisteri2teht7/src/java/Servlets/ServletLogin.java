/*
 * Muista asentaa projektiin
 * MySQL -ajurikirjasto tai t�m� tiedosto valittaa
 * NullPointerExceptionia.
 */

package Servlets;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    Connection conn = null;

    /** Initializes the servlet.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    //yhteys kantaan tietokantaluokan avulla.
        try {
        conn = TavallisetLuokat.SQL.openConnection();
        }
        catch (Exception e) {
           System.out.println("Kantaan ei saada yhteytt� " + e);
        }
    }

    /** Destroys the servlet.
     */
    @Override
    public void destroy() {

    //Tietokantayhteyden sulkeminen
         try {
          conn.close();
        } catch ( SQLException se ) {
           System.out.println("Poikkeus " + se);
        }
    }

    //Kaikki toimenpiteet tehd��n doPost-metodissa.
    //T�ss� servletiss� ei ole k�ytetty doGet() tai ProcessRequest() -metodia

    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {


    PrintWriter out = response.getWriter();

    /*Mik�li sessiota ei ole, se luodaan
        Sessiota hy�dynnet��n tarkistettaessa my�hemmin ett�
        k�ytt�j� on kirjautunut sis��n.*/

     HttpSession session = request.getSession(true);

        //Luetaan parametrit, jotka kirjautumislomakkeelta on l�hetetty.
        String email = request.getParameter("email");
        String salasana = request.getParameter("salasana");

        out.print(email);

        //Otetaan muuttuja login_ok k�ytt��n ja asetetaan oletusarvoksi false.
        boolean login_ok = false;


     try {
     //luodaan Statement-olio jonka avulla voidaan suorittaa sql-lause
     Statement stmt = conn.createStatement();

     //Suoritetaan sql ja saadaan tulosjoukko ResultSet-olioon.
     ResultSet rs = stmt.executeQuery("SELECT email, salasana FROM asiakkaat");

     //K�yd��n tulosjoukko l�pi while silmukalla ja next-metodilla, joka palauttaa arvon true
     //kunnes saavutaan tulosjoukon viimeiseen tietueeseen.
     while(rs.next())
     {
       //Luetaan tietueen tiedot
       String email2 = rs.getString("email");
       String salasana2 = rs.getString("salasana");

       //Jos tietokannasta l�ytyi k�ytt�j�n sy�tt�m�t tiedot, niin asetetaan
       //login_ok-muuttujan arvoksi true ja lopetetaan silmukan l�pik�ynti.
       if(email.compareTo(email2) == 0 && salasana.compareTo(salasana2) == 0)
       {
           login_ok = true;
           break;
       }

     }


     //Jos login_ok:n arvo on true niin asetetaan sessioon tieto loggautumisesta
     //ja ohjataan k�ytt�j� Asiakkaat.jsp-sivulle.
        if( login_ok == true )
        {
            //sessioon tieto loggautumisesta
            session.setAttribute("login", "ok");
            //Debuggausta voidaan suorittaa tulostamalla konsoliin.
            System.out.println("Login ok");
            //Ohjaus eteenp�in.
            response.sendRedirect("asiakkaat.jsp");
            //Return-lause lopettaa servletin suorituksen.
            return;
        }
      //Login_ok -arvo on false eli loggautuminen ep�onnistui.
        //Ohjataan k�ytt�j� kirjautumaan uudelleen
        else {
            response.sendRedirect("login.htm");
        }

    }

     catch(SQLException se){
         
     out.println("Tapahtui virhe: " + se);

     }

        out.close();
    }


}
