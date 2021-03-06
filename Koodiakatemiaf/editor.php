
<!DOCTYPE html>
<html lang="en">
    <head>
        
        <meta  charset="UTF-8">
        <!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
        <link rel="stylesheet" type="text/css" href="css/editor_style.css" />
        <!--Jqueryn linkkaus -->
        <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" ></script>
        <!--<script type="text/javascript" src="vihje_script.js"></script>-->
        <script src="js/js_functions.js" type="text/javascript"></script>
        <title>Editor</title>          
    </head>
    <body>    
         <div id="wrapper">
        <nav id="ylapalkki">  <!-- ylavalikko --> 
  <ul>
    <li id= "tehtavavalikko"><a href="tehtavavalikko.php">Paluu tehtävävalikkoon </a></li>
    <li id="profiili"><a href="profile.php">Oma profiili</a></li>
  </ul>
        </nav>
        
             
        
            
        
        <!--Ohjeen iframe -->   
        <iframe id="tehtava"  src="php/ohjehaku.php" name="result">           

		
         <!--Tähän tulee ohjeita, jotka ladataan tiedostosta/tietokannasta-->      
         <script>
             $(document).ready(function(){
                 var ohjeen_iframe = document.getElementById('ohje_ikkuna'); 
                 ohjeen_iframe.src = ohjeen_iframe.src;               
             });
         </script>
          
         </iframe>   
            
       
        
        
       <section id="main"> 
          
        <!--Input-->
          
        <!--Ace editor embed -->
        <div id="editorwrapper">
        <div id="editor">
           
            <!--Tähän tulee se mitä editoriin ladataan valmiiksi-->
           
        </div>
            
        <div id="output_ala">
            <input type="button" id="aja_button" value="Aja koodi">
             <!--<input type="button" id="aja_button" value="Aja koodi">-->               
            <input type="button" id="reset_button" value="Resetoi koodi">
            <input type="button" id="eteenpain_button" value="Eteenpäin">
            </div> 
        </div>      
            
            <script src="libs/jquery.js" type="text/javascript"></script>
            <script src="libs/ace/ace.js" type="text/javascript"></script>
            
            <!--Teema ja mode-->
            <script>
                
             var editor = ace.edit("editor");
             editor.setTheme("ace/theme/twilight");
             editor.getSession().setMode("ace/mode/javascript");

           
           </script>
   
      
             
     
        <!--Input loppuu-->
        
           
            
        

      
         <!--Tulostuksen iFrame-->
         <script>
            $(document).ready(function() {
                $("#eteenpain_button").hide();
                
                $("#aja_button").click(function() {     
                        
                        //otetaan editorista koodi kun nappia painettu
                        var code = editor.getValue();

                           /*
                         //$.post("write.php", encodeURIComponent(code));
                         code = "code=" + encodeURIComponent(code);
                         $.post("write.php",code,function()
                         {
                              var iframe = document.getElementById('output_ikkuna'); 
                              iframe.src = iframe.src;                          
                         });
                         
                         */
                        //Lähettää editorin koodin ajaxilla iframeen //write.phplle
                        $.ajax({
                        url: "php/write.php",
                        data: "code=" + encodeURIComponent(code),
                        success: function() { //kun Ajax-toinito on onnistunut                                                
                            //iframen päivittäminen
                            //var iframe = tulostaKoodi(code);
                            
                            var iframe = document.getElementById('output_ikkuna');                            
                            iframe.src = iframe.src;
                            
                        }});
                     
                        
                        
                        var iframe_kayttajan_vastaus; 
                         
                        //Koska tietokannasta haku iframeen on hidas niin joudutaan manuaalisesti hidastamaan muuttujiin tallentamista.... 
                        setTimeout(function(){ 
                            //Tallennetaan käyttäjän vastaus outputista muuttujaan iframe_kayttajan_vastaus
                            iframe_kayttajan_vastaus  = document.getElementById('output_ikkuna').contentWindow.document.body.innerHTML;  

                            //response = $.post("output_result.php".responseText);


                            $.get("php/output_result.php", function(text) {
                                response = text;                               
                                
                                //muunnetaan varmuuden vuoksi stringiksi
                                tiedostosta   = new String(response);
                                iframesta  = new String(iframe_kayttajan_vastaus);

                                //Pätkitään tyhjät lopusta
                                tiedostosta_lyh  = tiedostosta.substring(0, tiedostosta.length);
                                iframesta_lyh = iframe_kayttajan_vastaus.substring(0,tiedostosta.length);
                                
                                
                                //debuggauksen helpottamiseksi
                                console.log(tiedostosta_lyh);
                                console.log(iframesta_lyh);                                
                                
                                //ajetaan tarkistus funktio
                                var palauttaa = Tarkista(tiedostosta_lyh,iframesta_lyh); 
                                console.log(palauttaa);  
                                
                                //muuttaa napin tarkistuksen mukaan vihreäksi tai antaa vihjeen jos väärin
                                if(palauttaa === "oikein")
                                {
                                    //$( "#output_ala" ).css('background-color','green');
                                    $("#eteenpain_button").show();
                                    
                                }
                                else if(palauttaa === "väärin" || palauttaa === "vastaamatta")
                                {
                                    //$( "#ohje_ala" ).css('background-color','red');
                                    //$( "#output_ala" ).css('background-color','red');
                                    //$( "#input_ala" ).css('background-color','red');
                                    
                                    window.alert("Muistithan sijoittaa tuloksen muuttujaan?");
                                }    
                                else if(palauttaa === "virhe")    
                                {
                                    window.alert("Tapahtui virhe!");
                                }
                                else
                                {
                                        
                                }
                            });
                        }, 50);
                                           
                      
                        //Tarkista(kannasta_lyh,iframesta_lyh);
                    
                        //Tarkistaa tehtävän ja antaa palautteen alerttina, Vaihdetaan niin että muutos näkyy "AJA" napissa
                        /*
                     
                        */
                        
                            
                        /*    
                            $.ajax({
                              url:  "output_result.php",  
                              success: function(response){
                                  
                                  //kun Ajax-toinito on onnistunut  
                                  //parsitaan stringit
                                  kannasta   = new String(response);
                                  iframesta  = new String(iframe_kayttajan_vastaus);
                                  
                                  kannasta_lyh  = kannasta.substring(0, kannasta.length);
                                  iframesta_lyh = iframesta.substring(0,kannasta.length);
                                  
                                  console.log(kannasta);
                                  console.log(iframesta_lyh);
                                  Tarkista(kannasta_lyh,iframesta_lyh);
                                  
                             }});
                             
                             
                        }});
                       */
                       $("#eteenpain_button").click(function() {  
                            Tarkista(kannasta_lyh,iframesta_lyh);
                           
                        });                    

                });          
         
            });
            
            </script>
            <script>
                 $(document).ready(function() {             
                    
                    $("#reset_button").click(function() {                        
                        //muutetaan niin, että putsataan output ikkuna ja 
                        /*
                        var output_ikkuna = document.getElementById('output_ikkuna'); 
                           
                        $("#output_ikkuna").html("<iframe></iframe>");  
                        output_ikkuna.src = "";  
                        */
                        $("#eteenpain_button").hide();
                        var frame = document.getElementById("output_ikkuna"),
                        frameDoc = frame.contentDocument || frame.contentWindow.document;
                        frameDoc.documentElement.innerHTML = "";
                       
                                                
                        //editori 
                        editor.setValue("document.write"); 
                        
                    });
                    
                
                 
            });
            </script>    
       
        
        <!--Output class-->
       
        
        <div id="output_yla">
            Outputin ylä
        </div>
            
        <!--result.php echottaa tekstitiedoston sisällön iframeen-->   
        <iframe id="output_ikkuna" name="result" frameborder='0' src="php/result.php" ></iframe>
        
         
        
           
        
       
        <!--Output loppuu-->
        
            
             
             
             <article id="ohjeet">
				
				<?php
				include("php/vihjehaku.php");
				?>
				<!--
                 Vinkki: "Sed ut perspiciatis unde omnis iste natus error sit voluptatem 
                 accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab 
                 illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.
                 <br>
                 Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit,
                 sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt." 
                -->
             
                 
             </article>    
             <div id="clear"> </div>
              
            </section>
             
             <footer id="footer">
                 <p> Copyright Koodiakatemia </p>
                 
             </footer>     
        <!--wrapper loppuu-->
       </div>
       
    </body>
</html>
