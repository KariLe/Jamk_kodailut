/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Tehtava9;

/**
 *
 * @author Kari
 */
public class TietoKasittelija {
    
    private String nimi;
    private String osoite;
    private String kotikunta;
    private String email;
    
    public TietoKasittelija()
    {
        nimi = null;
        osoite = null;
        kotikunta = null;
        email = null;
    }

    /**
     * @return the nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * @param nimi the nimi to set
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * @return the osoite
     */
    public String getOsoite() {
        return osoite;
    }

    /**
     * @param osoite the osoite to set
     */
    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    /**
     * @return the kotikunta
     */
    public String getKotikunta() {
        return kotikunta;
    }

    /**
     * @param kotikunta the kotikunta to set
     */
    public void setKotikunta(String kotikunta) {
        this.kotikunta = kotikunta;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
