package aI.III;

public class FeldZugriffe {
  static int zaehlerAlsKlassenfeld;
  int zaehlerAlsInstanzfeld;
  
  public FeldZugriffe() {
    zaehlerAlsKlassenfeld++;
    zaehlerAlsInstanzfeld++;
  }
  
  public static void anzeigeKlsMeth() {
    System.out.println(zaehlerAlsKlassenfeld);
    FeldZugriffe feldZugriffeObj = new FeldZugriffe();
    System.out.println(feldZugriffeObj.zaehlerAlsInstanzfeld);
  }
  
  public void anzeigeInstMeth() {
    System.out.println(zaehlerAlsKlassenfeld);
    System.out.println(this.zaehlerAlsInstanzfeld);
  }
}
