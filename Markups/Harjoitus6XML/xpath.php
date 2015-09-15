<?php
   /*xpath.php hakee kaikki kirjailijat xpath() -funktion avulla. 
           Haussa käytetään xpathin syntaksia*/
   
   $xml = simplexml_load_file("kirjasto.xml");
   $kirjailijat = $xml->xpath("/kirjasto/kirja[kirjailija = 'J.K.Rowling']");
   foreach($kirjailijat as $kirjailija) {
      echo $kirjailija->nimi ."<br />";
   }
?>
