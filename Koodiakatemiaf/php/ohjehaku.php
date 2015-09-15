<?php
                 
                header('Content-Type: text/html; charset=utf-8');
                $dbhost = 'localhost';
                $dbuser = 'root';
                $dbpass = '';
                $mysql_enable_utf8 = 1;
                $conn = mysql_connect($dbhost, $dbuser, $dbpass, $mysql_enable_utf8);
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
?>