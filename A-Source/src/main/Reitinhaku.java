/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *Reitinhakulogiikan luokka. A*-toteutus.
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
    ArrayList<Solmu> suljettuLista = new ArrayList();
    
    private int lähtöpisteX;
    private int lähtöpisteY;
    private char[][] kartta;
    
    /**
     *Reitinhaun konstruktori
     * @param kartta Kaksiulotteinen taulukko, josta etsitään reitti.
     */
    public Reitinhaku(char[][] kartta) {
        this.kartta = kartta;   
    }
    
    /**
     *Aloittaa reitin etsimisen konstruktorissa annetusta kartasta.
     * @param lähtöpiste Mistä aloitetaan.
     * @param maalipiste Mihin päädytään.
     * @return Palauttaa kartan, johon on X:illä merkitty lyhin reitti.
     */
    public char[][] etsiReitti(Solmu lähtöpiste, Solmu maalipiste) {
        tallennaLähtöpiste(lähtöpiste);
        laskeAlkuetäisyydetPisteille(lähtöpiste, maalipiste);
        etsi(lähtöpiste, maalipiste);
        lisääSuljettuunListaan();
        aloitaHaku(maalipiste);
        return rakennaReitti();
    }
    /**
     * Piirtää lyhimmän reitin kartalle käymällä maalisolmun isäntäsolmut läpi.
     * @return Kartta, johon on merkitty lyhin reitti.
     */
    private char[][] rakennaReitti() {
        Solmu reittisolmu = suljettuLista.get(suljettuLista.size()-1);
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
            etsi(suljettuLista.get(suljettuLista.size()-1), maalipiste);
            if(suljettuLista.contains(maalipiste)) {
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
        lähtöpiste.setAlku(laskeEtäisyys(lähtöpisteX, lähtöpisteY, lähtöpisteX, lähtöpisteY));
        lähtöpiste.setMaali(laskeEtäisyys(lähtöpisteX, lähtöpisteY, maalipiste.getX(), maalipiste.getY()));
        maalipiste.setAlku(laskeEtäisyys(maalipiste.getX(), maalipiste.getY(), lähtöpisteX, lähtöpisteY));
        maalipiste.setMaali(laskeEtäisyys(maalipiste.getX(), maalipiste.getY(), maalipiste.getX(), maalipiste.getY()));
    }
    
    /**
     * Tutkii kesisolmun neljä suuntaa.
     * @param keskisolmu keskimmäinen solmu.
     * @param maalipiste maalisolmu, johon pyritään.
     */
    private void etsi(Solmu keskisolmu, Solmu maalipiste) {
        
        //Ylös
        etsintälogiikka(keskisolmu.getY()-1, keskisolmu.getX(), keskisolmu, maalipiste);
        //Vasemmalle
        etsintälogiikka(keskisolmu.getY(), keskisolmu.getX()-1, keskisolmu, maalipiste);
        //Oikealle
        etsintälogiikka(keskisolmu.getY(), keskisolmu.getX()+1, keskisolmu, maalipiste);
        //Alas
        etsintälogiikka(keskisolmu.getY()+1, keskisolmu.getX(), keskisolmu, maalipiste);
//        //alavasen
//        etsintälogiikka(lähtöpiste.getY()+1, lähtöpiste.getX()-1, lähtöpiste, maalipiste);
//        //alaoikea
//        etsintälogiikka(lähtöpiste.getY()+1, lähtöpiste.getX()+1, lähtöpiste, maalipiste);
//        //yläoikea
//        etsintälogiikka(lähtöpiste.getY()-1, lähtöpiste.getX()+1, lähtöpiste, maalipiste);
//        //ylävasen
//        etsintälogiikka(lähtöpiste.getY()-1, lähtöpiste.getX()-1, lähtöpiste, maalipiste);
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
            int etäisyysAlusta = laskeEtäisyys(lähtöpisteX, lähtöpisteY, x, y);
            int etäisyysMaalista = laskeEtäisyys(maalipiste.getX(), maalipiste.getY(), x, y);
            Solmu solmu = new Solmu(y, x, etäisyysAlusta, etäisyysMaalista, isäntäsolmu);
                lisääAvoimeenListaan(solmu); 
        }
    }
    /**
     * Ottaa pienimmän etäisyyden solmun avoimesta listasta ja lisää sen suljettuun listaan.
     */
    private void lisääSuljettuunListaan() {
        suljettuLista.add(avoinLista.otaPienin());
    }
    
    /**
     * Tarkistaa ettei solmu ole jo suljetussa listassa ja lisää sen avoimeen listaan.
     * @param solmu Lisättävä solmu:
     * .
     */
    private void lisääAvoimeenListaan(Solmu solmu) {
        if(!suljettuLista.contains(solmu)) {
            avoinLista.lisää(solmu);
        }
    }
     /**
      * Arvioi manhattan-etäisyyden kahden pisteen välille.
      * @param alkuX Ensimmäisen arvioitavan x-koordinaatti.
      * @param alkuY Ensimmäisen arvioitavan y-koordinaatti.
      * @param maaliX Toisen arvioitavan x-koordinaatti.
      * @param maaliY Toisen arvioitavan y-koordinaatti
      * @return etäisyysarvio.
      */
    private int laskeEtäisyys(int alkuX, int alkuY, int maaliX, int maaliY) {
        return Math.abs(alkuX - maaliX) + Math.abs(alkuY - maaliY);
    }
}