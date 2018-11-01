package aufgabe.sieben;

import static org.junit.Assert.*;

import aufgabe.sieben.DoppeltVerketteteListe;

import org.junit.Test;



public class DoppeltVerkettetListeStringTest {

  /**
   * Erzeugen einer doppelt verketteten Liste mit 0 Elementen.
   */
  @Test
  public void testDoppeltVerketteteListe() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    assertEquals(null, list.getFirst());
    assertEquals(null, list.getLast());
    assertEquals(0, list.getSize());
  }
  
  
  
  
  /**
   * Einfügen eines Elements an das Ende der leeren Liste.
   */
  @Test
  public void testAddLast1() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.addLast("hallo");
    assertEquals("hallo", list.getFirst().getData());
    assertEquals("hallo", list.getLast().getData());
    assertEquals(1, list.getSize());
  }
  
  
  

  /**
   * Einfügen eines Elements an den Anfang der leeren Liste.
   */
  @Test
  public void testAddFirst1() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.addFirst("hallo");
    assertEquals("hallo", list.getFirst().getData());
    assertEquals("hallo", list.getLast().getData());
    assertEquals(1, list.getSize());
  }
  
  
  
  
  /**
   * Einfügen mehrerer Elemente am Anfung and am Ende der leeren Liste.
   */
  @Test
  public void testAddFirst2() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.addFirst("hallo");
    list.addFirst("name");
    list.addLast("datum");
    assertEquals("name", list.getFirst().getData());
    assertEquals("datum", list.getLast().getData());
    assertEquals(3, list.getSize());
  }
  
  
  
  
  /**
   * Einfügen eines Elements mit add() in eine leere Liste.
   */
  @Test
  public void testAdd1() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.add(1, "hallo");
    assertEquals("hallo", list.getFirst().getData());
    assertEquals("hallo", list.getLast().getData());
    assertEquals(1, list.getSize());
  }
  
  
  
  
  /**
   * Einfügen eines Elements mit add() an eine Position größer als die Länge der Liste.
   */
  @Test
  public void testAdd2() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.add(363, "hallo");
    assertEquals("hallo", list.getFirst().getData());
    assertEquals("hallo", list.getLast().getData());
    assertEquals(1, list.getSize());
  }
  
  
  
  
  /**
   * Einfügen eines Elements mit add() an eine Position zwischen Anfang und Ende der Liste.
   */
  @Test
  public void testAdd3() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.addFirst("hallo");
    list.addFirst("name");
    list.addLast("datum");
    list.add(3, "drei");
    assertEquals("name", list.getFirst().getData());
    assertEquals("drei", list.getLast().getData());
    assertEquals(4, list.getSize());
    assertEquals("drei", list.get(4));
    assertEquals("hallo", list.get(2));
  }
  
  
  
  
  /**
   * Einfügen eines Elements mit add() an einer Position die kleiner als 1 ist.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAdd4() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.addFirst("hallo");
    list.addFirst("name");
    list.addLast("datum");
    list.add(-3, "minusdrei");
  }
  
  
  
  
  /**
   * Auslesen der Daten an Indizes die auch in der Liste vorkommen.
   */
  @Test
  public void testGet1() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.addFirst("hallo");
    list.addFirst("name");
    list.addLast("datum");
    assertEquals("name", list.get(1));
    assertEquals("hallo", list.get(2));
    assertEquals("datum", list.get(3));
  }
  
  
  
  
  /**
   * Auslesen der Daten an einem Index kleiner/gleich 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGet2() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.addFirst("hallo");
    list.addFirst("name");
    list.addLast("datum");
    list.get(-3);
  }


  
  
  /**
   * Entfernen des ersten Elements aus einer nichtleeren Liste.
   */
  @Test
  public void testRemoveFirst1() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.addFirst("hallo");
    list.addFirst("name");
    list.addLast("datum");
    assertEquals("name", list.getFirst().getData());
    assertEquals(3, list.getSize());
    list.removeFirst();
    assertEquals("hallo", list.getFirst().getData());
    assertEquals(2, list.getSize());
  }
  
  
  
  
  /**
   * Entfernen des ersten Elements aus einer leeren Liste.
   */
  @Test(expected = AssertionError.class)
  public void testRemoveFirst2() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.removeFirst();
  }
  
  
  
  
  /**
   * Entfernen des letzten Elements aus einer nichtleeren Liste.
   */
  @Test
  public void testRemoveLast1() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.addFirst("hallo");
    list.addFirst("name");
    list.addLast("datum");
    assertEquals("datum", list.getLast().getData());
    assertEquals(3, list.getSize());
    list.removeLast();
    assertEquals("hallo", list.getLast().getData());
    assertEquals(2, list.getSize());
  }
  
  
  
  
  /**
   * Entfernen des letzten Elements aus einer leeren Liste.
   */
  @Test(expected = AssertionError.class)
  public void testRemoveLast2() {
    DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
    list.removeLast();
  } 

}
