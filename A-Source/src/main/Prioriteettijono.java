/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Tontsu
 */
public class Prioriteettijono {
    
    private final int alkukapasiteetti;
    private Solmu[] jono;
    private int häntäosoitin = 0;
    
    /**
     * Luo uuden prioriteettijonon.
     * @param kapasiteetti Antaa jonolle aloituskapasiteetin.
     */
    public Prioriteettijono(int kapasiteetti) {
        alkukapasiteetti = kapasiteetti;
        jono = new Solmu[alkukapasiteetti];
    }
    
//    private void järjestä() {
//        int koko = häntäosoitin;
//        for (int k = koko/2; k >= 1; k--) { 
//            vajota(k, koko);
//        }
//        while(koko > 1) {
//            vaihda(1, koko--); 
//            vajota(1, koko);
//        }  
//    }
    
    private void vajota(int k) {
        while (2*k < häntäosoitin-1) {
            int j = 2*k;
            if(j < häntäosoitin && onkoPienempi(j, j+1)) {
                j++;
            }
            if(!onkoPienempi(k, j)) {
                break;
            }
            vaihda(k, j);
            k = j;
        }
    }
    
    private void vaihda(int i, int j) {
        Solmu vaihdettava = jono[i];
        jono[i] = jono[j];
        jono[j] = vaihdettava;
    }
    
    private boolean onkoPienempi(int i, int j) {
        if (jono[i] == null) {
            return false;
        }
        return jono[i].compareTo(jono[j]) < 0;
    }
    
    private void kekoile(int k) {
        while (k > 0 && onkoPienempi(k/2, k)) {
            vaihda(k, k/2);
            k = k/2;
        }
    }
    
    /**
     * Palauttaa tiedon, onko jono tyhjä.
     * @return True jos on tyhjä. Muuten false.
     */
    public boolean onkoTyhjä() {
        if(häntäosoitin == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Lisää uuden solmun jonoon.
     * @param solmu Lisättävä solmu.
     */
    public void lisää(Solmu solmu) {
        if(häntäosoitin == jono.length) {
            kasvataJonoa();
        } 
        jono[häntäosoitin] = solmu;
        kekoile(häntäosoitin);
        häntäosoitin++;
    }
    
    /**
     * Poistaa jonon ensimmäisen solmun.
     * @return Poistettu solmu.
     */
    public Solmu otaPienin() {
        Solmu poistettava = jono[0];
        vaihda(0, häntäosoitin-1);
        jono[häntäosoitin-1] = null;
        häntäosoitin--;
        vajota(0);
        
        
        
        return poistettava;
    }
    
    /**
     * Palauttaa jonon ensimmäisen solmun.
     * @return Palautettava solmu
     */
    public Solmu palautaPienin() {
        return jono[0];
    }
    
    /**
     * Palauttaa jonon tämänhetkisen kokonaiskapasiteetin.
     * @return Jonon kapasiteetti.
     */
    public int jononKoko() {
        return jono.length;
    }
    
    private void kasvataJonoa() {
        Solmu[] apujono = new Solmu[jono.length*2];
        for(int i = 0; i < jono.length; i++) {
            apujono[i] = jono[i];
        }
        jono = apujono;
    }
    
    public boolean kekoehto() {
        return tarkistaKekoehto(1);
    }
    
    private boolean tarkistaKekoehto(int k) {
        if (k > häntäosoitin) { 
            return true;
        }
        int vasen = 2*k;
        int oikea = 2*k+1;
        if(vasen <= häntäosoitin && onkoPienempi(k, vasen)) {
            return false;
        }
        if(oikea <= häntäosoitin && onkoPienempi(k, oikea)) {
            return false;
        }
        return tarkistaKekoehto(vasen) && tarkistaKekoehto(oikea);
        
    }
    public void print() {
        System.out.println(häntäosoitin);
        for (int i = 0; i < jono.length; i++) {
            System.out.println(i + " " + jono[i]);
        }
    } 
}
