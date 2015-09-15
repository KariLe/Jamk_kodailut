<?php


//data tiedostoon
if (!empty($_POST['data']))
{
    $fp = fopen("tdsto.txt", 'w');
    $content = $_POST['data'];
    fwrite($fp, $content);
    fclose($fp);
}
//data ulos tiedostosta
$fo = fopen("tdsto.txt", 'r');
$content2 = fread($fo, filesize("tdsto.txt"));
echo "Tiedostossa lukee:<br /> ".$content2;



?>