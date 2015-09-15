<?php
/*attribuutit.php tulostaa allekkain kirjailijat ja heidän sukupuolensa*/
//Ladataan kirjasto.xml oliorakenteeseen
   $xml = simplexml_load_file("kirjasto.xml");
//attributes() -funktiolla voidaan tulostaa attribuutit
   foreach($xml->kirja as $kirja) {
      echo $kirja->kirjailija." on ".$kirja->kirjailija->attributes().".<br />";
   }
?>
