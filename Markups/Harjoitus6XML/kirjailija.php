<?php
   /*kirjailija.php tulostaa dokumentista kirjasto.xml ensimmäisen kirjan kirjailijan*/
   
   /*Ladataan tiedosto kirjasto.xml oliorakenteeseen simplexml_load_file()  - funktiolla  ja
       sijoitetaan olio muuttujaan $xml*/
   $xml = simplexml_load_file("kirjasto.xml");
   //Ensimmäisen kirjan indeksi on 0. Olioviittaukset tehdään -> -merkillä.
   echo $xml->kirja[0]->kirjailija;
?>
