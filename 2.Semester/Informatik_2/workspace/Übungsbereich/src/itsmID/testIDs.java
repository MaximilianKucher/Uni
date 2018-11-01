package itsmID;

import java.util.Scanner;

public class testIDs {

  public static void main(String[] args) {
    while(true) {
      String[] IDs = new String[150];
      Scanner sc = new Scanner(System.in);
      System.out.println("ID eingeben:");
      String nextID = sc.next();
      int i = 0;
      boolean vorhanden = false;
      
      while(IDs[i] != null) {
        i++;
      }
    
      for(int j = 0; j < 150; j++) {
        if(IDs[j] != null && IDs[j].equals(nextID)) {
           System.out.println("ID schon vorhanden.");
           vorhanden = true;
        }
      }
      if(!vorhanden) {
        IDs[i] = nextID;
      }
      sc.close();
    }
    
  }

}
