<?php 
$dbhost = 'localhost';
$dbuser = 'root';
$dbpass = '';
$conn = mysql_connect($dbhost, $dbuser, $dbpass);
if(! $conn )
{
 die('Ei voitu yhdistää: '.mysql_error());
}               
$sql = 'SELECT oikea_vastaus FROM oikeat_vastaukset WHERE oikeat_vastaukset=1';
mysql_select_db('koodiakatemia');
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
?>
