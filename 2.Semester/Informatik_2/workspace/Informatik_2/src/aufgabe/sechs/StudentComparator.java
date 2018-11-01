package aufgabe.sechs;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
  
  
  /**
   * Vergleicht zwei Studenten zuerst nach Nachname, Vorname und zuletzt nach
   * Matrikelnummer falls alles davor gleich sein sollte.
   */
  @Override
  public int compare(Student o1, Student o2) {
    
    // sind die Nachnamen gleich ?
    if (o1.getLastname().equals(o2.getLastname())) {
      
      // sind die Vornamen gleich ?
      if (o1.getFirstname().equals(o2.getFirstname())) {
        
        // sind die Matrikelnummern gleich ?
        if (o1.getMatriculationNumber() == o2.getMatriculationNumber()) {
          return 0;
          
          // Matrikelnummern sind nicht gleich
        } else {
          
          if (o1.getMatriculationNumber() > o2.getMatriculationNumber()) {
            return 1;
          } else {
            return -1;
          }
        }
        
        // Vornamen sind nicht gleich
      } else {
        int laengeKuerzesterVorname = Math.min(o1.getFirstname().length(), o2.getFirstname().length());
        for (int i = 0; i < laengeKuerzesterVorname; i++) {
          if (o1.getFirstname().charAt(i) > o2.getFirstname().charAt(i)) {
            return 1;
          } else if (o1.getFirstname().charAt(i) < o2.getFirstname().charAt(i)) {
            return -1;
          }
        }
        return 0;
      }
      
      // Nachnamen sind nicht gleich
    } else {
      int laengeKuerzesterNachname = Math.min(o1.getLastname().length(), o2.getLastname().length());
      for (int i = 0; i < laengeKuerzesterNachname; i++) {
        if (o1.getLastname().charAt(i) > o2.getLastname().charAt(i)) {
          return 1;
        } else if (o1.getLastname().charAt(i) < o2.getLastname().charAt(i)) {
          return -1;
        }
      }
      return 0;
    }
  }
}
