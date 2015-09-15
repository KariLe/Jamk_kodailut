<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        include 'funktiot.php';
        $heittoja = 10;
        
        list($a,$b,$c,$d,$e,$g,$h) = Noppa($heittoja);       
        print "Heitot:"."<br>";
        var_dump($a);
        var_dump($b);
        var_dump($c);
        var_dump($d);
        var_dump($e);
        var_dump($g);
        var_dump($h);
        
        print "Suurin luku:"."<br>";
        $suurin = GetSuurin(Noppa($heittoja));
        var_dump($suurin);
   
        print "Pienin luku:"."<br>";
        $pienin = GetPienin(Noppa($heittoja));
        var_dump($pienin);
        
        print "Keskiarvo:"."<br>"; 
        $kesk = GetKeskiarvo(Noppa($heittoja));
        var_dump($kesk);
        ?>
 </body>
</html>