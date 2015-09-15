<%-- 
    Document   : response
    Created on : Oct 21, 2014, 4:49:19 PM
    Author     : Kari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="mybean" scope="session" class="org.mypackage.Tehtava8.NameHandler" />
        <jsp:setProperty name="mybean" property="name"/>
        <h1>Hello, <jsp:getProperty name="mybean" property="name"/>!</h1>
        
    </body>
</html>
