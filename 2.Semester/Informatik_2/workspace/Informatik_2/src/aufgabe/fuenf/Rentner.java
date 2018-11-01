package aufgabe.fuenf;

/**
 * Ein Rentner ist Steuerzahler der keine Einkommenssteuer und Sozialabgaben leisten muss.
 * @author Max
 *
 */
public class Rentner extends Steuerzahler {
  
  /**
   * Erzeugt einen neuen Rentner.
   * @param einkommen muss >= 0 sein!
   */
  public Rentner(double einkommen) {
    assert einkommen >= 0;
    this.setJaehrlichesEinkommen(einkommen);
  }
  
  
  public int getTax() {
    return 0;
  }
  
  
  public int getSocialTax() {
    return 0;
  }
}

