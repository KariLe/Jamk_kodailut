<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<%-- Tietokantahakuja varten on lisättävä javan sql-luokka jsp-sivun käyttöön. --%>
<%@page import="java.sql.*" %>
<%@page import="TavallisetLuokat.SQL" %>
<html>
<head>
    <title>Asiakkaan muokkaus</title>
    <link rel="stylesheet" href="css/tyyli.css" />
</head>

<%@ include file="valikko.jsp" %>

<body>
<h3>Muokkaa asiakasta</h3>

<%-- Luodaan pudotusvalikko jossa näkyvät kannassa olevat
s-postiosoitteet. Pudotusvalikosta voidaan valita poistettava.--%>
<table>
   
<form method="post" action="ServletMuokkaaAsiakas">
    
<%

   /*Seuraavaa koodia voitaisiin siirtää esim. tietokantaluokkaan ja kutsua sieltä
     metodin välityksellä.

   //Otetaan yhteys tietokantaluokan avulla
   Connection conn = TavallisetLuokat.SQL.openConnection();

   Statement statement = conn.createStatement();

   //Luodaan kysely ja suoritetaan se.
   String query = "SELECT email FROM asiakkaat";
   ResultSet resultSet = statement.executeQuery(query);

   //Käydään tulokset läpi ja tulostetaan ne pudotusvalikkoon.
   while( resultSet.next() ) {   
   String email = resultSet.getString("email");
   out.print("Anna uudet tiedot asiakkaalle " + email + "<br>");
   //out.print("<option value=\"" + email +"\">"+email+"</option>");
   }
           */
%>

    <!--
    <p>Nimi:            <input type="text" size="20" name="nimi"><p>
    <p>Osoite:          <input type="text" size="20" name="osoite"><p>
    <p>Email:           <input type="text" size="20" name="email"><p>
    <p>Puhelinnumero:   <input type="text" size="20" name="puhnumero"><p>
    <p>Salasana:        <input type="text" size="20" name="salasana"><p>
    <p>Uusi salasana:   <input type="text" size="20" name="uusisalasana"><p>
    -->    
  <tr>
    <th></th>
    <th>Uusi tieto</th>
  </tr>
  <tr>
    <td>Nimi:</td>
    <td><input type="text" size="20" name="nimi"></td>
  </tr>
  <tr>
    <td>Osoite: </td>
    <td><input type="text" size="20" name="osoite"></td>
  </tr>
  <tr>
    <td>Email:</td>
    <td><input type="text" size="20" name="email"></td>
  </tr>
  <tr>
    <td>Puhelinnumero:</td>
    <td><input type="text" size="20" name="puhnumero"></td>
  </tr>
  <tr>
    <td>Salasana:</td>
    <td><input type="text" size="20" name="salasana"></td>
  </tr>
  <tr>
    <td>Uusi salasana:</td>
    <td><input type="text" size="20" name="uusisalasana"></td>
  </tr>
  <tr>
    <td>Tallenna:</td>
    <td><input type="submit" value="Tallenna"></td>
  </tr>      

<p></p>
    
</table>
  

</form>
</body>
</html>
