/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import tira.Kartanrakentaja;
import tira.Reitinhaku;
import tira.Solmu;
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
public class suorituskykytestit {

    Kartanrakentaja rakentaja;    
    public suorituskykytestit() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
        @Test
    public void TestaaSuorituskyky1() {
        rakentaja = new Kartanrakentaja(500, 500);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        long aika = System.currentTimeMillis();
        haku.etsiReitti(aloitus, maali);
        aika = System.currentTimeMillis() - aika;
        System.out.println("1 " + aika);
    }
        @Test
    public void TestaaSuorituskyky2() {
        rakentaja = new Kartanrakentaja(1000, 1000);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        long aika = System.currentTimeMillis();
        haku.etsiReitti(aloitus, maali);
        aika = System.currentTimeMillis() - aika;
        System.out.println("2 " + aika);
        
    }
       @Test
    public void TestaaSuorituskyky3() {
        rakentaja = new Kartanrakentaja(1500, 1500);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        long aika = System.currentTimeMillis();
        haku.etsiReitti(aloitus, maali);
        aika = System.currentTimeMillis() - aika;
        System.out.println("3 " + aika);
        
    }
       @Test
    public void TestaaSuorituskyky4() {
        rakentaja = new Kartanrakentaja(2000, 2000);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        long aika = System.currentTimeMillis();
        haku.etsiReitti(aloitus, maali);
        aika = System.currentTimeMillis() - aika;
        System.out.println("4 " + aika);
        
    }
       @Test
    public void TestaaSuorituskyky5() {
        rakentaja = new Kartanrakentaja(2500, 2500);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        long aika = System.currentTimeMillis();
        haku.etsiReitti(aloitus, maali);
        aika = System.currentTimeMillis() - aika;
        System.out.println("5 " + aika);
        
    }
        @Test
    public void TestaaSuorituskyky6() {
        rakentaja = new Kartanrakentaja(3000, 3000);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        long aika = System.currentTimeMillis();
        haku.etsiReitti(aloitus, maali);
        aika = System.currentTimeMillis() - aika;
        System.out.println("6 " + aika);
        
    }
       @Test
    public void TestaaSuorituskyky7() {
        rakentaja = new Kartanrakentaja(3500, 3500);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        long aika = System.currentTimeMillis();
        haku.etsiReitti(aloitus, maali);
        aika = System.currentTimeMillis() - aika;
        System.out.println("7 " + aika);
        
    }
        @Test
    public void TestaaSuorituskyky8() {
        rakentaja = new Kartanrakentaja(4000, 4000);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        long aika = System.currentTimeMillis();
        haku.etsiReitti(aloitus, maali);
        aika = System.currentTimeMillis() - aika;
        System.out.println("8 " + aika);
    }

}
