<?php

//header('charset=utf-8');
ob_start();
session_start();

// Grab User submitted information
$username = $_POST["username"];
$pass = $_POST["password"];

// Connect to the database
$con = mysql_connect("localhost", "root", "");
// Make sure we connected succesfully
if (!$con) {
    die('Connection Failed' . mysql_error());
}

// Select the database to use
mysql_select_db("koodiakatemia", $con);

$result = mysql_query("SELECT kayttaja, kayttajanimi, salasana FROM Kayttaja WHERE kayttajanimi = '$username'");
$row = mysql_fetch_array($result, MYSQL_ASSOC);

if ($row["kayttajanimi"] == $username && $row["salasana"] == $pass) {
    session_regenerate_id();
    $_SESSION['sess_user_id'] = $row['kayttaja'];
    $_SESSION['sess_username'] = $row['kayttajanimi'];
    session_write_close();
    header('Location: ../tehtavavalikko.php');
    exit;
} else {
    echo "<script language=\"JavaScript\">\n";
    echo "alert('Annetut tiedot virheellisiä!');\n";
    echo "window.location='kirjaudu.php'";
    echo "</script>";
}
?>