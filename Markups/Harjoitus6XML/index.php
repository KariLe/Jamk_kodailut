<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        if (file_exists('kirjasto.xml')) {
       
        
        $content = utf8_encode(file_get_contents('kirjasto.xml'));
        $xml = simplexml_load_string($content);
        
        
        $xml=simplexml_load_file("kirjasto.xml");
        /*
        echo "<table border=1>";
        echo $xml->kirja."<br>";
        echo "<tr>";
            echo "<td>"."kirjannimi";
            echo "<td>"."kirjailija";    
            echo "<td>"."sukupuoli";
            echo "<td>"."kuvaus";             
        echo "</tr>";
        echo "<tr>";
            echo "<td>".$xml->kirja[0]->nimi;
            echo "<td>".$xml->kirja[0]->kirjailija;   
            echo "<td>".$xml->kirja[0]->kirjailija->attributes();
            echo "<td>".$xml->kirja[0]->kuvaus; 
        echo "</tr>";
        echo "<tr>";    
            echo "<td>".$xml->kirja[1]->nimi;
            echo "<td>".$xml->kirja[1]->kirjailija;
            echo "<td>".$xml->kirja[1]->kirjailija->attributes();
            echo "<td>".$xml->kirja[1]->kuvaus; 
        echo "</tr>";
        echo "<tr>";    
            echo "<td>".$xml->kirja[2]->nimi;
            echo "<td>".$xml->kirja[2]->kirjailija;
            echo "<td>".$xml->kirja[2]->kirjailija->attributes();
            echo "<td>".$xml->kirja[2]->kuvaus; 
        echo "</tr>";
        echo"</table>";
        
        
        */
       
      
        echo"<table border=1>";    
        
        echo "<tr>";
            echo "<td>"."kirjannimi";
            echo "<td>"."kirjailija";    
            echo "<td>"."sukupuoli";
            echo "<td>"."kuvaus";             
        echo "</tr>";
        
            for($i = 0; $i < count($xml->kirja) ;$i++)
            {
                echo "<tr>";  
                echo "<td>".$xml->kirja[$i]->nimi;
                echo "<td>".$xml->kirja[$i]->kirjailija;
                echo "<td>".$xml->kirja[$i]->kirjailija->attributes();
                echo "<td>".$xml->kirja[$i]->kuvaus; 
                echo "</tr>";
                
            }
        echo"</table>";
       
        } else {
            exit('Failed to open test.xml.');
        }
        ?>
    </body>
</html>
