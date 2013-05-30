/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package main;

import java.util.*;


public class Main {
/**
 *
 * @author Tontsu
 */
public static char[][] sokkelo = new char[][] {
  {'.', '#', '#', '#', '#' ,'#'},
  {'.', '#', '#', '.', '.', '#'},
  {'.', '#', '#', '.', '.' ,'#'},
  {'.', '.', '.', '.', '.' ,'#'},
  {'#', '#', '#', '#', '.' ,'#'},
  {'.', '#', '#', '.', '.', '#'},
  {'.', '#', '#', '.', '#' ,'#'},
  {'.', '.', '.', '.', '.' ,'#'},
  {'#', '#', '#', '#', '.' ,'#'},};
   
public static char[][] tulos;
static Scanner lukija = new Scanner(System.in);
    
 public static void main(String[] args) {

     
        Kartanrakentaja kartta = new Kartanrakentaja(10, 10);
        
//        kartta.asetaEste(5, 0);
//        kartta.asetaEste(5, 2);
//        kartta.asetaEste(5, 3);
//        kartta.asetaEste(5, 4);
//        kartta.asetaEste(5, 5);
//        kartta.asetaEste(5, 1);
        Reitinhaku reitinhaku = new Reitinhaku(kartta.getKartta());
        Solmu maali = new Solmu(0, 0);
        Solmu aloitus = new Solmu(kartta.getKartta().length-1, kartta.getKartta().length-1);
        
        kartta.tulostaKartta();
        
        tulos = reitinhaku.etsiReitti(aloitus, maali);
        
                System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
     
        
    }
 
}




