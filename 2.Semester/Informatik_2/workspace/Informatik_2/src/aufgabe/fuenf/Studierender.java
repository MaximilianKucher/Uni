package aufgabe.fuenf;

/**
 * Ein Studierender ist ein Steuerzahler der Einkommenssteuer zahlen,
 * jedoch keine Sozialabgaben leisten muss.
 * @author Max
 *
 */
public class Studierender extends Rentner {
  
  /**
   * Erzeugt einen neuen Studierenden.
   * @param einkommen muss >= 0 sein!
   */
  public Studierender(double einkommen) {
    super(einkommen);
  }
  
  
  /**
   * @return Die Einkommenssteuer des Studierenden auf Euro abgerundet.
   */
  @Override
  public int getTax() {
    if (this.getJaehrlichesEinkommen() <= 6000) {
      return 0;
    } else if ((this.getJaehrlichesEinkommen() <= 12000)
            && (this.getJaehrlichesEinkommen() > 6000)) {
      return (int)(this.getJaehrlichesEinkommen() * STEUERSATZ_STEUERKLASSE_EINS);
    } else if ((this.getJaehrlichesEinkommen() <= 24000)
            && (this.getJaehrlichesEinkommen() > 12000)) {
      return (int)(this.getJaehrlichesEinkommen() * STEUERSATZ_STEUERKLASSE_ZWEI);
    } else if ((this.getJaehrlichesEinkommen() <= 50000)
            && (this.getJaehrlichesEinkommen() > 24000)) {
      return (int)(this.getJaehrlichesEinkommen() * STEUERSATZ_STEUERKLASSE_DREI);
    } else if ((this.getJaehrlichesEinkommen() <= 75000)
            && (this.getJaehrlichesEinkommen() > 50000)) {
      return (int)(this.getJaehrlichesEinkommen() * STEUERSATZ_STEUERKLASSE_VIER);
    } else if (this.getJaehrlichesEinkommen() > 75000) {
      return (int)(this.getJaehrlichesEinkommen() * STEUERSATZ_STEUERKLASSE_FUENF);
    } else {
      return -1;
    }
  }
  
}
