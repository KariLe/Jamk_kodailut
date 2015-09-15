<?php
//vaihdetaan että kirjoitetaan kantaan
$fp = fopen("tdsto.txt", 'w');
$content = $_GET['code'];
fwrite($fp, $content);
fclose($fp);
//header("Location: result.php");
?>
