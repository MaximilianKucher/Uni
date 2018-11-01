package aufgabe.vier;

import static org.junit.Assert.assertEquals;

import aufgabe.vier.Bruch;

import org.junit.Test;




public class BruchTest {
  
  
  /**
   * Erzeugt einen Bruch mit ganzzahligem Zaehler und ganzzahligem Nenner ungleich 0.
   */
  @Test
  public void testBruch1() {
    Bruch bruch = new Bruch(25,36);
    assertEquals(25, bruch.getZaehler());
    assertEquals(36, bruch.getNenner());
  }
  
  
  
  /**
   * Versucht einen Bruch mit Nenner gleich 0 zu erzeugen.
   */
  @Test(expected = AssertionError.class)
  public void testBruch2() {
    Bruch bruch = new Bruch(7,0);
    assertEquals(null, bruch);
  }
  
  
 
  
  @Test
  public void testGroessterGemeinsamerTeiler() {
    assertEquals(25, Bruch.groessterGemeinsamerTeiler(25,25));
    assertEquals(2, Bruch.groessterGemeinsamerTeiler(2,4));
    assertEquals(1, Bruch.groessterGemeinsamerTeiler(-7,17));
  }
  
  
  
  
  /**
   * Zaehler und Nenner sind unterschiedliche Primzahlen.
   */
  @Test
  public void testKuerzen1() {
    Bruch bruch = new Bruch(7,17);
    assertEquals(7, bruch.kuerzen().getZaehler());
    assertEquals(17, bruch.kuerzen().getNenner());
    assertEquals(7, bruch.getZaehler());
    assertEquals(17, bruch.getNenner());
  }
  
  
  
  
  /**
   * Bruch lässt sich kuerzen mit 100.
   */
  @Test
  public void testKuerzen2() {
    Bruch bruch = new Bruch(100,-1000);
    assertEquals(1, bruch.kuerzen().getZaehler());
    assertEquals(-10, bruch.kuerzen().getNenner());
    assertEquals(100, bruch.getZaehler());
    assertEquals(-1000, bruch.getNenner());
  }
  
  
  
  /**
   * Addieren zweier Brueche, beim addieren bleiben die Summanden unverändert.
   */
  @Test
  public void testAddieren1() {
    Bruch bruch1 = new Bruch(3,7);
    Bruch bruch2 = new Bruch(7,29);
    assertEquals(136,bruch1.addieren(bruch2).getZaehler());
    assertEquals(203,bruch1.addieren(bruch2).getNenner());
    assertEquals(3,bruch1.getZaehler());
    assertEquals(7,bruch1.getNenner());
    assertEquals(7,bruch2.getZaehler());
    assertEquals(29,bruch2.getNenner());
  }
  
  
  
  
  /**
   * Addieren zweier Brueche mit gleichem Nenner.
   */
  @Test
  public void testAddieren2() {
    Bruch bruch1 = new Bruch(-3,7);
    Bruch bruch2 = new Bruch(1,7);
    assertEquals(-2,bruch1.addieren(bruch2).getZaehler());
    assertEquals(7,bruch1.addieren(bruch2).getNenner());
    assertEquals(-3,bruch1.getZaehler());
    assertEquals(7,bruch1.getNenner());
    assertEquals(1,bruch2.getZaehler());
    assertEquals(7,bruch2.getNenner());
  }
  
  
  
  
  @Test
  public void testSubtrahieren1() {
    Bruch bruch1 = new Bruch(3,7);
    Bruch bruch2 = new Bruch(7,29);
    assertEquals(38,bruch1.subtrahieren(bruch2).getZaehler());
    assertEquals(203,bruch1.subtrahieren(bruch2).getNenner());
    assertEquals(3,bruch1.getZaehler());
    assertEquals(7,bruch1.getNenner());
    assertEquals(7,bruch2.getZaehler());
    assertEquals(29,bruch2.getNenner());
  }
  
  
  
  
  /**
   * Subtrahieren zweier Brueche mit gleichem Nenner.
   */
  @Test
  public void testSubtrahieren2() {
    Bruch bruch1 = new Bruch(-3,7);
    Bruch bruch2 = new Bruch(12,7);
    assertEquals(-15,bruch1.subtrahieren(bruch2).getZaehler());
    assertEquals(7,bruch1.subtrahieren(bruch2).getNenner());
    assertEquals(-3,bruch1.getZaehler());
    assertEquals(7,bruch1.getNenner());
    assertEquals(12,bruch2.getZaehler());
    assertEquals(7,bruch2.getNenner());
  }
  
  
  
  
  @Test
  public void testMultiplizieren1() {
    Bruch bruch1 = new Bruch(3,7);
    Bruch bruch2 = new Bruch(8,9);
    assertEquals(8, bruch1.multiplizieren(bruch2).getZaehler());
    assertEquals(21, bruch1.multiplizieren(bruch2).getNenner());
    assertEquals(3,bruch1.getZaehler());
    assertEquals(7,bruch1.getNenner());
    assertEquals(8,bruch2.getZaehler());
    assertEquals(9,bruch2.getNenner());
  }
  
  
  
  @Test
  public void testMultiplizieren2() {
    Bruch bruch1 = new Bruch(13,19);
    Bruch bruch2 = new Bruch(-27,7);
    assertEquals(-351, bruch1.multiplizieren(bruch2).getZaehler());
    assertEquals(133, bruch1.multiplizieren(bruch2).getNenner());
    assertEquals(13,bruch1.getZaehler());
    assertEquals(19,bruch1.getNenner());
    assertEquals(-27,bruch2.getZaehler());
    assertEquals(7,bruch2.getNenner());
  }
  
  
  
  @Test
  public void testDividieren1() {
    Bruch bruch1 = new Bruch(3,15);
    Bruch bruch2 = new Bruch(6,27);
    assertEquals(9, bruch1.dividieren(bruch2).getZaehler());
    assertEquals(10, bruch1.dividieren(bruch2).getNenner());
    assertEquals(3,bruch1.getZaehler());
    assertEquals(15,bruch1.getNenner());
    assertEquals(6,bruch2.getZaehler());
    assertEquals(27,bruch2.getNenner());
  }
  
  
  
  
  @Test
  public void testDividieren2() {
    Bruch bruch1 = new Bruch(-3,16);
    Bruch bruch2 = new Bruch(12,7);
    assertEquals(-7, bruch1.dividieren(bruch2).getZaehler());
    assertEquals(64, bruch1.dividieren(bruch2).getNenner());
    assertEquals(-3,bruch1.getZaehler());
    assertEquals(16,bruch1.getNenner());
    assertEquals(12,bruch2.getZaehler());
    assertEquals(7,bruch2.getNenner());
  }

}
