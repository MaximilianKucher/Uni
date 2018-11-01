package de.hska.iwii.i2.gol;

/**
 * Die eigentliche Spielelogik. Das Spielfeld wird hier nicht
 * als zyklisch geschlossen betrachtet.
 */
public interface GameOfLifeLogic {
  
  /**
   * Testet, ob die Zelle an der Position (x,y) in der aktuellen Generation lebt.
   * @param x Kooridnate
   * @param y Koordinate
   * @return true genau dann wenn die Zelle an der Position (x,y) in der aktuellen
   * Generation lebt. Ansonsten false.
   */
  boolean isCellAlive(int x, int y);
  
  /**
   * Berechnet nach den Spielregeln die neue Generation aus der startGeneration,
   * speichert sie in einem neuen Feld und überschreibt nach der Berechnung die 
   * alte Generation mit der neuen und setzt das Feld der neuenGeneration wieder
   * auf false für alle Positionen.
   */
  void nextGeneration();
  
  /**
   * Übergibt die Startgeneration.
   * @param generation eine der Startgenerationen.
   */
  void setStartGeneration(boolean[][] generation);

}
