package aI.IV;

public class MethodenAufrufe2 {
  
  public static void klsMethode() {
    System.out.println("Klassenmethode der Klasse MethondenAufrufe2");
    MethodenAufrufe1 obj = new MethodenAufrufe1();
    obj.instMethode1();
    MethodenAufrufe1.klsMethode2();
  }
  
  public void instMethode() {
    System.out.println("Instanzmethode der Klasse MethondenAufrufe2");
    MethodenAufrufe1 obj = new MethodenAufrufe1();
    obj.instMethode1();
    MethodenAufrufe1.klsMethode2();
  }
  
}
