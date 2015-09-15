<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>


<html>
<head>
    <title>Asiakkaiden lis‰ys</title>

<link rel="stylesheet" href="css/tyyli.css" />
</head>

   
<%@ include file="valikko.jsp" %>
    

<body>
    <h3>Lis‰‰ asiakas</h3>
    <form action="ServletLisaaAsiakas" method="post">
        
        <table>
            <tr>
                <td>
                    Nimi:
                </td>
                <td align = "right">
                    <input type="text" name="nimi">
                </td>
            </tr>
             <tr>
                <td>          
                    Osoite:
                </td>
                <td align = "right">
                    <input type="text" name="osoite">
                </td>
            </tr>
            <tr>
                <td>                   
                    Puhelin:
                </td>
                <td align = "right">
                    <input type="text" name = "puhelin">
                </td>
            </tr>                    
             <tr>
                <td>                   
                    Email:
                </td>
                <td align = "right">
                     <input type="text" name= "email">
                 </td>
            </tr> 
            <tr>
                  <td>
                      Salasana:
                  </td>
                <td align = "right">              
                    <input type="password" name="salasana">
                </td>
            </tr> 
            <tr>
                <td>                
                    <input type="submit" value="Lis‰‰">
                 </td>
                 <td>
                     <input type="reset" value="Tyhjenn‰">
                 </td>
            </tr>                    
        </table>
    </form>
    </div>
    
    </body>
</html>
