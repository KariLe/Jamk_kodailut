
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

        <title>Rekisteröidy</title>

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
                                <li class="active"><a href="register.php">Rekisteröinti</a></li>
                                <li><a href="otayhteytta.html">Ota yhteyttä</a></li>
                                <li><a href="kirjaudu.php">Kirjaudu sisään</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="inner cover">


                        <div class="jumbotron">
                            <form class="form-signin" role="form" method="post" action="php/signup.php">
                                <h2 class="form-signin-heading">Rekisteröidy</h2>
                                <input type="text" name="name" class="form-control" placeholder="Nimi" required autofocus>
                                <input type="text" name="email" class="form-control" placeholder="Toimiva sähköposti" required>
                                <input type="text" name="user" class="form-control" placeholder="Käyttäjänimi" required>
                                <input type="password" name="pass" class="form-control" placeholder="Salasana" required>
                                <button class="btn btn-lg btn-default btn-block" name="submit" type="submit">Rekisteröidy</button>
                            </form>
                            <!-- <fieldset style="width:30%"><legend>Rekisteröityminen:</legend>
                                 <form  id="form2" name="form2" method="post" action="signup.php">
                                     <table width="400" border="0" align="center">
                 
                                         <tr>
                                             <td> <input type="text" name="name" placeholder="Nimi" required></td>
                                         </tr>
                                         <tr>
                                             <td> <input type="text" name="email" placeholder="Toimiva sähköposti"></td>
                                         </tr>
                                         <tr>
                                             <td> <input type="text" name="user" placeholder="Käyttäjänimi" required></td>
                                         </tr>
                                         <tr>
                                             <td> <input type="password" name="pass" placeholder="Salasana" required></td>
                                         </tr>
                 
                                         <td><input id="submitbutton" type="submit" name="submit" value="Rekisteröidy!"></td>
                 
                                     </table>
                                 </form>
                             </fieldset>-->
                        </div> <!-- /jumbotron -->

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
