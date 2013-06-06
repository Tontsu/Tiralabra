/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *Reitinhakulogiikan luokka. A*- ja Dijkstra-toteutus.
 * Etsii lyhimmän reitin kahden pisteen väliltä.
 * @author Tontsu
 */
import java.util.*;

/**
 *
 * @author Tontsu
 */
public class Reitinhaku {
    
    Prioriteettijono avoinLista = new Prioriteettijono(10);
    Solmu käsittelyssäOlevaSolmu;

    private int lähtöpisteX;
    private int lähtöpisteY;
    private char[][] kartta;
    private Boolean[][] suljettuLista;
    private Boolean[][] avoimenApulista;
    private Boolean löytyikö = false;
    private Boolean dijkstra = false;
    /**
     * Reitinhaun konstruktori, josta voi valita Dijkstran.
     * @param kartta Kaksiulotteinen taulukko, josta etsitään reitti.
     * @param dijkstra Annetaan true, jos alutaan käyttää Dijkstraa.
     */
    public Reitinhaku(char[][] kartta, boolean dijkstra) {
        this.dijkstra = dijkstra;
        this.kartta = kartta;       
        suljettuLista = new Boolean[kartta.length][kartta[0].length];
        avoimenApulista = new Boolean[kartta.length][kartta[0].length];
    }
    /**
     * Reitinhaun konstruktori. 
     * @param kartta Kaksiulotteinen taulukko, josta etsitään reitti.
     */
    public Reitinhaku(char[][] kartta) {
        this.kartta = kartta;       
        suljettuLista = new Boolean[kartta.length][kartta[0].length];
        avoimenApulista = new Boolean[kartta.length][kartta[0].length];
    }
    
    /**
     *Aloittaa reitin etsimisen konstruktorissa annetusta kartasta.
     * @param lähtöpiste Mistä aloitetaan.
     * @param maalipiste Mihin päädytään.
     * @return Palauttaa kartan, johon on X:illä merkitty lyhin reitti.
     */
    public char[][] etsiReitti(Solmu lähtöpiste, Solmu maalipiste) {
        laskeAlkuetäisyydetPisteille(lähtöpiste, maalipiste);
        tallennaLähtöpiste(lähtöpiste);
        aloitaHaku(maalipiste);
        if(löytyikö) {
            return rakennaReitti();
        }
        else {
            return new char[][]{{'T', 'R', 'O', 'L', 'O' ,'L'},};
        }
    }
    /**
     * Piirtää lyhimmän reitin kartalle käymällä maalisolmun isäntäsolmut läpi.
     * @return Kartta, johon on merkitty lyhin reitti.
     */
    private char[][] rakennaReitti() {
        Solmu reittisolmu = käsittelyssäOlevaSolmu;
        while(reittisolmu.getIsäntä() != null) {
            kartta[reittisolmu.getY()][reittisolmu.getX()] = 'X';
            reittisolmu = reittisolmu.getIsäntä();
        }
        return kartta;
    }
    /**
     * Alkaa hakea lyhintä reittiä maalipisteeseen.
     * Haku loppuu, jos suljettu lista sisältää maalipisteen, tai avoin lista tyhjenee.
     * @param maalipiste
     */
    private void aloitaHaku(Solmu maalipiste) {
        while(!avoinLista.onkoTyhjä()) {
            lisääSuljettuunListaan();
            etsi(käsittelyssäOlevaSolmu, maalipiste);
            if(käsittelyssäOlevaSolmu.equals(maalipiste)) {
                System.out.println("Löytyi");
                löytyikö = true;
                break;
            }
         }
    }
    /**
     * Tallentaa lähtöpisteen tiedot muistiin, ja asettaa lähtöpisteen avoimeen listaan.
     * @param lähtöpiste 
     */
    private void tallennaLähtöpiste(Solmu lähtöpiste) {
        avoinLista.lisää(lähtöpiste);
        lähtöpisteX = lähtöpiste.getX();
        lähtöpisteY = lähtöpiste.getY();
    }
    /**
     * Laskee oletetut etäisyydet lähtöpisteelle ja maalipisteelle.
     * @param lähtöpiste
     * @param maalipiste 
     */
    private void laskeAlkuetäisyydetPisteille(Solmu lähtöpiste, Solmu maalipiste) {
        lähtöpiste.setAlku(0);
        if(dijkstra) {
            lähtöpiste.setMaali(0);    
        }
        else {
            lähtöpiste.setMaali(laskeEtäisyys(lähtöpisteX, lähtöpisteY, maalipiste.getX(), maalipiste.getY()));    
        }
        maalipiste.setAlku(0);
        maalipiste.setMaali(0);
    }
    
