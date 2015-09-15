<!DOCTYPE html>
<!--Itsensä suorittava funktio, jolla käyttäjän editoriin antama koodi tulostetaan iframeen -->
<html>
    <head>    
        <script type='text/javascript'>
            (function() { 
                <?php echo file_get_contents('tdsto.txt')?>                
                })();
        </script>
    </head>
    <body>

    </body>
</html>
