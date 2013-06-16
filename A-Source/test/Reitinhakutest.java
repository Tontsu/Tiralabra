/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import tira.Kartanrakentaja;
import tira.Solmu;
import tira.Reitinhaku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tontsu
 */
public class Reitinhakutest {
    char[][] sokkelo;
    Reitinhaku reitinhaku;
    Kartanrakentaja rakentaja;
    public Reitinhakutest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {

   sokkelo = new char[][] {
  {'.', '#', '#', '#', '#' ,'#'},
  {'.', '#', '#', '.', '.', '#'},
  {'.', '#', '#', '.', '.' ,'#'},
  {'.', '.', '.', '.', '.' ,'#'},
  {'#', '#', '#', '#', '.' ,'#'},
  {'.', '#', '#', '.', '.', '#'},
  {'.', '#', '#', '.', '#' ,'#'},
  {'.', '.', '.', '.', '.' ,'#'},
  {'#', '#', '#', '#', '.' ,'#'},};
  
   reitinhaku = new Reitinhaku(sokkelo);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void TestaaOikealtaVasemmalleEste() {
        rakentaja = new Kartanrakentaja(10, 6);
        rakentaja.asetaEste(5, 3);
        rakentaja.asetaEste(4, 3);
        rakentaja.asetaEste(6, 3);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(5, 5);
        Solmu maali = new Solmu(5, 0);
        Reitinhaku haku = new Reitinhaku(kartta);
        char[][] tulos = haku.etsiReitti(aloitus, maali);
       
        int pituus = 0;
        for(int i = 0; i < tulos.length; i++) {
            for (int j = 0; j < tulos[0].length; j++) {
                if(tulos[i][j] == 'X') {
                    pituus++;
                }
            }
        }
        System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
    assertEquals(9, pituus);
    }
      @Test
    public void TestaaVasemmaltaOikealleEste() {
        rakentaja = new Kartanrakentaja(10, 6);
        rakentaja.asetaEste(5, 3);
        rakentaja.asetaEste(4, 3);
        rakentaja.asetaEste(6, 3);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(5, 0);
        Solmu maali = new Solmu(5, 5);
        Reitinhaku haku = new Reitinhaku(kartta);
        char[][] tulos = haku.etsiReitti(aloitus, maali);
        
        int pituus = 0;
        for(int i = 0; i < tulos.length; i++) {
            for (int j = 0; j < tulos[0].length; j++) {
                if(tulos[i][j] == 'X') {
                    pituus++;
                }
            }
        }
        
        System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
    assertEquals(9, pituus);
    }
    @Test
    public void TestaaAlhaaltaYlosEste() {
        rakentaja = new Kartanrakentaja(10, 6);
        rakentaja.asetaEste(5, 3);
        rakentaja.asetaEste(5, 4);
        rakentaja.asetaEste(5, 2);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(9, 3);
        Solmu maali = new Solmu(0, 3);
        Reitinhaku haku = new Reitinhaku(kartta);
        
        char[][] tulos = haku.etsiReitti(aloitus, maali);
        
        int pituus = 0;
        for(int i = 0; i < tulos.length; i++) {
            for (int j = 0; j < tulos[0].length; j++) {
                if(tulos[i][j] == 'X') {
                    pituus++;
                }
            }
        }
        
        System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
    assertEquals(13, pituus);
    }
      @Test
    public void TestaaYlhaaltaAlasEste() {
        rakentaja = new Kartanrakentaja(10, 6);
        rakentaja.asetaEste(5, 3);
        rakentaja.asetaEste(5, 4);
        rakentaja.asetaEste(5, 2);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 3);
        Solmu maali = new Solmu(9, 3);
        Reitinhaku haku = new Reitinhaku(kartta);
        char[][] tulos = haku.etsiReitti(aloitus, maali);
        
        int pituus = 0;
        for(int i = 0; i < tulos.length; i++) {
            for (int j = 0; j < tulos[0].length; j++) {
                if(tulos[i][j] == 'X') {
                    pituus++;
                }
            }
        }
        
        System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
    assertEquals(13, pituus);
    }
    
    @Test
    public void TestaaTyhjaOikeaYlanurkkaVasenAlanurkka() {
        rakentaja = new Kartanrakentaja(10, 6);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, kartta[0].length-1);
        Solmu maali = new Solmu(kartta.length-1, 0);
        Reitinhaku haku = new Reitinhaku(kartta);
        
        char[][] tulos = haku.etsiReitti(aloitus, maali);
        
        int pituus = 0;
        for(int i = 0; i < tulos.length; i++) {
            for (int j = 0; j < tulos[0].length; j++) {
                if(tulos[i][j] == 'X') {
                    pituus++;
                }
            }
        }
        
