/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import main.Kartanrakentaja;
import main.Reitinhaku;
import main.Solmu;
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
   Reitinhaku reitinhaku;
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
    public void TestaaSuorituskykyPieni() {
        rakentaja = new Kartanrakentaja(500, 500);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        haku.etsiReitti(aloitus, maali);
    }
        @Test
    public void TestaaSuorituskykyKeski() {
        rakentaja = new Kartanrakentaja(1000, 1000);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        haku.etsiReitti(aloitus, maali);
        
    }
       @Test
    public void TestaaSuorituskykyKeski1() {
        rakentaja = new Kartanrakentaja(1500, 1500);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        haku.etsiReitti(aloitus, maali);
        
    }
       @Test
    public void TestaaSuorituskykyKeski2() {
        rakentaja = new Kartanrakentaja(2000, 2000);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        haku.etsiReitti(aloitus, maali);
        
    }
       @Test
    public void TestaaSuorituskykyKeski3() {
        rakentaja = new Kartanrakentaja(2500, 2500);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        haku.etsiReitti(aloitus, maali);
        
    }
        @Test
    public void TestaaSuorituskykyKeski4() {
        rakentaja = new Kartanrakentaja(3000, 3000);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        haku.etsiReitti(aloitus, maali);
        
    }
       @Test
    public void TestaaSuorituskykyKeski5() {
        rakentaja = new Kartanrakentaja(3400, 3400);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        haku.etsiReitti(aloitus, maali);
        
    }
        @Test
    public void TestaaSuorituskykyIso() {
        rakentaja = new Kartanrakentaja(4000, 4000);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(0, 0);
        Solmu maali = new Solmu(kartta.length-1, kartta[0].length-1);
        Reitinhaku haku = new Reitinhaku(kartta);
        haku.etsiReitti(aloitus, maali);
    }

}
