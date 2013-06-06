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
static Scanner lukija = new Scanner(System.in);
    
 public static void main(String[] args) {
     int X = 0;
     int Y = 0;
     while (true) {
        boolean loppu = true;
        System.out.println("Syötä leveys: ");
        String leveys = lukija.nextLine();
        System.out.println("Syötä korkeus: ");
        String korkeus = lukija.nextLine();
        try{
            X = Integer.parseInt(leveys);  
        }
        catch (Exception e) {
            loppu = false;
            System.out.println("Syötit leveyden väärin");
        }
        try{
            Y = Integer.parseInt(korkeus);  
        }
        catch (Exception e) {
            loppu = false;
            System.out.println("Syötit korkeuden väärin");
        }
     
        if (loppu) {
            break;
        }
     }     
     Kartanrakentaja kartta = new Kartanrakentaja(Y, X);

     
     System.out.println("");
     
     while (true) {
        boolean loppu = true;
        System.out.println("Syötä alkupisteen X: ");
        String leveys = lukija.nextLine();
        System.out.println("Syötä alkupisteen Y: ");
        String korkeus = lukija.nextLine();
        try{
            X = Integer.parseInt(leveys);  
        }
        catch (Exception e) {
            loppu = false;
            System.out.println("X ei ollut koknaisluku");
            }
        try{
        Y = Integer.parseInt(korkeus);  
        }
        catch (Exception e) {
            loppu = false;
            System.out.println("Y ei ollut kokonaisluku");
        }
        try{
            kartta.getKartta()[Y-1][X-1] = '.';
        }
        catch(Exception e) {
            loppu = false;
            System.out.println("Syötit virheelliset koordinaatit");
        }
        if (loppu) {
            break;
        }
     }
     
    Solmu aloitus = new Solmu(Y-1, X-1);

    while (true) {
        boolean loppu = true;
        System.out.println("Syötä maalipisteen X: ");
        String leveys = lukija.nextLine();
        System.out.println("Syötä maalipisteen Y: ");
        String korkeus = lukija.nextLine();
        try{
            X = Integer.parseInt(leveys);  
        }
        catch (Exception e) {
            loppu = false;
            System.out.println("X ei ollut koknaisluku");
        }
        try{
            Y = Integer.parseInt(korkeus);  
        }
        catch (Exception e) {
            loppu = false;
            System.out.println("Y ei ollut kokonaisluku");
        }
        try{
            kartta.getKartta()[Y-1][X-1] = '.';
        }
        catch(Exception e) {
            loppu = false;
            System.out.println("Syötit virheelliset koordinaatit");
        }
        if (loppu) {
            break;
        }
     }
    
    Solmu maali = new Solmu(Y-1, X-1);
    
    while (true) {
        kartta.tulostaKartta();
        System.out.println("");
        boolean loppu = false;
        System.out.println("Syötä esteen X: ");
        String leveys = lukija.nextLine();
        System.out.println("Syötä esteen Y: ");
        String korkeus = lukija.nextLine();
        try{
            X = Integer.parseInt(leveys);  
        }
        catch (Exception e) {
            loppu = true;
        }
        try{
            Y = Integer.parseInt(korkeus);  
        }
        catch (Exception e) {
            loppu = true;
        }
         if (loppu) {
            break;
        }
        try{
            kartta.asetaEste(Y-1, X-1);
        }
        catch(Exception e) {
            loppu = false;
            System.out.println("Syötit virheelliset koordinaatit");
        }
       
     }
    
        char[][] dijkstra = new char[kartta.getKartta().length][kartta.getKartta()[0].length];
        for(int i = 0; i < kartta.getKartta().length; i++) {
            for (int j = 0; j < kartta.getKartta()[0].length; j++) {
                dijkstra [i][j] = kartta.getKartta()[i][j];
            }
        }
        char[][] astar = kartta.getKartta();
        Reitinhaku reitinhakudijkstra = new Reitinhaku(dijkstra, true);
        Reitinhaku reitinhakuastar = new Reitinhaku(astar);
        astar = reitinhakuastar.etsiReitti(aloitus, maali);
        dijkstra = reitinhakudijkstra.etsiReitti(aloitus, maali);
        
        System.out.println("A*");
        for(int i = 0; i < astar.length; i++) {
            System.out.println("");
            for (int j = 0; j < astar[0].length; j++) {
                System.out.print(astar[i][j]);
            }
        }
        System.out.println("");
         System.out.println("Dijkstra");
        for(int i = 0; i < dijkstra.length; i++) {
            System.out.println("");
            for (int j = 0; j < dijkstra[0].length; j++) {
                System.out.print(dijkstra[i][j]);
            }
        }
    }
 
}




