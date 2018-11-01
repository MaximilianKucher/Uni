package aufgabe.vier;



/**
 * Ein Bruch bestehend aus Z�hler und Nenner.
 * Br�che k�nnen addiert, subtrahiert, multipliziert und dividiert werden.
 * Br�che sind immer vollst�ndig gek�rzt.
 * @author Max
 *
 */
public class Bruch {
  
  private int zaehler;
  private int nenner;
  
  
  
  
  /**
   * Standardkonstruktor.
   */
  public Bruch() {

  }
  
  
  
  
  
  /**
   * Erzeugt einen neuen Bruch mit ganzzahligem Z�hler und positivem ganzzahligem Nenner.
   * @param zaehler ganzzahlig.
   * @param nenner ganzzahlig und muss gr��er als 0 sein.
   */
  public Bruch(int zaehler, int nenner) {
    assert nenner != 0;
    this.zaehler = zaehler;
    this.nenner = nenner;
  }
  
  
  
  
  
  /**
   * K�rzt einen Bruch indem mit dem euklidischen Alogrithmus der ggT von Z�hler
   * und Nenner ermittelt wird und anschlie�end Z�hler und Nenner durch den ggT
   * geteilt werden.
   */
  public Bruch kuerzen() {
    Bruch neuerBruch = new Bruch(this.zaehler / groessterGemeinsamerTeiler(this.zaehler,this.nenner),
                                 this.nenner / groessterGemeinsamerTeiler(this.zaehler,this.nenner));
    
    return neuerBruch;
  }
  
  
  
  
  
  /**
   * Berechnet aus zwei gegebenen ganzen Zahlen den groessten gemeinsamen Teiler.
   * @param value1 ganze Zahl
   * @param value2 ganze Zahl
   * @return den ggT von value1 und value2
   */
  public static int groessterGemeinsamerTeiler(int value1, int value2) {
    value1 = Math.abs(value1);
    value2 = Math.abs(value2);
    while (value2 != 0) {
      if (value1 > value2) {
        value1 = value1 - value2;
      } else {
        value2 = value2 - value1;
      }
    }
    return value1;
  }
  
  
  
  
  
  /**
   * Addiert zwei Br�che indem sie zuerst auf den gleichen Nenner gebracht
   * und danach die Z�hler addiert werden. Dann wird gek�rzt.
   * @param bruch ein Bruchobjekt.
   */
  public Bruch addieren(Bruch bruch) {
    Bruch neuerBruch = new Bruch(this.zaehler, this.nenner);
    
    if (neuerBruch.nenner == bruch.nenner) {
      neuerBruch.zaehler += bruch.zaehler;
    } else {
      neuerBruch.nenner *= bruch.nenner;
      neuerBruch.zaehler *= bruch.nenner;
      neuerBruch.zaehler += bruch.zaehler * this.nenner;
    }
    
    return neuerBruch.kuerzen();
  }
  
  
  
  
  
  /**
   * Subtrahiert zwei Br�che voneinander indem sie zuerst auf den gleichen Nenner
   * gebracht und danach die Z�hler subtrahiert werden. Dann wird gek�rzt.
   * @param bruch ein Bruchobjekt.
   */
  public Bruch subtrahieren(Bruch bruch) {
    Bruch neuerBruch = new Bruch(this.zaehler, this.nenner);
    
    if (neuerBruch.nenner == bruch.nenner) {
      neuerBruch.zaehler -= bruch.zaehler;
    } else {
      neuerBruch.nenner *= bruch.nenner;
      neuerBruch.zaehler *= bruch.nenner;
      neuerBruch.zaehler -= bruch.zaehler * this.nenner;
    }
    
    return neuerBruch.kuerzen();
  }
  
  
  
  
  
  /**
   * Multipliziert zwei Br�che, indem jweils die beiden Z�hler bzw. Nenner
   * miteinander multipliziert werden.
   * @param bruch ein Bruchobjekt.
   */
  public Bruch multiplizieren(Bruch bruch) {
    Bruch neuerBruch = new Bruch(this.zaehler, this.nenner);
    
    neuerBruch.zaehler *= bruch.zaehler;
    neuerBruch.nenner *= bruch.nenner;
    
    return neuerBruch.kuerzen();
  }
  
  
  
  
  
  /**
   * Dividiert einen Bruch durch einen anderen indem der Kehrbruch gebildet wird
   * und die Br�che dann multipliziert werden.
   * @param bruch ein Bruchobjekt.
   */
  public Bruch dividieren(Bruch bruch) {
    Bruch neuerBruch = new Bruch(bruch.nenner, bruch.zaehler);
    return this.multiplizieren(neuerBruch);
  }
  
  
  
  
  public int getZaehler() {
    return this.zaehler;
  }

  public int getNenner() {
    return this.nenner;
  }

  public void setZaehler(int zaehler) {
    this.zaehler = zaehler;
  }

  public void setNenner(int nenner) {
    this.nenner = nenner;
  }

}
