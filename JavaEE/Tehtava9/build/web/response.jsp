<%-- 
    Document   : response
    Created on : Oct 22, 2014, 11:06:10 AM
    Author     : Kari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tietosi</title>
    </head>
    <body>
        <jsp:useBean id="myBean" scope="session" class="org.mypackage.Tehtava9.TietoKasittelija" />
        <jsp:setProperty name="myBean" property="nimi"/>
        Nimesi,  <jsp:getProperty name="myBean" property="nimi" /><br>
        <jsp:setProperty name="myBean" property="osoite"/>
        Osoitteesi, <jsp:getProperty name="myBean" property="osoite" /><br>
        <jsp:setProperty name="myBean" property="kotikunta"/>
        Kotikuntasi, <jsp:getProperty name="myBean" property="kotikunta" /><br>
        <jsp:setProperty name="myBean" property="email"/>
        Email, <jsp:getProperty name="myBean" property="email" /><br>
    </body>
</html>
