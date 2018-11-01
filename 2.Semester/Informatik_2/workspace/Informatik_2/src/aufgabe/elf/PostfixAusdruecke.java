package aufgabe.elf;

import java.util.*;

public class PostfixAusdruecke {
  
  public static void main(String[] args) {
    upn("15 42 18 + 61 24 - * 71 + *"); 
    upn("36 14 + 69 * 25 - 25 36 * +");
  }
  
  public static void upn(String ausdruck) {
    ArrayList<Integer> numberStack = new ArrayList<Integer>();
    int counter = -1;
    int speicher = 0;
    
    StringTokenizer st = new StringTokenizer(ausdruck);
    
    while (st.hasMoreTokens()) {
      String nextToken = st.nextToken();
      if (!nextToken.equals("+") && !nextToken.equals("*") && !nextToken.equals("-")) {
        numberStack.add(Integer.parseInt(nextToken));
        counter++;
      }
      if (nextToken.equals("+")) {
        speicher = numberStack.get(counter) + numberStack.get(counter - 1);
        numberStack.remove(counter);
        numberStack.remove(counter - 1);
        counter--;
        numberStack.add(speicher);
      }
      if (nextToken.equals("-")) {
        speicher = numberStack.get(counter - 1) - numberStack.get(counter);
        numberStack.remove(counter);
        numberStack.remove(counter - 1);
        counter--;
        numberStack.add(speicher);
      }
      if (nextToken.equals("*")) {
        speicher = numberStack.get(counter) * numberStack.get(counter - 1);
        numberStack.remove(counter);
        numberStack.remove(counter - 1);
        counter--;
        numberStack.add(speicher);
      }
    }
    
    System.out.println("Ergebnis: " + numberStack.get(0));
  }
}
