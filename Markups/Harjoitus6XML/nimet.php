<?php
   /*nimet.php tulostaa dokumentista kirjasto.xml kirjojen nimet allekkain*/
   
   /*Ladataan tiedosto kirjasto.xml oliorakenteeseen simplexml_load_file()  - funktiolla  ja
       sijoitetaan olio muuttujaan $xml*/
   $xml = simplexml_load_file("kirjasto.xml");
   /*Foreach on kätevä  oliorakenteen käsittelyssä. 
     Poimitaan jokainen dokumentin kirja-elementti muuttujaan $kirja  
     ja tulostetaan jokaisen kirja-elementin lapsielementti nimi*/   
   foreach($xml->kirja as $kirja) {  
	  echo $kirja->nimi."<br />";
	  }
?>
