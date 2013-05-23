/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import main.Prioriteettijono;
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
public class Prioriteettijonotest {
    
    private Prioriteettijono jono;
    
    public Prioriteettijonotest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jono = new Prioriteettijono(5);
    }
    
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testaaTyhjä() {
        assertEquals(true, jono.onkoTyhjä());
    }
    
    @Test
    public void testaaEiTyhjä() {
        jono.lisää(new Solmu(10,10,10,10,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,9,9,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,8,8,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,7,7,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,6,6,new Solmu(10,9)));
        assertEquals(false, jono.onkoTyhjä());
    }
    
    @Test
    public void testaaPalautaPienin() {
        jono.lisää(new Solmu(10,10,10,10,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,9,9,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,6,6,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,7,7,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,8,8,new Solmu(10,9)));
        Solmu vertailusolmu = new Solmu(10, 10, 6, 6, new Solmu(10, 9));
        assertEquals(vertailusolmu, jono.palautaPienin());
    }
    
    @Test
     public void testaaPoisto() {
        jono.lisää(new Solmu(10,10,10,10,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,9,9,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,6,6,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,8,8,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,7,7,new Solmu(10,9)));
        Solmu vertailusolmu = new Solmu(10, 10, 6, 6, new Solmu(10, 9));
     assertEquals(vertailusolmu, jono.otaPienin());
     }
    
    @Test
     public void testaaPoistoUseammin() {
        jono.lisää(new Solmu(10,10,10,10,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,6,6,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,9,9,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,7,7,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,8,8,new Solmu(10,9)));
        jono.otaPienin();
        jono.otaPienin();
        Solmu vertailusolmu = new Solmu(10, 10, 8, 8, new Solmu(10, 9));
     assertEquals(vertailusolmu, jono.otaPienin());
     }
    
    @Test
     public void testaaJononKasvatus() {
        for(int i = 0; i < 41; i++) {
            jono.lisää(new Solmu(10,10,10,10,new Solmu(10,9)));
        }
     assertEquals(80, jono.jononKoko());
     }
    @Test
     public void testaaIsoillaMäärilläPieniEnsin() {
        for(int i = 0; i < 3000000; i++) {
            jono.lisää(new Solmu(10,10,i,i,new Solmu(10,9)));
        }
     Solmu vertailusolmu = new Solmu(10, 10, 0, 0, new Solmu(10, 9));
     assertEquals(vertailusolmu, jono.palautaPienin());
     }
    @Test
     public void testaaIsoillaMäärilläSuurinEnsin() {
        for(int i = 3000000; i >= 0; i--) {
            jono.lisää(new Solmu(10,10,i,i,new Solmu(10,9)));
        }
     Solmu vertailusolmu = new Solmu(10, 10, 0, 0, new Solmu(10, 9));
     assertEquals(vertailusolmu, jono.palautaPienin());
     }
    @Test
     public void testaaKeskiMäärilläSuurinEnsin() {
        for(int i = 300000; i >= 0; i--) {
            jono.lisää(new Solmu(10,10,i,i,new Solmu(10,9)));
        }
     Solmu vertailusolmu = new Solmu(10, 10, 0, 0, new Solmu(10, 9));
     assertEquals(vertailusolmu, jono.palautaPienin());
     }
    @Test
    public void testaaVähänKaikkea() {
        jono.lisää(new Solmu(10,10,10,10,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,9,9,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,6,6,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,7,7,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,8,8,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,9,9,new Solmu(10,9)));
        jono.otaPienin();
        jono.lisää(new Solmu(10,10,11,11,new Solmu(10,9)));
        jono.lisää(new Solmu(10,10,4,4,new Solmu(10,9)));
        jono.otaPienin();
        jono.lisää(new Solmu(10,10,11,11,new Solmu(10,9)));
        Solmu vertailusolmu = new Solmu(10, 10, 7, 7, new Solmu(10, 9));
        assertEquals(vertailusolmu, jono.palautaPienin());
    }
}
