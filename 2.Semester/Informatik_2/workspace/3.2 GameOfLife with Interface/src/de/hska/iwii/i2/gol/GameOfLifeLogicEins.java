package de.hska.iwii.i2.gol;

/**
 * Die eigentliche Spielelogik. Das Spielfeld wird hier nicht
 * als zyklisch geschlossen betrachtet.
 *
 * @author Holger Vogelsang
 */
public class GameOfLifeLogicEins implements GameOfLifeLogic {
  
  private boolean[][] startGeneration;
  
  private boolean[][] naechsteGeneration;

  /**
   * Übergibt die Startgeneration.
   * @param generation eine der Startgenerationen.
   */
  public void setStartGeneration(boolean[][] generation) {
	  this.startGeneration = generation;
  }
  
  
  
  /**
   * Geht alle 8 Nachbarzellen durch, falls vorhanden, und überprüft ob diese lebendig sind.
   * @param x Koordinate
   * @param y Koordinate
   * @return Anzahl lebendiger Nachbarzellen.
   */
  private int countAlifeNeighborCells(int x, int y) {
    
    int neighborCellsAlive = 0;
    
    if ((x - 1 >= 0) && (x - 1 < startGeneration.length) && (y - 1 >= 0) && (y - 1 < startGeneration.length)) {
      if (startGeneration[x - 1][y - 1]) {
        neighborCellsAlive++;
      }
    }
    
    if ((y - 1 >= 0) && (y - 1 < startGeneration.length)) {
      if (startGeneration[x][y - 1]) {
        neighborCellsAlive++;
      }
    }
    
    if ((x + 1 >= 0) && (x + 1 < startGeneration.length) && (y - 1 >= 0) && (y - 1 < startGeneration.length)) {
      if (startGeneration[x + 1][y - 1]) {
        neighborCellsAlive++;
      }
    }
    
    if ((x + 1 >= 0) && (x + 1 < startGeneration.length)) {
      if (startGeneration[x + 1][y]) {
        neighborCellsAlive++;
      }
    }
    
    if ((x + 1 >= 0) && (x + 1 < startGeneration.length) && (y + 1 >= 0) && (y + 1 < startGeneration.length)) {
      if (startGeneration[x + 1][y + 1]) {
        neighborCellsAlive++;
      }
    }
    
    if ((y + 1 >= 0) && (y + 1 < startGeneration.length)) {
      if (startGeneration[x][y + 1]) {
        neighborCellsAlive++;
      }
    }
    
    if ((x - 1 >= 0) && (x - 1 < startGeneration.length) && (y + 1 >= 0) && (y + 1 < startGeneration.length)) {
      if (startGeneration[x - 1][y + 1]) {
        neighborCellsAlive++;
      }
    }
    
    if ((x - 1 >= 0) && (x - 1 < startGeneration.length)) {
      if (startGeneration[x - 1][y]) {
        neighborCellsAlive++;
      }
    }
    
    return neighborCellsAlive;
  }
  
  

  /**
   * Berechnet nach den Spielregeln die neue Generation aus der startGeneration, speichert sie in einem neuen
   * Feld und überschreibt nach der Berechnung die alte Generation mit der neuen und setzt das Feld der neuen
   * Generation wieder auf false für alle Positionen.
   */
  public void nextGeneration() {
    
    naechsteGeneration = new boolean[startGeneration.length][startGeneration[0].length];
    
    // Zaehlt die lebendigen Nachbarzellen
    int neighborCellsAlive;
    
    for (int x = 0; x < startGeneration.length; x++) {
      for (int y = 0; y < startGeneration[0].length; y++) {
        
        // Geht alle 8 Nachbarzellen durch, falls vorhanden, und überprüft ob diese lebendig sind
        neighborCellsAlive = this.countAlifeNeighborCells(x, y);
        
        // Zelle lebt
        if (startGeneration[x][y]) {
          
          // lebt weiter wenn, zwei oder drei Nachbarn leben in gleicher Generation
          if ((neighborCellsAlive == 2) || (neighborCellsAlive == 3)) {
            naechsteGeneration[x][y] = true;
          }
          
          // stirbt an Überbevölkerung wenn mehr als 3 Nachbarn in gleicher Generation leben oder
          //stirbt an Vereinsamung wenn weniger als 2 Nachbarn in gleicher Generation leben
          if ((neighborCellsAlive > 3) | (neighborCellsAlive < 2)) {
            naechsteGeneration[x][y] = false;
          }
        } else {  // Zelle lebt nicht
          // Zelle wird lebendig wenn genau 3 Nachbarn in gleicher Generation leben
          if (neighborCellsAlive == 3) {
            naechsteGeneration[x][y] = true;
          }
        }
      }
    }
    
    // Überschreiben der alten Generation mit der gerade neu berechneten und zurücksetzen der naechsten Generation
    for (int x = 0; x < startGeneration.length; x++) {
      for (int y = 0; y < startGeneration[0].length; y++) {
        startGeneration[x][y] = naechsteGeneration[x][y];
        naechsteGeneration[x][y] = false;
      }
    }  
  }
  
  

  /**
   * Testet, ob die Zelle an der Position (x,y) in der aktuellen Generation lebt.
   * @param x Kooridnate
   * @param y Koordinate
   * @return true genau dann wenn die Zelle an der Position (x,y) in der aktuellen
   * Generation lebt. Ansonsten false.
   */
  public boolean isCellAlive(int x, int y) {
     return this.startGeneration[x][y];
  }
}