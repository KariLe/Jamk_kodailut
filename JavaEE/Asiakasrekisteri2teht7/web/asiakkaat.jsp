<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-15"%>

<%--Importataan tietokannan käsittelyn vaatimat luokat
Huomaa että saadaksesi tietokantayhteyden MySQL JDBC -ajuri pitää lisätä
web-projektin libraries -kansioon, mikäli sitä ei siellä jo ole.
--%>
<%@page import="java.sql.*"%>
<%@page import="TavallisetLuokat.SQL"%>

<html>
<head>
    <title>Asiakkaat</title>
    <link rel="stylesheet" href="css/tyyli.css" />
</head>
<%-- Upotetaan valikko sivulle. Valikon avulla käyttäjä voi navigoida eri
     toimintojen välillä. --%>

<%@ include file="valikko.jsp" %>
<body>
<h3>Asiakkaat</h3>

<%-- Muodostetaan lomake, jossa asiakkaiden tiedot näytetään.
     Lomake mahdollistaa yhden asiakkaan valitsemisen.
     Valitun asiakkaan tiedot lähetetään muutaAsiakas.jsp-sivulle.
     jossa tapahtuu valitun asiakaan tietojen muuttaminen --%>
<form name="muokkaaAsiakas" method="post" action="muokkaaAsiakas.jsp">

 <table>

<tr>
    <th>&nbsp;</th>
    <th>Nimi</th> 
    <th>Osoite</th>
    <th>Puhelin</th>
    <th>Email</th>
    <th>Salasana</th>
</tr>
<%
    //Katsotaan onko käyttäjä loggautunut. Jos ei niin ohjataan login sivulle.
   //Varmistus suoritetaan niin, että katsotaan onko sessiossa olevan login-muuttujan
   //arvo ok. Ellei ole, niin käyttäjä ei ole loggautunut järjestelmään sisälle
   //ja ohjataan login.htm-sivulle.
   String login = (String) session.getAttribute("login"); //Tieto vastaan
    if( login == null || !login.equals("ok") )//Tarkistus
    {
       response.sendRedirect("login.htm");
       //Return-lause lopettaa jsp-sivun suorittamisen. Eli tietokannan
       //käsittelyyn ei mennä ellei loggautuminen ole kunnossa.
       return;
    }

   
   /*Seuraavaa koodia voitaisiin siirtää esim. tietokantaluokkaan ja kutsua sieltä
     metodin välityksellä.*/
   
   //yhteys kantaan
    Connection conn = TavallisetLuokat.SQL.openConnection();
    if ( conn == null ){
        out.println("Tietokantapalvelimeen ei saada yhteyttä!");
        return;
    }

   //luodaan Statement-olio jonka avulla voidaan suorittaa sql-lause
   Statement stmt = conn.createStatement();

   //Suoritetaan sql ja saadaan tulosjoukko.
   ResultSet rs = stmt.executeQuery("SELECT * FROM asiakkaat");


   //Käydään tulosjoukko läpi
   while ( rs.next() )
   {
     //luetaan tietueen tiedot
     String nimi = rs.getString("nimi");
     String osoite = rs.getString("osoite");
     String puhelin = rs.getString("puhelin");
     String email = rs.getString("email");
     String salasana = rs.getString("salasana");

     //Lopuksi tulostetaan tiedot.
%>

<tr>
   <td><input type="checkbox" name="valittu" value="<%= email %>"></td>
   <td><%= nimi %></td>
   <td><%= osoite %></td>
   <td><%= puhelin %></td>
   <td><%= email %></td>
   <td><%= salasana %></td>
</tr>

<%
   }

 conn.close();
%>
<tr>
<td><input type="submit" name="Submit" value="Muuta valittu"><td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
</table>
</form>

</body>
</html>