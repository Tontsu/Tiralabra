/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokka, joka sisältää solmun tiedot.
 * @author Tontsu
 */

public class Solmu implements Comparable {
    
    private final int x;
    private final int y;
    private int alkuetäisyys;
    private int maalietäisyys;
    Solmu isäntä;
    
    /**
     * Konstruktori, jolle annetaan vain solmun koordinaatit.
     * @param y Solmun Y-koordinaatti.
     * @param x Solmun X-koordinaatti.
     */
    public Solmu (int y, int x) {
         this.x = x;
         this.y = y;
    }
    
    /**
     * Konstruktori, jolle annetaan koordinaattien lisäksi tiedot oletetusta etäisyydestä. 
     * @param y Solmun Y-koordinaatti.
     * @param x Solmun X-koordinaatti.
     * @param alku Oletettu etäisyys aloitussolmuun.
     * @param maali Oletettu etäisyys maalisolmuun.
     * @param isäntä Solmun isäntäsolmu.
     */
    public Solmu (int y, int x, int alku, int maali, Solmu isäntä) {
         this.x = x;
         this.y = y;
         this.alkuetäisyys = alku;
         this.maalietäisyys = maali;
         this.isäntä = isäntä;
    }
    
    /**
     * Asettaa solmulle oletetun etäisyyden aloitussolmuun, jos ei vielä ole asetettu.
     * @param alku Oletettu etäisyys aloitussolmuun.
     */
    public void setAlku(int alku) {
        this.alkuetäisyys = alku;
    }
    
    /**
     *Asettaa solmulle oletetun etäisyyden aloitussolmuun, jos ei vielä ole asetettu.
     * @param maali Oletettu etäisyys maalisolmuun.
     */
    public void setMaali(int maali) {
        this.maalietäisyys = maali;
    }
    
    /**
     * Palauttaa solmun X-koordinaatin.
     * @return X-koordinaatti.
     */
    public int getX() {
        return x;
    }
    
    /**
     * Palauttaa solmun Y-koordinaatin.
     * @return Y-koordinaatti.
     */
    public int getY() {
        return y;
    }

    /**
     * Palauttaa solmun isäntäsolmun
     * @return Isäntäsolmu.
     */
    public Solmu getIsäntä() {
        return isäntä;
    }

    /**
     * Palautaa solmun oletetun etäisyyden aloitussolmusta.
     * @return Etäisyys aloitussolmusta.
     */
    public int getAlku() {
        return alkuetäisyys;
    }

    /**
     * Palauttaa solmun oletetun etäisyyden maalisolmusta.
     * @return Etäisyys maalisolmusta.
     */
    public int getMaali() {
        return maalietäisyys;
    }
    
    /**
     * Vertailee kahta solmuoliota.
     * @param o Vertailtava solmu. 
     * @return Mikäli solmut ovat samat niin palauttaa truen.
     */
    @Override
    public boolean equals(Object o) {
        Solmu vertailusolmu = (Solmu) o;
        if(x == vertailusolmu.getX() && y == vertailusolmu.getY() && alkuetäisyys == vertailusolmu.getAlku() && maalietäisyys == vertailusolmu.getMaali()) {
            return true;
        }
        return false;
    }
    /**
     * Palauttaa String-esityksen solmuoliosta.
     * @return Olion String-esitys.
     */
    @Override
    public String toString() {
        if(this.isäntä == null) {
            return this.x + " " + this.y + " " + this.alkuetäisyys + " " + this.maalietäisyys + " " + "null";
        }
        return this.x + " " + this.y + " " + this.alkuetäisyys + " " + this.maalietäisyys + " " + this.isäntä.hashCode();
    }

    /**
     * Laskee kahden solmun etäisyydet aloitussolmusta ja maalisolmusta yhteen. 
     * Vertailee kahden solmun yhteenlaskun tulosta ja palauttaa tiedon, kumpi solmuista on lähempänä maalia.
     * @param t Vertailusolmu.
     * @return Palauttaa 0:n, jos solmut ovat yhtä kaukana. Palauttaa 1:n, jos tämä solmu on lähempänä maalia.
     * Muuten -1.
     */
    @Override
    public int compareTo(Object t) {
        Solmu vertailusolmu = (Solmu) t;
        if(vertailusolmu == null) {
            return 1;
        }
        int vertailtava = vertailusolmu.alkuetäisyys + vertailusolmu.maalietäisyys;
        int tämäSolmu = alkuetäisyys + maalietäisyys;
        
        if(vertailtava == tämäSolmu) {
            return 0;
        }
        else if(vertailtava > tämäSolmu) {
            return 1;
        }
        else
        return -1;
    }
}
