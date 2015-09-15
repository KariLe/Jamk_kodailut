/*
 * 
 * ServletLoginUlos.java
 * 
 * servletti jolla kirjaudutaan 
 * sovelluksen sessiosta ulos
 * 
 * 
 */


package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletLoginUlos", urlPatterns = {"/ServletLoginUlos"})
public class ServletLoginUlos extends HttpServlet {

    /** Initializes the servlet.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    /** Destroys the servlet.
     */
    @Override
    public void destroy() {

    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

         //Mikäli sessiota ei uloskirjautumivaiheessa ole, niin sitä ei luoda.
        //Sessio pitää joka tapauksessa ottaa käyttöö tällä määrityksellä.
        HttpSession session = request.getSession(false);
        //Lopetetaan sessio eli istunto.
        session.invalidate();
        //Ohjataan loggautumis-sivulle.
        response.sendRedirect("login.htm");

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

}
