<%-- 
    Document   : index
    Created on : Oct 22, 2014, 10:55:13 AM
    Author     : Kari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Anna tietosi</title>
    </head>
    <body>
        <h1>Syötä tiedot</h1>
        <form name="tiedot" action="response.jsp">
           Nimi: <input type="text" name="nimi" /><br>
           Osoite: <input type="text" name="osoite"/><br> 
           Kotikunta: <input type="text" name="kotikunta"/><br>
           Email: <input type="text" name="email" /><br>
           <input type="submit" value="Lähetä" name="submit" />
        </form>
    </body>
</html>
