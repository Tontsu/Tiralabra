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
    
    ArrayList<Noodi> avoinLista = new ArrayList();
    ArrayList<Noodi> suljettuLista = new ArrayList();
    
    private int lähtöpisteX;
    private int lähtöpisteY;
    
    public Reitinhaku() {
        
    }
    
    public char[][] etsiReitti(char[][] kartta, Noodi lähtöpiste, Noodi maalipiste) {
        avoinLista.add(lähtöpiste);
   
        lähtöpisteX = lähtöpiste.getX();
        lähtöpisteY = lähtöpiste.getY();
        
        lähtöpiste.setAlku(laskeEtäisyys(lähtöpisteX, lähtöpisteY, lähtöpisteX, lähtöpisteY));
        lähtöpiste.setMaali(laskeEtäisyys(lähtöpisteX, lähtöpisteY, maalipiste.getX(), maalipiste.getY()));
        maalipiste.setAlku(laskeEtäisyys(maalipiste.getX(), maalipiste.getY(), lähtöpisteX, lähtöpisteY));
        maalipiste.setMaali(laskeEtäisyys(maalipiste.getX(), maalipiste.getY(), maalipiste.getX(), maalipiste.getY()));
        
        etsi(kartta, lähtöpiste, maalipiste);
        
        suljettuLista.add(avoinLista.get(0));
        avoinLista.remove(0);
        
        while(!avoinLista.isEmpty()) {
            suurin();
            etsi(kartta, suljettuLista.get(suljettuLista.size()-1), maalipiste);
        
            if(suljettuLista.contains(maalipiste)) {
                break;
            }
         }
        
       Noodi reittinoodi = suljettuLista.get(suljettuLista.size()-1);
       
        while(reittinoodi.getIsäntä() != null) {
            kartta[reittinoodi.getY()][reittinoodi.getX()] = 'X';
            reittinoodi = reittinoodi.getIsäntä();
        }
        
        return kartta;
    }
    
    private void etsi(char[][] kartta, Noodi lähtöpiste, Noodi maalipiste) {
        //Ylös
        if(lähtöpiste.getY()-1 >= 0 && kartta[lähtöpiste.getY()-1][lähtöpiste.getX()] == '.') {
            int etäisyysAlusta = laskeEtäisyys(lähtöpisteX, lähtöpisteY, lähtöpiste.getX(), lähtöpiste.getY()-1);
            int etäisyysMaalista = laskeEtäisyys(maalipiste.getX(), maalipiste.getY(), lähtöpiste.getX(), lähtöpiste.getY()-1);
            Noodi noodi = new Noodi(lähtöpiste.getY()-1, lähtöpiste.getX(), etäisyysAlusta, etäisyysMaalista, lähtöpiste);
                if(!suljettuLista.contains(noodi)) {
                    avoinLista.add(noodi);
                }
        }
        //Vasemmalle
        if(lähtöpiste.getX()-1 >= 0 && kartta[lähtöpiste.getY()][lähtöpiste.getX()-1] == '.') {
            int etäisyysAlusta = laskeEtäisyys(lähtöpisteX, lähtöpisteY, lähtöpiste.getX()-1, lähtöpiste.getY());
            int etäisyysMaalista = laskeEtäisyys(maalipiste.getX(), maalipiste.getY(), lähtöpiste.getX()-1, lähtöpiste.getY());
            Noodi noodi = new Noodi(lähtöpiste.getY(), lähtöpiste.getX()-1, etäisyysAlusta, etäisyysMaalista, lähtöpiste);
                if(!suljettuLista.contains(noodi)) {
                    avoinLista.add(noodi);
                }
        }
        //Oikealle
        if(lähtöpiste.getX()+1 < kartta[0].length && kartta[lähtöpiste.getY()][lähtöpiste.getX()+1] == '.') {
            int etäisyysAlusta = laskeEtäisyys(lähtöpisteX, lähtöpisteY, lähtöpiste.getX()+1, lähtöpiste.getY());
            int etäisyysMaalista = laskeEtäisyys(maalipiste.getX(), maalipiste.getY(), lähtöpiste.getX()+1, lähtöpiste.getY());
            Noodi noodi = new Noodi(lähtöpiste.getY(), lähtöpiste.getX()+1, etäisyysAlusta, etäisyysMaalista, lähtöpiste);
                if(!suljettuLista.contains(noodi)) {
                    avoinLista.add(noodi);
                }
        }
        //Alas
        if(lähtöpiste.getY()+1 < kartta.length && kartta[lähtöpiste.getY()+1][lähtöpiste.getX()] == '.') {
            int etäisyysAlusta = laskeEtäisyys(lähtöpisteX, lähtöpisteY, lähtöpiste.getX(), lähtöpiste.getY()+1);
            int etäisyysMaalista = laskeEtäisyys(maalipiste.getX(), maalipiste.getY(), lähtöpiste.getX(), lähtöpiste.getY()+1);
            Noodi noodi = new Noodi(lähtöpiste.getY()+1, lähtöpiste.getX(), etäisyysAlusta, etäisyysMaalista, lähtöpiste);
                if(!suljettuLista.contains(noodi)) {
                    avoinLista.add(noodi);
                }
        }
        
    }
     
    private int laskeEtäisyys(int alkuX, int alkuY, int noodiX, int noodiY) {
        return Math.abs(alkuX - noodiX) + Math.abs(alkuY - noodiY);
    }
    
    private void suurin() {
        int pienin = Integer.MAX_VALUE;
        int indeksi = 0;
        for (int i = 0; i < avoinLista.size(); i++) {
            int apu = avoinLista.get(i).getAlku() + avoinLista.get(i).getMaali();
            if(apu < pienin) {
                pienin = apu;
                indeksi = i;
            }
        }
        
        suljettuLista.add(avoinLista.get(indeksi));
        avoinLista.remove(indeksi);
        
    }
}