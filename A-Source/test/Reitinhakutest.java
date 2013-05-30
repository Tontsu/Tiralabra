/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import main.Kartanrakentaja;
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void TestaaTyhjäOikaAlanurkkaVasenYlänurkka() {
        char[][] odotettu = new char[][] {
        {'X', '.', '.', '.', '.' ,'.'},
        {'X', '.', '.', '.', '.' ,'.'},
        {'X', '.', '.', '.', '.' ,'.'},
        {'X', '.', '.', '.', '.' ,'.'},
        {'X', '.', '.', '.', '.' ,'.'},
        {'X', '.', '.', '.', '.' ,'.'},
        {'X', '.', '.', '.', '.' ,'.'},
        {'X', '.', '.', '.', '.' ,'.'},
        {'X', '.', '.', '.', '.' ,'.'},
        {'X', 'X', 'X', 'X', 'X' ,'.'},};
        rakentaja = new Kartanrakentaja(10, 6);
        char[][] kartta = rakentaja.getKartta();
        Solmu aloitus = new Solmu(kartta.length-1, kartta[0].length-1);
        Solmu maali = new Solmu(0, 0);
        Reitinhaku haku = new Reitinhaku(kartta);
    assertEquals(odotettu, haku.etsiReitti(aloitus, maali));
    }
    
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
        @Test
    public void TestaaSuorituskykyPieni() {
        rakentaja = new Kartanrakentaja(100, 100);
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
//        @Test
//    public void TestaaSuorituskykyIso() {
//        rakentaja = new Kartanrakentaja(10000, 10000);
//        char[][] kartta = rakentaja.getKartta();
//        Solmu maali = new Solmu(0, 0);
//        Solmu aloitus = new Solmu(kartta.length-1, kartta[0].length-1);
//        Reitinhaku haku = new Reitinhaku(kartta);
//        haku.etsiReitti(aloitus, maali);
//    }
}
