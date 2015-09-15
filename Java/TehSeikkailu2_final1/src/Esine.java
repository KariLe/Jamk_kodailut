/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kari
 */
public class Esine {
    private String nimi;
    private int power;
    private int defence;
    private String description;
    private int points;    
    
    public Esine(String nimi, int power, int defence, String description, int points)
    {
        this.nimi = nimi;
        this.power = power;
        this.defence = defence;
        this.description = description;
        this.points = points;
        
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
        this.power = power;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    
}
