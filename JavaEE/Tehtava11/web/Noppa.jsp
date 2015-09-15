<%-- Noppa.jsp ottaa käyttön olion joka luodaan 
   tavallisesta luokasta. 
   jsp:usebean ei vaadi että luokan tarvitsee olla papu

   Tehtävä: Täydennä sovellusta niin että se ilmoittaa
   heittojen lukumäärän ja nollaa sen. Se myös ilmoittaa
   heittojen keskiarvon ja nollaa sen. Tee sovelluslogiikka
   eli tarvittavat attribuutit ja metodit Noppa -luokkaan.

   Muuta Noppa.jsp:n koodi sellaiseksi että siinä käytetetään
   normaalin JSP:n sijasta mahdollisimman paljon JSTL-
   tagikieltä.

--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"
          prefix="c" %>

<%--Otetaan jsp:useBean-actionilla Noppa.java käyttöön.
Scope on nyt session, joten Noppa.java on käytettävissä 
tälle sivulle ja kaikille muille sivuille jotka ovat
samassa sessiossa.
--%>
<jsp:useBean id="noppa" scope="session" class="org.mypackage.Tehtava11.Noppa" />
      

<html>
    <head><title>Noppa.jsp</title></head>
    <body>
        <%-- 
         <%
            if (request.getParameter("heita") != null) {
                //Käytetään noppa-olion heita() -metodia
                noppa.heita();
        
        %>
        --%>
        <%--Jos muuttuja i1 on tosi, eli "ok "niin noppa heitä --%>
        
        <c:set var = "i1"  value = "${param.heita}" scope = "session" />
        <c:if test="${i1 != null}">  
            <c:out value="${noppa.heita()}"></c:out>            
        </c:if>
        
        
        <%-- Käytetään noppa-olion getTulos() -metodia--%>
        <%-- Silmäluvuksi tuli: <%= noppa.getTulos()%><br>--%>
        Silmäluvuksi tuli: <c:out value="${noppa.getTulos()}" /><br>
        <%-- 
        <%
            } else if (request.getParameter("nollaa") != null) {
                noppa.nollaa();
                out.println("Noppaa ei ole heitetty<br>");
            } else {
                out.println("Noppaa ei ole heitetty<br>");

            }
        %> 
        --%>
        <%--Jos muuttuja i ei ole tosi niin tulostetaan noppaa ei ole heitetty ja nollataan heitot--%>
        <c:set var = "i"  value = "${param.nollaa}" scope = "session" />
        
        <c:choose>
            <c:when test="${i!=null}">
                <c:out value="${noppa.nollaa()}"></c:out>                 
                <p>Noppaa ei ole heitetty</p>
            </c:when>          
            <c:otherwise>
                <p></p>
            </c:otherwise>
        </c:choose>
        
       <%--Tulostetaan tilastot --%>
       Heittojen summa on nyt: <c:out value="${noppa.getSumma()}" /><br>
       Heittojen keskiarvo on nyt: <c:out value="${noppa.getKeskiarvo()}" /><br>
       Heittoja on nyt:  <c:out value="${noppa.getHeitot()}" /><br>
        
         <%--Heittojen summa on nyt: <%= noppa.getSumma()%><br>
        Heittojen keskiarvo on nyt: <%= noppa.getKeskiarvo()%><br>
        Heittoja on nyt: <%= noppa.getHeitot()%><br>--%>
        
        <%--Luodaan URL:it joiden avulla noppa saadaan toimimaan--%>
        <%--
        <%
            String heitaURL = response.encodeURL("Noppa.jsp?heita=ok");
            String nollaaURL = response.encodeURL("Noppa.jsp?nollaa=ok");

        //Nopan heitto
            out.println("<a href='" + heitaURL + "'>Heitä noppaa</a><br>");
            out.println("<a href='" + nollaaURL + "'>Nollaa summa</a><br>");
        %>   
        --%>
        
         <%----%>
         <%--Luodaan linkit heitolle ja nollaukselle, c:url hakee parametrin "heitä" arvon ja lisää sen linkkiin--%>
         <a href="<c:url value='Noppa.jsp'>
                   <c:param name='heita' value='ok' />
         </c:url>">Heitä noppaa</a><br>
              
       
         <a href="<c:url value='Noppa.jsp'>
                   <c:param name='nollaa' value='ok' />
         </c:url>">Nollaa summa</a><br>
                
        
        
    </body>
</html>