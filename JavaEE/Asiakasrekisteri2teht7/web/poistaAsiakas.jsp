<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<%-- Tietokantahakuja varten on lisättävä javan sql-luokka jsp-sivun käyttöön. --%>
<%@page import="java.sql.*" %>
<%@page import="TavallisetLuokat.SQL" %>
<html>
<head>
    <title>Asiakkaan poisto</title>
    <link rel="stylesheet" href="css/tyyli.css" />
</head>

<%@ include file="valikko.jsp" %>

<body>
<h3>Poista asiakas</h3>

<%-- Luodaan pudotusvalikko jossa näkyvät kannassa olevat
s-postiosoitteet. Pudotusvalikosta voidaan valita poistettava.--%>

<form method="post" action="ServletPoistaAsiakas">

<table>
<tr>
    <td>
        <select name="email">
<% 
   /*Seuraavaa koodia voitaisiin siirtää esim. tietokantaluokkaan ja kutsua sieltä
     metodin välityksellä.*/

   //Otetaan yhteys tietokantaluokan avulla
   Connection conn = TavallisetLuokat.SQL.openConnection();

   Statement statement = conn.createStatement();

  //Luodaan kysely ja suoritetaan se.
  String query = "SELECT email FROM asiakkaat";
  ResultSet resultSet = statement.executeQuery(query);

  //Käydään tulokset läpi ja tulostetaan ne pudotusvalikkoon.
  while( resultSet.next() ) {
   
    String email = resultSet.getString("email");
    out.print("<option value=\"" + email +"\">"+email+"</option>");
  }%>

        </select>
    </td>
   <td>
    <input type="submit" name="Submit" value="Poista valittu">
   </td>
  </tr>
 </table> 

   </form>

</body>
</html>
