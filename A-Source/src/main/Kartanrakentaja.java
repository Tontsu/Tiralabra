/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * Kartanrakentaja täyttää halutunkokoisen taulukon valmiiksi tyhjää ilmaisevilla merkeillä.
 * Kartanrakentajalla voi lisätä esteitä haluttuihin koordinaatteihin.
 * @author Tontsu
 */
public class Kartanrakentaja {
    
    private char[][] kartta;
    /**
     * Konstruktori luo halutunkokoisen kartan ja täyttää sen tyhjällä.
     * @param y Kartan pituus.
     * @param x Kartan leveys.
     */
    public Kartanrakentaja(int y, int x) {
        kartta = new char[y][x];
        for(int i = 0; i < kartta.length; i++) {
            for(int j = 0; j < kartta[0].length; j++) {
                kartta[i][j] = '.';
            }
        }
    }
    /**
     * Asettaa esteen koordinaatteihin.
     * @param y
     * @param x 
     */
    public void asetaEste(int y, int x) {
        kartta[y][x] = '#';
    }
    
    /**
     * Palauttaa rakennetun kartan.
     * @return Rakennettu kartta.
     */
    public char[][] getKartta() {
        return kartta;
    }
    /*
     * Tulostaa kartan ruudulle.
     */
    public void tulostaKartta() {
        for(int i = 0; i < kartta.length; i++) {
            System.out.println("");
            for (int j = 0; j <  kartta[0].length; j++) {
                System.out.print(kartta[i][j]);
            }
        }
    }
    
}
