package aufgabe.neun;

public class Zustandsuebergangstabelle {
  
  static int [][] states = new int[][] {{1,1}, {2,3}, {2,4}, {2,3}, {2,3}};
  static int aktuellerZustand = 0;
  
  public static void main(String[] args) {
    
    // Eingabewort: 01100100111001
    zustandsuebergang(0);
    zustandsuebergang(1);
    zustandsuebergang(1);
    zustandsuebergang(0);
    zustandsuebergang(0);
    zustandsuebergang(1);
    zustandsuebergang(0);
    zustandsuebergang(0);
    zustandsuebergang(1);
    zustandsuebergang(1);
    zustandsuebergang(1);
    zustandsuebergang(0);
    zustandsuebergang(0);
    zustandsuebergang(1);
    
    
    System.out.println(aktuellerZustand);
  }
  
  public static int zustandsuebergang(int eingabezeichen) {
    aktuellerZustand = states[aktuellerZustand][eingabezeichen];
    return aktuellerZustand;
  }

}
