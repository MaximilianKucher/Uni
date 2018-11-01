package aufgabe.fuenf;

/**
 * Ein Beamter ist ein Steuerzahler der Einkommenssteuer zahlen,
 * jedoch keine Sozialabgaben leisten muss.
 * @author Max
 *
 */
public class Beamter extends Selbststaendiger {
  
  /**
   * Erzeugt einen neuen Beamten.
   * @param einkommen muss >= 0 sein!
   */
  public Beamter(double einkommen) {
    super(einkommen);
  }
  
}