        System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
    assertEquals(14, pituus);
    }
    
    @Test
    public void TestaaTyhjaVasenYlanurkkaOikeaAlanurkka() {
        rakentaja = new Kartanrakentaja(10, 6);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        char[][] tulos = haku.etsiReitti(aloitus, maali);
        
        int pituus = 0;
        for(int i = 0; i < tulos.length; i++) {
            for (int j = 0; j < tulos[0].length; j++) {
                if(tulos[i][j] == 'X') {
                    pituus++;
                }
            }
        }
        
        System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
    assertEquals(14, pituus);
    }
    
    @Test
    public void TestaaTyhjaVasenAlanurkkaOikeaYlanurkka() {
        rakentaja = new Kartanrakentaja(10, 6);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(kartta.length-1, 0);
        Solmu maali = new Solmu(0, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        
        char[][] tulos = haku.etsiReitti(aloitus, maali);
        
        int pituus = 0;
        for(int i = 0; i < tulos.length; i++) {
            for (int j = 0; j < tulos[0].length; j++) {
                if(tulos[i][j] == 'X') {
                    pituus++;
                }
            }
        }
        
        System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
    assertEquals(14, pituus);
    }
    
    @Test
    public void TestaaTyhjaOikeaAlanurkkaVasenYlanurkka() {
        rakentaja = new Kartanrakentaja(10, 6);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(kartta.length-1, kartta[0].length-1);
        Solmu maali = new Solmu(0, 0);
        Reitinhaku haku = new Reitinhaku(kartta);
        
        char[][] tulos = haku.etsiReitti(aloitus, maali);
        int pituus = 0;
        for(int i = 0; i < tulos.length; i++) {
            for (int j = 0; j < tulos[0].length; j++) {
                if(tulos[i][j] == 'X') {
                    pituus++;
                }
            }
        }
        
        System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
    assertEquals(14, pituus);
    }
    
    @Test
    public void TestaaSokkeloAlaVasenOikeaYlos() {
        char[][] odotettu = new char[][] {
        {'.', '#', '#', '#', '#' ,'#'},
        {'.', '#', '#', '.', '.', '#'},
        {'.', '#', '#', 'X', 'X' ,'#'},
        {'.', '.', '.', '.', 'X' ,'#'},
        {'#', '#', '#', '#', 'X' ,'#'},
        {'.', '#', '#', 'X', 'X', '#'},
        {'.', '#', '#', 'X', '#' ,'#'},
        {'.', 'X', 'X', 'X', '.' ,'#'},
        {'#', '#', '#', '#', '.' ,'#'},};
        Solmu aloitus = new Solmu(7, 0);
        Solmu maali = new Solmu(2, 3);
        char[][]tulos = reitinhaku.etsiReitti(aloitus, maali);
        System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
    assertEquals(odotettu, tulos);
    }
    
    @Test
    public void TestaaSokkeloYlaOikeaVasenAlas() {
        char[][] odotettu = new char[][] {
        {'.', '#', '#', '#', '#' ,'#'},
        {'.', '#', '#', '.', '.', '#'},
        {'.', '#', '#', '.', 'X' ,'#'},
        {'.', '.', '.', '.', 'X' ,'#'},
        {'#', '#', '#', '#', 'X' ,'#'},
        {'.', '#', '#', 'X', 'X', '#'},
        {'.', '#', '#', 'X', '#' ,'#'},
        {'X', 'X', 'X', 'X', '.' ,'#'},
        {'#', '#', '#', '#', '.' ,'#'},};
        Solmu aloitus = new Solmu(1, 4);
        Solmu maali = new Solmu(7, 0);
        
        char[][] tulos = reitinhaku.etsiReitti(aloitus, maali);
        
        System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
    assertEquals(odotettu, tulos);
    }
    
        @Test
    public void TestaaSokkeloYlaVasenOikeaAlas() {
        char[][] odotettu = new char[][] {
        {'.', '#', '#', '#', '#' ,'#'},
        {'X', '#', '#', '.', '.', '#'},
        {'X', '#', '#', '.', '.' ,'#'},
        {'X', 'X', 'X', 'X', 'X' ,'#'},
        {'#', '#', '#', '#', 'X' ,'#'},
        {'.', '#', '#', 'X', 'X', '#'},
        {'.', '#', '#', 'X', '#' ,'#'},
        {'.', '.', '.', 'X', 'X' ,'#'},
        {'#', '#', '#', '#', 'X' ,'#'},};
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(8, 4);
        char[][] tulos = reitinhaku.etsiReitti(aloitus, maali);
        
        System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
    assertEquals(odotettu, tulos);
    }
        
        @Test
    public void TestaaSokkeloAlaOikeaVasenYlos() {
        char[][] odotettu = new char[][] {
        {'X', '#', '#', '#', '#' ,'#'},
        {'X', '#', '#', '.', '.', '#'},
        {'X', '#', '#', '.', '.' ,'#'},
        {'X', 'X', 'X', 'X', 'X' ,'#'},
        {'#', '#', '#', '#', 'X' ,'#'},
        {'.', '#', '#', 'X', 'X', '#'},
        {'.', '#', '#', 'X', '#' ,'#'},
        {'.', '.', '.', 'X', 'X' ,'#'},
        {'#', '#', '#', '#', '.' ,'#'},};
        Solmu aloitus = new Solmu(8, 4);
        Solmu maali = new Solmu(0, 0);
        char[][] tulos = reitinhaku.etsiReitti(aloitus, maali);
        
        System.out.println("");
        for(int i = 0; i < tulos.length; i++) {
            System.out.println("");
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j]);
            }
        }
    assertEquals(odotettu, tulos);
    }
        @Test
    public void TestaaIsostiOikeaYlaVasenAla() {
        rakentaja = new Kartanrakentaja(4000, 4000);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, kartta[0].length-1);
        Solmu maali = new Solmu(kartta.length-1, 0);
        Reitinhaku haku = new Reitinhaku(kartta);
        haku.etsiReitti(aloitus, maali);
    }
        @Test
    public void TestaaIsostiVasenAlaOikeaYla() {
        rakentaja = new Kartanrakentaja(4000, 4000);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(kartta.length-1, 0);
        Solmu maali = new Solmu(0, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        haku.etsiReitti(aloitus, maali);
    }
        @Test
    public void TestaaIsostiOikeaAlaVasenYla() {
        rakentaja = new Kartanrakentaja(4000, 4000);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(kartta.length-1, kartta[0].length-1);
        Solmu maali = new Solmu(0, 0);
        Reitinhaku haku = new Reitinhaku(kartta);
        haku.etsiReitti(aloitus, maali);
    }

}
