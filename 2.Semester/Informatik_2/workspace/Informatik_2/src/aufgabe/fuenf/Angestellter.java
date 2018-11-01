package aufgabe.fuenf;

/**
 * Ein Angestellter ist ein Steuerzahler, Einkommenssteuer zahlen und Sozialabgaben leisten muss.
 * @author Max
 *
 */
public class Angestellter extends Hinterbliebener {
  
  /**
   * Erzeugt einen neuen Angestellten.
   * @param einkommen muss >= 0 sein!
   */
  public Angestellter(double einkommen) {
    super(einkommen);
  }
  
  
  /**
   * @return Die Einkommenssteuer des Angestellten auf Euro abgerundet.
   */
  @Override
  public int getTax() {
    if (this.getJaehrlichesEinkommen() <= 12000) {
      return 0;
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
