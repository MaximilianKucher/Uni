package aufgabe.sechs;

import java.util.ArrayList;

/**
 * Ein Student mit eindeutiger Matrikelnummer, Nachname und Vorname.
 * @author kuma1050
 *
 */
public class Student {
  
  private int matriculationNumber;
  private String firstname;
  private String lastname;
  
  private static ArrayList<Student> liste = new ArrayList<Student>();
  private static StudentComparator c = new StudentComparator();
  
  /**
   * Erzeugt einen neuen Studenten mit Vorname, Nachname und Matrikelnummer.
   * @param matriculationNumber Matrikelnummer, 5-stellig.
   * @param firstname Vorname
   * @param lastname Nachname
   */
  public Student(int matriculationNumber, String firstname, String lastname) {
    this.matriculationNumber = matriculationNumber;
    this.firstname = firstname;
    this.lastname = lastname;
  }
  
  /**
   * Wir testen einmal das sortieren der arraylist.
   */
  public static void main(String[] args) {
    Student student1 = new Student(54872, "Max", "Kucher");
    liste.add(student1);
    Student student2 = new Student(53369, "Alexander", "Erfort");
    liste.add(student2);
    Student student3 = new Student(14785, "Dimitry", "Klokov");
    liste.add(student3);
    Student student4 = new Student(69853, "Mark", "Bell");
    liste.add(student4);
    Student student5 = new Student(32564, "Mike", "Silent");
    liste.add(student5);
    
    System.out.println("liste unsortiert:");
    
    for (Student student: liste) {
      System.out.println(student.lastname);
    }
    
    System.out.println();
    liste.sort(c);
    System.out.println("liste sortiert:");
    
    for (Student student: liste) {
      System.out.println(student.lastname);
    }  
  }
  
  public int getMatriculationNumber() {
    return matriculationNumber;
  }
  
  public void setMatriculationNumber(int matriculationNumber) {
    this.matriculationNumber = matriculationNumber;
  }
  
  public String getFirstname() {
    return firstname;
  }
  
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  
  public String getLastname() {
    return lastname;
  }
  
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
  
}
