<%@page contentType="text/html"%>
<html>
<head>
    <title>sendredirect</title>
</head>
<body>

<%
//Index-sivun olemassaolo est�� k�ytt�j�� n�kem�st� hakemistorakennetta
//jos se on palvelimella sallittu.
//K�ytt�j� ohjataan suoraan login-sivulle.
  response.sendRedirect("login.htm");
%>

</body>
</html>
