<?php
/* 
 * Tarvitaan funktiot:
 * 
 * (ohjehaku.php)
 * haeOhje()
 * Hakee ohjeen kannasta iframeen
 * 
 * (result.php)
 * Löytyy js functiona js_functions.js tiedostosta
 * 
 * 
 * (write.php)
 * kirjoitaVastausTiedostoon()
 * kirjoittaa käyttäjän inputin tiedostoon tdsto.txt
 * 
 * (output_result.php)
 * haeOikeaVastaus()
 * hakee kannasta tehtävän oikean vastauksen, johon voidaan verrata annettua
 *  
 */
  header('Content-Type: text/html; charset=utf-8');
  $dbhost = 'localhost';
  $dbuser = 'root';
  $dbpass = '';
  $mysql_enable_utf8 = 1;
  $conn = mysql_connect($dbhost, $dbuser, $dbpass, $mysql_enable_utf8);              

function haeOhje($conn)
{
                
                if(! $conn )
                {
                  die('Ei voitu yhdistää: ' . mysql_error());
                }

                
                $sql = 'SELECT tehtavananto FROM Tehtava';

                mysql_select_db('koodiakatemia');
                $retval = mysql_query( $sql, $conn);
                
                if(! $retval )
                {
                  die('Ei saatu dataa: ' . mysql_error());
                }
                while($row = mysql_fetch_assoc($retval))
                {
                    echo $row['tehtavananto'];                    
                } 
                
                mysql_close($conn);
                //Hakee ohjeen tietokannasta
    
}

function kirjoitaVastausTiedostoon()
{
                $fp = fopen("tdsto.txt", 'w');
                $content1 = $_GET['code'];
                fwrite($fp, $content1);
                fclose($fp);
                //header("Location: result.php");

                //Tallentaa käyttäjän editoriin antaman vastauksen tiedostoon.
    
}

function haeOikeaVastaus($conn)
{
 
                if(! $conn )
                {
                 die('Ei voitu yhdistää: '.mysql_error());
                }               
                $sql = 'SELECT oikea_vastaus FROM Tehtava WHERE tehtava=2';
                mysql_select_db('demo');
                $retval = mysql_query( $sql, $conn );
                if(! $retval )
                {
                 die('Ei saatu dataa: '.mysql_error());
                }
                while($row = mysql_fetch_assoc($retval))
                {
                 echo $row['oikea_vastaus'];
                }                
                mysql_close($conn);
                //Hakee oikean vastauksen (tulostuksen) tietokannasta
    
}
?>
