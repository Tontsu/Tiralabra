/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import main.Solmu;
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
  
   reitinhaku = new Reitinhaku(sokkelo);
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
    public void TestaaSokkeloAlaVasenOikeaYlös() {
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
        
        Solmu aloitus = new Solmu(7, 0);
        Solmu maali = new Solmu(2, 3);
    assertEquals(odotettu, reitinhaku.etsiReitti(aloitus, maali));
    }
    
    @Test
    public void TestaaSokkeloYläOikeaVasenAlas() {
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
    assertEquals(odotettu, reitinhaku.etsiReitti(aloitus, maali));
    }
    
        @Test
    public void TestaaSokkeloYläVasenOikeaAlas() {
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
    assertEquals(odotettu, reitinhaku.etsiReitti(aloitus, maali));
    }
        
        @Test
    public void TestaaSokkeloAlaOikeaVasenYlös() {
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
    assertEquals(odotettu, reitinhaku.etsiReitti(aloitus, maali));
    }
}
