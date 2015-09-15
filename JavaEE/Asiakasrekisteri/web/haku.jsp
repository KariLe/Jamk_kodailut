<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-15"%>

<%--Importataan tietokannan k�sittelyn vaatimat luokat
Huomaa ett� saadaksesi tietokantayhteyden MySQL JDBC -ajuri pit�� lis�t�
web-projektin libraries -kansioon, mik�li sit� ei siell� jo ole.
--%>
<%@page import="java.sql.*"%>
<%@page import="TavallisetLuokat.SQL"%>

<html>
<head>
    <title>Asiakkaat</title>
    <link rel="stylesheet" href="css/tyyli.css" />
</head>
<%-- Upotetaan valikko sivulle. Valikon avulla k�ytt�j� voi navigoida eri
     toimintojen v�lill�. --%>

<%@ include file="valikko.jsp" %>
<body>
<h3>Asiakkaat</h3>

<%-- Muodostetaan lomake, jossa asiakkaiden tiedot n�ytet��n.
     Lomake mahdollistaa yhden asiakkaan valitsemisen.
     Valitun asiakkaan tiedot l�hetet��n muutaAsiakas.jsp-sivulle.
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
    //Katsotaan onko k�ytt�j� loggautunut. Jos ei niin ohjataan login sivulle.
   //Varmistus suoritetaan niin, ett� katsotaan onko sessiossa olevan login-muuttujan
   //arvo ok. Ellei ole, niin k�ytt�j� ei ole loggautunut j�rjestelm��n sis�lle
   //ja ohjataan login.htm-sivulle.
   String login = (String) session.getAttribute("login"); //Tieto vastaan
    if( login == null || !login.equals("ok") )//Tarkistus
    {
       response.sendRedirect("login.htm");
       //Return-lause lopettaa jsp-sivun suorittamisen. Eli tietokannan
       //k�sittelyyn ei menn� ellei loggautuminen ole kunnossa.
       return;
    }

   
   /*Seuraavaa koodia voitaisiin siirt�� esim. tietokantaluokkaan ja kutsua sielt�
     metodin v�lityksell�.*/
   
   //yhteys kantaan
    Connection conn = TavallisetLuokat.SQL.openConnection();
    if ( conn == null ){
        out.println("Tietokantapalvelimeen ei saada yhteytt�!");
        return;
    }
   String hae = request.getParameter("hae"); 

   //luodaan Statement-olio jonka avulla voidaan suorittaa sql-lause
   Statement stmt2 = conn.createStatement();

   //Suoritetaan sql ja saadaan tulosjoukko.
   ResultSet rs2 = stmt2.executeQuery("SELECT * FROM asiakkaat WHERE nimi='" + hae + "'");
   //out.println(hae);

   
   //K�yd��n tulosjoukko l�pi
   
   while ( rs2.next() )
   {
     //luetaan tietueen tiedot
     String nimi = rs2.getString("nimi");
     String osoite = rs2.getString("osoite");
     String puhelin = rs2.getString("puhelin");
     String email = rs2.getString("email");
     String salasana = rs2.getString("salasana");

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