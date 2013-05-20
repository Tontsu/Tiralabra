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
   
    
 public static void main(String[] args) {
     
  
        Reitinhaku reitinhaku = new Reitinhaku(sokkelo);
        Solmu aloitus = new Solmu(7, 0);
        Solmu maali = new Solmu(2, 3);
        
            for(int i = 0; i < sokkelo.length; i++) {
            System.out.println("");
            for (int j = 0; j < sokkelo[0].length; j++) {
                System.out.print(sokkelo[i][j]);
            }
        }
        
        sokkelo = reitinhaku.etsiReitti(aloitus, maali);
        
        System.out.println("");
        for(int i = 0; i < sokkelo.length; i++) {
            System.out.println("");
            for (int j = 0; j < sokkelo[0].length; j++) {
                System.out.print(sokkelo[i][j]);
            }
        }
        
        
        
        
    }
 
}




