<?php

// Connect to the database
$con = mysql_connect("localhost", "root", "");
// Make sure we connected succesfully
if (!$con) {
    die('Connection Failed' . mysql_error());
}

// Select the database to use
mysql_select_db("koodiakatemia", $con);

function NewUser() {
    $fullname = $_POST['name'];
    $userName = $_POST['user'];
    $email = $_POST['email'];
    $password = $_POST['pass'];
    $query = "INSERT INTO kayttaja (kayttajanimi,email,nimi,salasana) VALUES ('$userName','$email','$fullname','$password')";
    $data = mysql_query($query) or die(mysql_error());
    if ($data) {
    header('Location: ../kirjaudu.php');
    }
    else {
        echo "Something went wrong";
    }
}

function SignUp() {
    if (!empty($_POST['user'])) {
        $query = mysql_query("SELECT * FROM kayttaja WHERE kayttajanimi = '$_POST[user]' AND salasana = '$_POST[pass]'") or die(mysql_error());

        if (!$row = mysql_fetch_array($query) or die(mysql_error())) {
            NewUser();
        } else {
            echo "Talla nimella on jo rekisteroity.";
        }
    }
}

if (isset($_POST['submit'])) {
    SignUp();
}
?>
