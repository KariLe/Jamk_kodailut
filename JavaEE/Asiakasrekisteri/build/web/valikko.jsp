



<%


  //Otetaan vastaan sessiosta tieto loggautumisesta.
  String log = (String) session.getAttribute("login");
  //Jos k�ytt�j� on jo loggautunut, niin h�nelle annetaan 
  //mahdollisuus loggautua ulos.
    if( log.equals("ok") )
    {
%>

<form name="kirjaudu_ulos" method="post" action="ServletLoginUlos">
<a href='asiakkaat.jsp'>Asiakkaat</a> |
<a href='lisaaAsiakas.jsp'>Lis�� asiakas</a> |
<a href='poistaAsiakas.jsp'>Poista asiakas</a> |
<!--<a href='muokkaaAsiakas.jsp'>Muokkaa asiakas</a> |-->

<input type="submit" name="Submit" value="Kirjaudu ulos">
</form>
<form name="haku" method="post" action="haku.jsp">
      <input type="text" name="hae"><br>
      <input type="submit" value="hae">
</form>    
<%
    }

//Jos uloskirjautumista ei haluta k�ytt�j�lle tarjota, niin silloin voidaan
//k�ytt�� html-muotoista valikkoa(sivun yl�osa ennen jsp-koodia).
%>

