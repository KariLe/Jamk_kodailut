/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Tehtava11;

/**
 *
 * @author Kari
 */
import static java.lang.System.out;
import java.util.Random;

public class Noppa {
  
    private int summa = 0;
    private int tulos = 0;
    private int heitot = 0;
    private int heittojen_keskiarvo;
    private Random rand = new Random();

   //palauttaa noppien summan
    public int getSumma() {
        return summa; 
    }
    //Palauttaa tuloksen
    public int getTulos() {
        return tulos; 
    }
    //palauttaa heittojen lukumäärän
    public int getHeitot()
    {
        return heitot;
    }
    
    //palauttaa keskiarvon
    public int getKeskiarvo()
    {
        if(heitot > 0)
        {
            this.heittojen_keskiarvo = summa / heitot;
            return heittojen_keskiarvo;
        }
        else
        {
            out.println("ei voi jakaa nollalla!");
            return heitot;
        }
        
        
        
    }
    
    //metodi heitolle
    public void heita() {
    this.tulos = rand.nextInt(6)+1;
    this.summa+=tulos;
    this.heitot = heitot + 1;
    }

    //metodi summan ja heittojen sekä keskiarvon nollaukselle
    public void nollaa() {
    this.summa = 0;
    this.heitot = 0;
    //this.heittojen_keskiarvo = 0;
    }
    
}

