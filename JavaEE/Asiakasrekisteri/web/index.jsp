<%@page contentType="text/html"%>
<html>
<head>
    <title>sendredirect</title>
</head>
<body>

<%
//Index-sivun olemassaolo estää käyttäjää näkemästä hakemistorakennetta
//jos se on palvelimella sallittu.
//Käyttäjä ohjataan suoraan login-sivulle.
  response.sendRedirect("login.htm");
%>

</body>
</html>
