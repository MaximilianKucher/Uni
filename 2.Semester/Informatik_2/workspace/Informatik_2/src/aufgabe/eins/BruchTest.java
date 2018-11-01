package aufgabe.eins;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BruchTest {

  @Test
  public void testBruch() {
    Bruch bruch = new Bruch(8,5);
    assertEquals(8,bruch.getZaehler());
    assertEquals(5,bruch.getNenner());
  }
  
  @Test
  public void testKuerzen1() {
    Bruch bruch = new Bruch(-4,20);
    bruch.kuerzen();
    assertEquals(-1,bruch.getZaehler());
    assertEquals(5,bruch.getNenner());
  }
  
  @Test
  public void testKuerzen2() {
    Bruch bruch = new Bruch(4,20);
    bruch.kuerzen();
    assertEquals(1,bruch.getZaehler());
    assertEquals(5,bruch.getNenner());
  }
  
  @Test
  public void testAddieren1() {
    Bruch bruch1 = new Bruch(3,7);
    Bruch bruch2 = new Bruch(7,29);
    bruch1.addieren(bruch2);
    assertEquals(136,bruch1.getZaehler());
    assertEquals(203,bruch1.getNenner());
  }
  
  @Test
  public void testAddieren2() {
    Bruch bruch1 = new Bruch(16,7);
    Bruch bruch2 = new Bruch(8,15);
    bruch1.addieren(bruch2);
    assertEquals(296,bruch1.getZaehler());
    assertEquals(105,bruch1.getNenner());
  }
  
  @Test
  public void testAddieren3() {
    Bruch bruch1 = new Bruch(-3,7);
    Bruch bruch2 = new Bruch(1,7);
    bruch1.addieren(bruch2);
    assertEquals(-2,bruch1.getZaehler());
    assertEquals(7,bruch1.getNenner());
  }
  
  @Test
  public void testSubtrahieren1() {
    Bruch bruch1 = new Bruch(3,7);
    Bruch bruch2 = new Bruch(7,29);
    bruch1.subtrahieren(bruch2);
    assertEquals(38,bruch1.getZaehler());
    assertEquals(203,bruch1.getNenner());
  }
  
  @Test
  public void testSubtrahieren2() {
    Bruch bruch1 = new Bruch(16,7);
    Bruch bruch2 = new Bruch(8,15);
    bruch1.subtrahieren(bruch2);
    assertEquals(184,bruch1.getZaehler());
    assertEquals(105,bruch1.getNenner());
  }
  
  @Test
  public void testSubtrahieren3() {
    Bruch bruch1 = new Bruch(-6,9);
    Bruch bruch2 = new Bruch(3,9);
    bruch1.subtrahieren(bruch2);
    assertEquals(-1,bruch1.getZaehler());
    assertEquals(1,bruch1.getNenner());
  }
  
  @Test
  public void testMultiplizieren1() {
    Bruch bruch1 = new Bruch(3,7);
    Bruch bruch2 = new Bruch(8,9);
    bruch1.multiplizieren(bruch2);
    assertEquals(8,bruch1.getZaehler());
    assertEquals(21,bruch1.getNenner());
  }
  
  @Test
  public void testMultiplizieren2() {
    Bruch bruch1 = new Bruch(-3,7);
    Bruch bruch2 = new Bruch(8,9);
    bruch1.multiplizieren(bruch2);
    assertEquals(-8,bruch1.getZaehler());
    assertEquals(21,bruch1.getNenner());
  }
  
  @Test
  public void testDividieren1() {
    Bruch bruch1 = new Bruch(3,15);
    Bruch bruch2 = new Bruch(6,27);
    bruch1.dividieren(bruch2);
    assertEquals(9,bruch1.getZaehler());
    assertEquals(10,bruch1.getNenner());
  }
  
  @Test
  public void testDividieren2() {
    Bruch bruch1 = new Bruch(-3,15);
    Bruch bruch2 = new Bruch(6,27);
    bruch1.dividieren(bruch2);
    assertEquals(-9,bruch1.getZaehler());
    assertEquals(10,bruch1.getNenner());
  }

}

