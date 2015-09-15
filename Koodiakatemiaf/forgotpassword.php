<?php
session_start();
include "connect.php"; //connects to the database
if (isset($_POST['username'])) {
    $username = $_POST['username'];
    $query = "select * from kayttaja where kayttajanimi='$username'";
    $result = mysql_query($query);
    $count = mysql_num_rows($result);
    // If the count is equal to one, we will send message other wise display an error message.
    if ($count == 1) {
        $rows = mysql_fetch_array($result);
        $pass = $rows['salasana']; //FETCHING PASS
        //echo "your pass is ::".($pass)."";
        $to = $rows['email'];
        //echo "your email is ::".$email;
        //Details for sending E-mail
        $from = "Koodiakatemia";
        $url = "http://www.ticorporate.com/";
        $body = "Koodiakatemian unohtunut salasana
        -----------------------------------------------
        Url: $url;
        Sähköposti: $to;
        Salasana: $pass;
        Terveisin,
        Koodiakatemia";
        $subject = "Koodiakatemia salasanan palautus";
        $headers1 = "Lähettäjä: $from\n";
        $headers1 .= "Content-type: text/html;charset=iso-8859-1\r\n";
        $headers1 .= "X-Priority: 1\r\n";
        $headers1 .= "X-MSMail-Priority: High\r\n";
        $headers1 .= "X-Mailer: Just My Server\r\n";
        $sentmail = mail($to, $subject, $body, $headers1);
    } else {
        if ($_POST ['email'] != "") {
            echo "<span style='color: #ff0000;'> Not found your email in our database</span>";
        }
    }
    //If the message is sent successfully, display success message otherwise display an error message.
    if ($sentmail == 1) {
    echo "<script language=\"JavaScript\">\n";
    echo "alert('Salasana palautettu!');\n";
    echo "window.location='kirjaudu.php'";
    echo "</script>";
    } else {
        if ($_POST['email'] != "")
            echo "<span style='color: #ff0000;'> Salasanaa ei lähetetty.</span>";
    }
}
?>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

        <title>Home</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/cover.css" rel="stylesheet">
        <link href="css/jumbotron.css" rel="stylesheet">
        <link href="css/signin.css" rel="stylesheet">
        
        
        <!-- Just for debugging purposes. Don't actually copy this line! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <div class="site-wrapper">

            <div class="site-wrapper-inner">

                <div class="cover-container">

                    <div class="masthead clearfix">
                        <div class="inner">
                            <h3 class="masthead-brand">Koodiakatemia</h3>
                            <ul class="nav masthead-nav">
                                <li><a href="index.html">Etusivu</a></li>
                                <li><a href="register.php">Rekisteröinti</a></li>
                                <li><a href="otayhteytta.html">Ota yhteyttä</a></li>
                                <li><a href="kirjaudu.php">Kirjaudu sisään</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="inner cover">
                        <div class="jumbotron">
                            <form class="form-signin" action="" method="post">
                                <h2 class="form-signin-heading">Salasanan palautus</h2>
                                <label> Syötä käyttäjätunnuksesi: </label>
                                <input class="form-control" type="text" name="username" />
                                <p></p>
                                <button class="btn btn-lg btn-default btn-block" type='submit'>Lähetä</button>
                            </form>

                        </div>

                    </div>

                    <div class="mastfoot">
                        <div class="inner">
                            <p>Koodiakatemia, 2014</p>
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="../../dist/js/bootstrap.min.js"></script>
        <script src="../../assets/js/docs.min.js"></script>
    </body>
</html>
