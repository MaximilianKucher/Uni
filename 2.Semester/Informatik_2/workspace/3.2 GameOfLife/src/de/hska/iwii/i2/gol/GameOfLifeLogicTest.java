package de.hska.iwii.i2.gol;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Testklasse der Spiellogik.
 * @author Max
 *
 */
public class GameOfLifeLogicTest {

  /**
   * Block aus 2x2 Zellen in einer Ecke.
   */
  @Test
  public void testNextGeneration1() {
    
    boolean[][] newGame = new boolean[][]{
      // 0      1      2      3      4      5      6      7      8      9
      {true,  true,  false, false, false, false, false, false, false, false},
      {true,  true,  false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false}
    };
    
    GameOfLifeLogic golLogic = new GameOfLifeLogic();
    golLogic.setStartGeneration(newGame);
    golLogic.nextGeneration();
    
    // Alle lebenden Zellen haben genau drei lebende Nachbarn, sollten also in der nächsten Generation weiterleben.
    assertTrue(golLogic.isCellAlive(0, 0));
    assertTrue(golLogic.isCellAlive(0, 1));
    assertTrue(golLogic.isCellAlive(1, 0));
    assertTrue(golLogic.isCellAlive(1, 1));
    
    // Alle nicht lebendigen Nachbarn der lebenden Zellen haben je nur 2 lebende Nachbarn, sollten also in der nächsten Generation tot bleiben.
    assertFalse(golLogic.isCellAlive(0, 2));
    assertFalse(golLogic.isCellAlive(1, 2));
    assertFalse(golLogic.isCellAlive(2, 2));
    assertFalse(golLogic.isCellAlive(2, 1));
    assertFalse(golLogic.isCellAlive(2, 0));
  }
 
  
  /**
   * Block aus 3x2 Zellen am Rand.
   */
  @Test
  public void testNextGeneration2() {
    
    boolean[][] newGame = new boolean[][]{
      // 0      1      2      3      4      5      6      7      8      9
      {false, false, false, true,  true,  true,  false, false, false, false},
      {false, false, false, true,  true,  true,  false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false}
    };
    
    GameOfLifeLogic golLogic = new GameOfLifeLogic();
    golLogic.setStartGeneration(newGame);
    golLogic.nextGeneration();
    
    // Zellen bleiben lebendig.
    assertTrue(golLogic.isCellAlive(0, 3));
    assertTrue(golLogic.isCellAlive(0, 5));
    assertTrue(golLogic.isCellAlive(1, 3));
    assertTrue(golLogic.isCellAlive(1, 5));
    
    // Zelle wird geboren.
    assertTrue(golLogic.isCellAlive(2, 4));
    
    // Zellen sterben.
    assertFalse(golLogic.isCellAlive(0, 4));
    assertFalse(golLogic.isCellAlive(1, 4));
    
    // Nachbarzellen der lebendigen Zellen die tot bleiben.
    assertFalse(golLogic.isCellAlive(0, 2));
    assertFalse(golLogic.isCellAlive(1, 2));
    assertFalse(golLogic.isCellAlive(2, 2));
    assertFalse(golLogic.isCellAlive(2, 3));
    assertFalse(golLogic.isCellAlive(2, 5));
    assertFalse(golLogic.isCellAlive(2, 6));
    assertFalse(golLogic.isCellAlive(1, 6));
    assertFalse(golLogic.isCellAlive(0, 6));
  }
  
  
  /**
   * Block aus 3x3 Zellen in der Mitte.
   */
  @Test
  public void testNextGeneration3() {
    
    boolean[][] newGame = new boolean[][]{
      // 0      1      2      3      4      5      6      7      8      9
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, true,  true,  true,  false, false, false, false},
      {false, false, false, true,  true,  true,  false, false, false, false},
      {false, false, false, true,  true,  true,  false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false}
    };
    
    GameOfLifeLogic golLogic = new GameOfLifeLogic();
    golLogic.setStartGeneration(newGame);
    golLogic.nextGeneration();
    
