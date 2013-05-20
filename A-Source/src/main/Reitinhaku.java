/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *Reitinhakulogiikan luokka. A*-toteutus.
 * @author Tontsu
 */
import java.util.*;

public class Reitinhaku {
    
    ArrayList<Solmu> avoinLista = new ArrayList();
    ArrayList<Solmu> suljettuLista = new ArrayList();
    
    private int lähtöpisteX;
    private int lähtöpisteY;
    private char[][] kartta;
    
    public Reitinhaku(char[][] kartta) {
        this.kartta = kartta;
        
    }
    
    public char[][] etsiReitti(Solmu lähtöpiste, Solmu maalipiste) {
        tallennaLähtöpiste(lähtöpiste);
        laskeAlkuetäisyydetPisteille(lähtöpiste, maalipiste);
        etsi(lähtöpiste, maalipiste);
        lisääSuljettuunListaan(avoinLista.get(0), 0);
        aloitaLooppi(maalipiste);
        return rakennaReitti();
    }
    
    private char[][] rakennaReitti() {
        Solmu reittisolmu = suljettuLista.get(suljettuLista.size()-1);
        while(reittisolmu.getIsäntä() != null) {
            kartta[reittisolmu.getY()][reittisolmu.getX()] = 'X';
            reittisolmu = reittisolmu.getIsäntä();
        }
        
        return kartta;
          
    }
    
    private void aloitaLooppi(Solmu maalipiste) {
         while(!avoinLista.isEmpty()) {
            haePieninEtäisyys();
            etsi(suljettuLista.get(suljettuLista.size()-1), maalipiste);
            if(suljettuLista.contains(maalipiste)) {
                break;
            }
         }
        
    }
    
    private void tallennaLähtöpiste(Solmu lähtöpiste) {
        avoinLista.add(lähtöpiste);
        lähtöpisteX = lähtöpiste.getX();
        lähtöpisteY = lähtöpiste.getY();
        
    }
    
    private void laskeAlkuetäisyydetPisteille(Solmu lähtöpiste, Solmu maalipiste) {
        lähtöpiste.setAlku(laskeEtäisyys(lähtöpisteX, lähtöpisteY, lähtöpisteX, lähtöpisteY));
        lähtöpiste.setMaali(laskeEtäisyys(lähtöpisteX, lähtöpisteY, maalipiste.getX(), maalipiste.getY()));
        maalipiste.setAlku(laskeEtäisyys(maalipiste.getX(), maalipiste.getY(), lähtöpisteX, lähtöpisteY));
        maalipiste.setMaali(laskeEtäisyys(maalipiste.getX(), maalipiste.getY(), maalipiste.getX(), maalipiste.getY()));
        
    }
    
    private void etsi(Solmu lähtöpiste, Solmu maalipiste) {
        //Ylös
        etsintälogiikka(lähtöpiste.getY()-1, lähtöpiste.getX(), lähtöpiste, maalipiste);
        //Vasemmalle
        etsintälogiikka(lähtöpiste.getY(), lähtöpiste.getX()-1, lähtöpiste, maalipiste);
        //Oikealle
        etsintälogiikka(lähtöpiste.getY(), lähtöpiste.getX()+1, lähtöpiste, maalipiste);
        //Alas
        etsintälogiikka(lähtöpiste.getY()+1, lähtöpiste.getX(), lähtöpiste, maalipiste);
        
    }
    
    private void etsintälogiikka(int y, int x, Solmu lähtöpiste, Solmu maalipiste) {
        if((x >= 0 && x < kartta[0].length) && (y >= 0 && y < kartta.length) && kartta[y][x] == '.') {
            int etäisyysAlusta = laskeEtäisyys(lähtöpisteX, lähtöpisteY, x, y);
            int etäisyysMaalista = laskeEtäisyys(maalipiste.getX(), maalipiste.getY(), x, y);
            Solmu solmu = new Solmu(y, x, etäisyysAlusta, etäisyysMaalista, lähtöpiste);
                lisääAvoimeenListaan(solmu); 
        }
    }
    
    private void lisääSuljettuunListaan(Solmu solmu, int indeksi) {
        suljettuLista.add(solmu);
        avoinLista.remove(indeksi);
    }
    
    private void lisääAvoimeenListaan(Solmu solmu) {
        if(!suljettuLista.contains(solmu)) {
            avoinLista.add(solmu);
        }
    }
     
    private int laskeEtäisyys(int alkuX, int alkuY, int solmuX, int solmuY) {
        return Math.abs(alkuX - solmuX) + Math.abs(alkuY - solmuY);
    }
    
    private void haePieninEtäisyys() {
        int pienin = Integer.MAX_VALUE;
        int indeksi = 0;
        for (int i = 0; i < avoinLista.size(); i++) {
            int apu = avoinLista.get(i).getAlku() + avoinLista.get(i).getMaali();
            if(apu < pienin) {
                pienin = apu;
                indeksi = i;
            }
        } 
        lisääSuljettuunListaan(avoinLista.get(indeksi), indeksi);
    }
}