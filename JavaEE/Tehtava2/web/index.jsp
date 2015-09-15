<%-- 
    Document   : index
    Created on : 15.9.2014, 9:16:04
    Author     : käyttäjä
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <%

            //nimen vastaanotto lomakkeelta tapahtuu tässä
            //vastaa phpsä $_POST['nimi']
              
            //otetaan lomakkeelta tiedot ja parsitaan kokonaisluvuiksi
            String tunnit_str = request.getParameter("tehdyt_tunnit");
            int tehdyt_t = Integer.parseInt(tunnit_str);     
            
            String palkka_str = request.getParameter("tuntipalkka");
            double palkka = Double.parseDouble(palkka_str);   
            
            String vero_str = request.getParameter("veroprosentti");
            double vero = Double.parseDouble(vero_str);   
            double vero_temp = (vero / 100);
            vero = 1.0 - vero_temp;
              
            
            if (tehdyt_t > 0 && palkka > 0) {
                double tuntipalkka_yht = tehdyt_t * palkka;
                palkka = tuntipalkka_yht * vero;
                out.println("Palkkasi on " + palkka + "€");
                
            } else {
                out.println("Syötä tiedot!");
            }
        %>
    </body>
</html>