    // Zellen bleiben lebendig
    assertTrue(golLogic.isCellAlive(4, 3));
    assertTrue(golLogic.isCellAlive(4, 5));
    assertTrue(golLogic.isCellAlive(6, 3));
    assertTrue(golLogic.isCellAlive(6, 5));
    
    // Zellen werden geboren
    assertTrue(golLogic.isCellAlive(3, 4));
    assertTrue(golLogic.isCellAlive(5, 6));
    assertTrue(golLogic.isCellAlive(7, 4));
    assertTrue(golLogic.isCellAlive(5, 2));
    
    // Zellen sterben
    assertFalse(golLogic.isCellAlive(4, 4));
    assertFalse(golLogic.isCellAlive(5, 4));
    assertFalse(golLogic.isCellAlive(6, 4));
    assertFalse(golLogic.isCellAlive(5, 3));
    assertFalse(golLogic.isCellAlive(5, 5));
    
    // Nachbarzellen der lebendigen Zellen die tot bleiben.
    assertFalse(golLogic.isCellAlive(3, 2));
    assertFalse(golLogic.isCellAlive(3, 3));
    assertFalse(golLogic.isCellAlive(3, 5));
    assertFalse(golLogic.isCellAlive(3, 6));
    assertFalse(golLogic.isCellAlive(4, 2));
    assertFalse(golLogic.isCellAlive(4, 6));
    assertFalse(golLogic.isCellAlive(6, 2));
    assertFalse(golLogic.isCellAlive(6, 6));
    assertFalse(golLogic.isCellAlive(7, 2));
    assertFalse(golLogic.isCellAlive(7, 3));
    assertFalse(golLogic.isCellAlive(7, 5));
    assertFalse(golLogic.isCellAlive(7, 6));
  }
  
  /**
   * Behive.
   */
  @Test
  public void testNextGeneration4() {
    
    boolean[][] newGame = new boolean[][]{
      // 0      1      2      3      4      5      6      7      8      9
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, true,  true,  false, false, false, false},
      {false, false, false, true,  false, false, true,  false, false, false},
      {false, false, false, false, true,  true,  false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false},
      {false, false, false, false, false, false, false, false, false, false}
    };
    
    GameOfLifeLogic golLogic = new GameOfLifeLogic();
    golLogic.setStartGeneration(newGame);
    golLogic.nextGeneration();
    
    // Zellen bleiben lebendig
    assertTrue(golLogic.isCellAlive(4, 3));
    assertTrue(golLogic.isCellAlive(3, 4));
    assertTrue(golLogic.isCellAlive(3, 5));
    assertTrue(golLogic.isCellAlive(4, 6));
    assertTrue(golLogic.isCellAlive(5, 5));
    assertTrue(golLogic.isCellAlive(5, 4));
    
    // Es werden keine Zellen geboren
    
    // Es sterben keine Zellen
    
    // Nachbarzellen der lebendigen Zellen die tot bleiben.
    assertFalse(golLogic.isCellAlive(3, 2));
    assertFalse(golLogic.isCellAlive(3, 3));
    assertFalse(golLogic.isCellAlive(2, 3));
    assertFalse(golLogic.isCellAlive(2, 4));
    assertFalse(golLogic.isCellAlive(2, 5));
    assertFalse(golLogic.isCellAlive(2, 6));
    assertFalse(golLogic.isCellAlive(3, 6));
    assertFalse(golLogic.isCellAlive(3, 7));
    assertFalse(golLogic.isCellAlive(4, 7));
    assertFalse(golLogic.isCellAlive(5, 7));
    assertFalse(golLogic.isCellAlive(5, 6));
    assertFalse(golLogic.isCellAlive(6, 6));
    assertFalse(golLogic.isCellAlive(6, 5));
    assertFalse(golLogic.isCellAlive(6, 4));
    assertFalse(golLogic.isCellAlive(6, 3));
    assertFalse(golLogic.isCellAlive(5, 3));
    assertFalse(golLogic.isCellAlive(5, 2));
    assertFalse(golLogic.isCellAlive(4, 2));
    assertFalse(golLogic.isCellAlive(4, 4));
    assertFalse(golLogic.isCellAlive(4, 5));
    }
}