    /**
     * Tutkii kesisolmun neljä suuntaa.
     * @param keskisolmu keskimmäinen solmu.
     * @param maalipiste maalisolmu, johon pyritään.
     */
    private void etsi(Solmu keskisolmu, Solmu maalipiste) {
        //Ylös
        etsintälogiikka(keskisolmu.getY()-1, keskisolmu.getX(), keskisolmu, maalipiste);
        //Alas
        etsintälogiikka(keskisolmu.getY()+1, keskisolmu.getX(), keskisolmu, maalipiste);
        //Vasemmalle
        etsintälogiikka(keskisolmu.getY(), keskisolmu.getX()-1, keskisolmu, maalipiste);
        //Oikealle
        etsintälogiikka(keskisolmu.getY(), keskisolmu.getX()+1, keskisolmu, maalipiste);
    
    }
    /**
     * Etsintälogiikka tarkistaa, että koordinaatit pysyvät kartan sisällä, 
     * ja että kyseinen koordinaatti ei ole seinä. Mikäli ehdot täyttyvät, lisätään uusi solmu avoimeen listaan.
     * @param y Uuden solmun y-koordinaatti.
     * @param x Uuden solmun x-koordinaatti.
     * @param isäntäsolmu Uuden solmun isäntäsolmu.
     * @param maalipiste Haun maalipiste.
     */
    private void etsintälogiikka(int y, int x, Solmu isäntäsolmu, Solmu maalipiste) {
        if((x >= 0 && x < kartta[0].length) && (y >= 0 && y < kartta.length) && kartta[y][x] == '.') {
            if(suljettuLista[y][x] == null) {
            int etäisyysAlusta = isäntäsolmu.getAlku()+1;
            int etäisyysMaalista;
            if(dijkstra) {
                etäisyysMaalista = 0;    
            }
            else {
                etäisyysMaalista = laskeEtäisyys(x, y, maalipiste.getX(), maalipiste.getY());    
            }
            Solmu solmu = new Solmu(y, x, etäisyysAlusta, etäisyysMaalista, isäntäsolmu);                
                lisääAvoimeenListaan(solmu);
            }
        }
    }
    /**
     * Ottaa pienimmän etäisyyden solmun avoimesta listasta ja lisää sen suljettuun listaan.
     */
    private void lisääSuljettuunListaan() {
        käsittelyssäOlevaSolmu = avoinLista.otaPienin();
        suljettuLista[käsittelyssäOlevaSolmu.getY()][käsittelyssäOlevaSolmu.getX()] = true;
    }
    
    /**
     * Tarkistaa ettei solmu ole jo suljetussa listassa ja lisää sen avoimeen listaan.
     * @param solmu Lisättävä solmu:
     * .
     */
    private void lisääAvoimeenListaan(Solmu solmu) {
            if(avoimenApulista[solmu.getY()][solmu.getX()] == null) {    
                avoimenApulista[solmu.getY()][solmu.getX()] = true;
                avoinLista.lisää(solmu);
            }    
    }
     /**
      * Arvioi manhattan-etäisyyden kahden pisteen välille.
      * @param solmuX Ensimmäisen arvioitavan x-koordinaatti.
      * @param solmuY Ensimmäisen arvioitavan y-koordinaatti.
      * @param maaliX Toisen arvioitavan x-koordinaatti.
      * @param maaliY Toisen arvioitavan y-koordinaatti
      * @return etäisyysarvio.
      */
    private int laskeEtäisyys(int solmuX, int solmuY, int maaliX, int maaliY) {
        return Math.abs(solmuX - maaliX) + Math.abs(solmuY - maaliY);
    }
}