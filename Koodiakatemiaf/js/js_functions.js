/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//Tarkistaa vastauksen. 
//Palauttaa tosi jos oikein, jolloin tallentaa edistymisen kantaan. "aja" nappi muutetaan eteenpäin napiksi jos palauttaa true. 
function Tarkista(editorista,outputista)
{
                                  var palauttaa;  
                                  
                                  if(editorista === outputista)
                                  {
                                    window.alert("Vastaus oikein!");
                                    //funktion paikka
                                    editorista = "";
                                    outputista = "";
                                    palauttaa = "oikein";
                                    return palauttaa;
                                  }
                                  else if(outputista === null || outputista === "")
                                  {
                                    window.alert("Ei vastausta!");
                                    editorista = "";
                                    outputista = "";
                                    palauttaa = "vastaamatta";
                                    return palauttaa;
                                  }
                                  else if(editorista !== outputista)
                                  {
                                    window.alert("Vastaus väärin!");
                                    editorista = "";
                                    outputista = "";
                                    palauttaa = "väärin";
                                    return palauttaa;
                                  }                                  
                                  else
                                  {
                                    window.alert("Virhe tarkistuksessa!");
                                    editorista = "";
                                    outputista = "";
                                    palauttaa = "virhe";
                                    return palauttaa;
                                  }
                                  
}    




//tulostaa annetun koodin iframeen
function tulostaKoodi(koodi)
{
  
    (function() { 
        document.write(koodi);
        })();   
    
    
}

