<?php

session_start();

if(!isset($_SESSION['sess_user_id']) || (trim($_SESSION['sess_user_id']) == '')) {
	header("location: kirjaudu.php");
	exit();
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

        <title>Tehtävävalikko</title>

        <!-- Bootstrap core CSS --> 
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
 
        <!-- Custom styles for this template -->
        <link href="css/dashboard.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy this line! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="tehtavavalikko.php">Koodiakatemia</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="tehtavavalikko.php">Tehtävävalikko</a></li>
                        <li><a href="profile.php">Profiili</a></li>
                        <li><a href="php/logout.php"><span class="glyphicon glyphicon-off"></span></a></li>
                    </ul>
                    <form class="navbar-form navbar-right">
                        <input type="text" class="form-control" placeholder="Etsi...">
                    </form>
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar" style="padding-top: 100px;">

                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Tervetuloa, <?php echo $_SESSION['sess_username'] ?>!</h1>

                    <h2 class="sub-header">JavaScript tehtävät</h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Tehtävä</th>
                                    <th>Osiossa</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Ensimmäinen ohjelmasi! Simppeli 'Hello World':n tulostus.</td>
                                    <td>JavaScript perusteet</td>
                                    <td><a href="editor.php?id=1" class="btn btn-primary" role="button">Tehtävään &raquo;</a></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>IPSUM TEHTÄVÄ</td>
                                    <td>JavaScript perusteet</td>
                                    <td><a href="try_it_editor/editor.php?id=2" class="btn btn-primary" role="button">Tehtävään &raquo;</a></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Integer</td>
                                    <td>JavaScript perusteet</td>
                                    <td><a href="#" class="btn btn-primary" role="button">Tehtävään &raquo;</a></td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td>libero</td>
                                    <td>JavaScript perusteet</td>
                                    <td><a href="#" class="btn btn-primary" role="button">Tehtävään &raquo;</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/docs.min.js"></script>
    </body>
</html>
