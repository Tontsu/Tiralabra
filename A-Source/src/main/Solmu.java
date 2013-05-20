/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *Luokka, joka sisältää noodin tiedot.
 * @author Tontsu
 */

public class Solmu {
    
    private final int x;
    private final int y;
    private int alkuetäisyys;
    private int maalietäisyys;
    Solmu isäntä;
    
   public Solmu (int y, int x) {
         this.x = x;
         this.y = y;
    }
    
    public Solmu (int y, int x, int alku, int maali, Solmu isäntä) {
         this.x = x;
         this.y = y;
         this.alkuetäisyys = alku;
         this.maalietäisyys = maali;
         this.isäntä = isäntä;
    }
    
    public void setAlku(int alku) {
        this.alkuetäisyys = alku;
    }
    
    public void setMaali(int maali) {
        this.maalietäisyys = maali;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public Solmu getIsäntä() {
        return isäntä;
    }

    public int getAlku() {
        return alkuetäisyys;
    }

    public int getMaali() {
        return maalietäisyys;
    }
    
    @Override
    public boolean equals(Object o) {
        Solmu vertailunoodi = (Solmu) o;
        if(x == vertailunoodi.getX() && y == vertailunoodi.getY() && alkuetäisyys == vertailunoodi.getAlku() && maalietäisyys == vertailunoodi.getMaali()) {
            return true;
        }
        return false;
    }
    
}
