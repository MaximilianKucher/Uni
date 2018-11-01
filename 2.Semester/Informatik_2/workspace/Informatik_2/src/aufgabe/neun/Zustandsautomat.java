package aufgabe.neun;

public class Zustandsautomat {
  private static final String zustand_0 = "z0";
  private static final String zustand_1 = "z1";
  private static final String zustand_2 = "z2";
  private static final String zustand_3 = "z3";
  private static final String zustand_4 = "z4";
  
  private static String aktuellerZustand = "z0";
  
  public static void main(String[] args) {
    zustandsuebergaenge("00000000");
    System.out.println(aktuellerZustand);
  }
  
  public static void zustandsuebergaenge(String eingabewort) {
    
    // dient dazu das erste Zeichen aus dem Eingabewort zu speichern
    boolean zeichen;
    
    
    while (eingabewort != "") {
      if (eingabewort.startsWith("0"))
        zeichen = false;
      else
        zeichen = true;
      
      if (eingabewort.length() == 1)
        eingabewort = "";
      else
        eingabewort = eingabewort.substring(1);
      
      
      switch(aktuellerZustand) {
      case zustand_0:
        aktuellerZustand = zustand_1;
        break;
        
      case zustand_1:
        if (zeichen) 
          aktuellerZustand = zustand_3;
        else
          aktuellerZustand = zustand_2;
        break;
        
      case zustand_2:
        if (zeichen)
          aktuellerZustand = zustand_4;
        break;
        
      case zustand_3:
        if (!zeichen)
          aktuellerZustand = zustand_2;
        break;
      
      case zustand_4:
        if (zeichen)
          aktuellerZustand = zustand_3;
        else
          aktuellerZustand = zustand_2;
        break;
      
      default: break;          
      }
    }
  }
  
  
}
