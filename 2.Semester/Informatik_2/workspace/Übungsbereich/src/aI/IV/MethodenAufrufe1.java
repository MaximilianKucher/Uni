package aI.IV;

public class MethodenAufrufe1 {
  
  public static void klsMethode1() {
    System.out.println("1. Klassenmethode der Klasse MethodenAufrufe1");
  }
  
  public static void klsMethode2() {
    System.out.println("2. Klassenmethode der Klasse MethodenAufrufe1");
    MethodenAufrufe1 obj = new MethodenAufrufe1();
    obj.instMethode2();
    MethodenAufrufe1.klsMethode1();
  }
  
  public void instMethode1() {
    System.out.println("1. Instanzmethode der Klasse MethodenAufrufe1");
    instMethode2();
    MethodenAufrufe1.klsMethode1();
  }
  
  public void instMethode2() {
    System.out.println("2. Instanzmethode der Klasse MethodenAufrufe1");
  }
  
}
