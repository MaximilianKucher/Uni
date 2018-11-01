package aufgabe.eins;

/**
 * Ein Bruch bestehend aus Z�hler und Nenner.
 * Br�che k�nnen addiert, subtrahiert, multipliziert und dividiert werden.
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
   * Erzeugt einen neuen Bruch mit ganzzahligem Z�hler und positivem ganzzahligem Nenner.
   * @param zaehler ganzzahlig.
   * @param nenner ganzzahlig und muss gr��er als 0 sein.
   */
  public Bruch(long zaehler, long nenner) {
    if (nenner <= 0) {
      throw new IllegalArgumentException("Der Nenner muss gr��er als 0 sein!");
    } else {
      this.zaehler = zaehler; 
      this.nenner = nenner;
    }
  }
  
  /**
   * K�rzt einen Bruch indem mit dem euklidischen Alogrithmus der ggT von Z�hler
   * und Nenner ermittelt wird und anschlie�end Z�hler und Nenner durch den ggT
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
   * Addiert zwei Br�che indem sie zuerst auf den gleichen Nenner gebracht
   * und danach die Z�hler addiert werden. Dann wird gek�rzt.
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
   * Subtrahiert zwei Br�che voneinander indem sie zuerst auf den gleichen Nenner
   * gebracht und danach die Z�hler subtrahiert werden. Dann wird gek�rzt.
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
   * Multipliziert zwei Br�che indem jweils die beiden Z�hler bzw. Nenner
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
   * und die Br�che dann multipliziert werden.
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
