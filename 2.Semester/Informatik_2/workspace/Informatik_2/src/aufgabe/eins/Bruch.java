package aufgabe.eins;

/**
 * Ein Bruch bestehend aus Zähler und Nenner.
 * Brüche können addiert, subtrahiert, multipliziert und dividiert werden.
 * @author Max
 *
 */
public class Bruch {
  private long zaehler;
  private long nenner;

  /**
   * Standardkonstruktor.
   */
  public Bruch() {

  }

  /**
   * Erzeugt einen neuen Bruch mit ganzzahligem Zähler und positivem ganzzahligem Nenner.
   * @param zaehler ganzzahlig.
   * @param nenner ganzzahlig und muss größer als 0 sein.
   */
  public Bruch(long zaehler, long nenner) {
    if (nenner <= 0) {
      throw new IllegalArgumentException("Der Nenner muss größer als 0 sein!");
    } else {
      this.zaehler = zaehler; 
      this.nenner = nenner;
    }
  }
  
  /**
   * Kürzt einen Bruch indem mit dem euklidischen Alogrithmus der ggT von Zähler
   * und Nenner ermittelt wird und anschließend Zähler und Nenner durch den ggT
   * geteilt werden.
   */
  public void kuerzen() {
    long ggt = 1;
    long rest = 1;
    long eins = Math.abs(this.zaehler);
    long zwei = Math.abs(this.nenner);
    
    if (zwei > eins) {
      eins = Math.abs(this.nenner);
      zwei = Math.abs(this.zaehler);
    }

    do {
      ggt = zwei;
      rest = eins % zwei;
      eins = zwei;
      zwei = rest;
    } while (rest != 0);
    
    this.zaehler /= ggt;
    this.nenner /= ggt;
  }
  
  /**
   * Addiert zwei Brüche indem sie zuerst auf den gleichen Nenner gebracht
   * und danach die Zähler addiert werden. Dann wird gekürzt.
   * @param bruch ein Bruchobjekt.
   */
  public void addieren(Bruch bruch) {
    if (this.nenner == bruch.nenner) {
      this.zaehler += bruch.zaehler;
      this.kuerzen();
    } else {
      long nenner = this.nenner;
      this.nenner *= bruch.nenner;
      this.zaehler *= bruch.nenner;
      bruch.nenner *= nenner;
      bruch.zaehler *= nenner;
      this.zaehler += bruch.zaehler;
      this.kuerzen();
    }
  }
  
  /**
   * Subtrahiert zwei Brüche voneinander indem sie zuerst auf den gleichen Nenner
   * gebracht und danach die Zähler subtrahiert werden. Dann wird gekürzt.
   * @param bruch ein Bruchobjekt.
   */
  public void subtrahieren(Bruch bruch) {
    if (this.nenner == bruch.nenner) {
      this.zaehler -= bruch.zaehler;
      this.kuerzen();
    } else {
      long nenner = this.nenner;
      this.nenner *= bruch.nenner;
      this.zaehler *= bruch.nenner;
      bruch.nenner *= nenner;
      bruch.zaehler *= nenner;
      this.zaehler -= bruch.zaehler;
      this.kuerzen();
    }
  }
  
  /**
   * Multipliziert zwei Brüche indem jweils die beiden Zähler bzw. Nenner
   * miteinander multipliziert werden.
   * @param bruch ein Bruchobjekt.
   */
  public void multiplizieren(Bruch bruch) {
    this.zaehler *= bruch.zaehler;
    this.nenner *= bruch.nenner;
    this.kuerzen();
  }
  
  /**
   * Dividiert einen Bruch durch einen anderen indem der Kehrbruch gebildet wird
   * und die Brüche dann multipliziert werden.
   * @param bruch ein Bruchobjekt.
   */
  public void dividieren(Bruch bruch) {
    long speicher = bruch.zaehler;
    bruch.zaehler = bruch.nenner;
    bruch.nenner = speicher;
    this.multiplizieren(bruch);
  }

  public long getZaehler() {
    return this.zaehler;
  }

  public long getNenner() {
    return this.nenner;
  }

  public void setZaehler(long zaehler) {
    this.zaehler = zaehler;
  }

  public void setNenner(long nenner) {
    this.nenner = nenner;
  }
}
