<%-- 
    Document   : palkanlaskija
    Created on : 15.9.2014, 17:56:16
    Author     : käyttäjä
--%>
<%@ page import="java.util.*"%>

<html>
    <head><title></title></head>
    <body>
        <p>

            <%
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
                out.println("<b>Palkkasi on: " + palkkaa + "<b>");

            %>

            <%--Sama kuin edellä mutta ilman Enumeration -luokkaa ja silmukkaa:
            <%
            out.println("<b>Nimi</b>: " + request.getParameter("nimi") + "<br>");
            out.println("<b>Osoite</b>: " + request.getParameter("osoite") + "<br>");
            out.println("<b>Sukupuoli</b>: " + request.getParameter("sukupuoli") + "<br>");
            out.println("<b>Uskonto</b>: " + request.getParameter("uskonto") + "<br>");
            %>
            --%>

    </body>
</html>

