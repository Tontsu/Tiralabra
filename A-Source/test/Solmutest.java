/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Solmutest {
    
    private Solmu testisolmu1;
    private Solmu testisolmu2;
    private Solmu testisolmu3;
    public Solmutest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    testisolmu1 = new Solmu(10, 10, 10, 10, new Solmu(10,10));
    testisolmu2 = new Solmu(10, 9, 9, 9, new Solmu(10, 10));
    testisolmu3 = new Solmu(10, 10, 10, 10, new Solmu(10,10));
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testaaEqualsTrue() {
        assertEquals(true, testisolmu1.equals(testisolmu3));
    }
    @Test
    public void testaaEqualsFalse() {
        assertEquals(false, testisolmu1.equals(testisolmu2));
    }
    @Test
    public void testaaCompareVertailtavaPienempi() {
        int tulos = -1;
        assertEquals(tulos,testisolmu1.compareTo(testisolmu2));    
    }
    @Test
    public void testaaCompareSamatArvot() {
        int tulos = 0;
        assertEquals(tulos,testisolmu1.compareTo(testisolmu3));    
    }
    @Test
    public void testaaCompareVertailtavaSuurempi() {
        int tulos = 1;
        assertEquals(tulos,testisolmu2.compareTo(testisolmu1));    
    }
    
    
    
}
