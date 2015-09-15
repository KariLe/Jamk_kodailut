<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>

    <head><title>Taulukko.jsp</title></head>
    <body>

        <table border="1">

            <%
            //tehdään silmukalla taulukko jossa 5 riviä
                        
            String rajat = request.getParameter("raja");
            int rajaa = Integer.parseInt(rajat);                   

            for (int i = 1; i <= rajaa; i++) {%>
            <tr>
                <%--Tämä on JSP-kommentti jota ei näy HTML-lähdekoodissa
                 JSP:ssä muuttujan arvo tulostetaan =muuttujanimi -merkinnällä--%>

                <td>Tämä on rivi <%=i%></td>
            </tr>
            <%}%>

        </table>
    </body>
</html>
