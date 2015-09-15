/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author Kari
 */
public class Vihollinen extends Hahmo
{
    
    
    public Vihollinen(String nimi,int hitpoints,int defence,int power,int points)
    {
        this.setNimi(nimi);
        this.setHitpoints(hitpoints);
        this.setDefence(defence);
        this.setPower(power);
        this.setPoints(points);   
    }
    
    public void lyo(Hahmo h)
    {
        Random generator = new Random();
        //arvotaan numero 1-6
        int roll = generator.nextInt(2) + 1;
        //lopullinen vahinko on arvonta + hahmon power
        int finaldamage = (roll + this.getPower());
        //asetetaan hitpointsit, tämän hp - finaldamage, josta vähennetään defence
        h.setHitpoints(h.getHitpoints() - (finaldamage -  h.getDefence()));
        if(h.getHitpoints() <= 0)
        {
            h.setAlive(false);
        }
        
    }
}