
import java.util.ArrayList;
import java.util.Vector;
import java.util.Random;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kari
 */
public class Hahmo {
    private String nimi;
    private int power;
    private int defence;
    private int hitpoints;
    private int points;
    private boolean alive;
    private Vector h_vecItems;
    ArrayList esineetArray = new ArrayList(); 
    
    public Hahmo()
    {
        this.alive = true;
        this.nimi = "";
        this.hitpoints = 10;
        this.power = 1;
        this.defence = 1;
        this.points = 0;
        
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = this.points + points;
    }
    
    
    
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = this.power + power;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = this.defence + defence;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public ArrayList getEsineetArray() {
        return esineetArray;
    }

    public void setEsineetArray(Object esine) {
        this.esineetArray.add(esine);
    }

    public void setH_vecItems(Vector h_vecItems) {
        this.h_vecItems = h_vecItems;
        
    }

    public boolean getAlive() {
        return alive;
    }
    
    
    
    public void lyo(Vihollinen v)
    {
        Random generator = new Random();
        //arvotaan numero 1-6
        int roll = generator.nextInt(6) + 1;
        //lopullinen vahinko on arvonta + hahmon power
        int finaldamage = (roll + this.getPower());
        //asetetaan hitpointsit, tämän hp - finaldamage, josta vähennetään defence
        v.setHitpoints(v.getHitpoints() - (finaldamage -  v.getDefence()));
        
        if(v.getHitpoints() <= 0)
        {
            v.setAlive(false);
            
        }
        
        
    }
    
    
}
