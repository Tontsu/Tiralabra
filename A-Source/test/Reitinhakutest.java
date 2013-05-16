/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import main.Noodi;
import main.Reitinhaku;
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
  
   reitinhaku = new Reitinhaku();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void TestaaSokkelo() {
  char[][] odotettu = new char[][] {
  {'.', '#', '#', '#', '#' ,'#'},
  {'.', '#', '#', '.', '.', '#'},
  {'.', '#', '#', 'X', '.' ,'#'},
  {'.', '.', '.', 'X', 'X' ,'#'},
  {'#', '#', '#', '#', 'X' ,'#'},
  {'.', '#', '#', 'X', 'X', '#'},
  {'.', '#', '#', 'X', '#' ,'#'},
  {'.', 'X', 'X', 'X', '.' ,'#'},
  {'#', '#', '#', '#', '.' ,'#'},};
        
        Noodi aloitus = new Noodi(7, 0);
        Noodi maali = new Noodi(2, 3);
    assertEquals(odotettu, reitinhaku.etsiReitti(sokkelo, aloitus, maali));
    }
}
