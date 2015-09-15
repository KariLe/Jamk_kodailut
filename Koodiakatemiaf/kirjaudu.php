
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
                                <li class="active"><a href="kirjaudu.php">Kirjaudu sisään</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="jumbotron">

                        <form class="form-signin" role="form" method="post" action="php/login.php">
                            <h2 class="form-signin-heading">Kirjaudu sisään</h2>
                            <input type="text" name="username" class="form-control" placeholder="Käyttäjänimi" required autofocus>
                            <input type="password" name="password" class="form-control" placeholder="Salasana" required>
                            <label class="checkbox">
                                <input type="checkbox" value="remember-me"> Remember me (Coming soon..)
                            </label>                                  
                            <button class="btn btn-lg btn-default btn-block" type="submit">Kirjaudu sisään</button>
                            <label style="padding-top: 20px;">
                                <a href="forgotpassword.php">Unohditko salasanasi?</a>
                            </label>
                        </form>
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