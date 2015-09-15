
        <?php
        //$heitot = array();
        
        /**
        *
        * ottaa heittojen lukumäärän, arpoo luvut ja 
        * palauttaa niistä arrayn
        * @param int $heittojenlkm
        * @return array
        */
        function Noppa($heittojenlkm)
        {
            $heitot = array();
            for($i = 0;$i <= $heittojenlkm;$i++)
            {
                $numero = rand(1, 6);
                array_push($heitot, $numero);
            }
            return $heitot;
        }
        //     
        /**
        *
        * palauttaa suurimman arvotun luvun 
        * @param array $heitot
        * @return int
        */
        function GetSuurin($heitot)
        {
            return max($heitot);
        }        
        //
        /**
        *      
        * palauttaa pienimmän arvotun luvun
        * @param array $heitot
        * @return int
        */
        function GetPienin($heitot)
        {
            return min($heitot);
        }        
        //       
        /**
        *     
        * palauttaa heittojen keskiarvon 
        * @param array $heitot
        * @return int
        */
        function GetKeskiarvo($heitot)
        {
            return array_sum($heitot) / count($heitot);
        }
        ?>

