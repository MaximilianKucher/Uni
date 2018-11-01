package aufgabe.fuenf;

/**
 * Ein Hinterbliebener ist ein Steuerzahler der zwar Sozialabgaben leisten muss,
 * allerdings von der Einkommenssteuer befreit ist.
 * @author Max
 *
 */
public class Hinterbliebener extends Rentner {
  
  /**
   * Erzeugt einen neuen Hinterbliebenen.
   * @param einkommen muss >= 0 sein!
   */
  public Hinterbliebener(double einkommen) {
    super(einkommen);
  }
  
  /**
   * @return Die Sozialabgaben des Hinterbliebenen auf Euro abgerundet.
   */
  @Override
  public int getSocialTax() {
    return (int) (this.getJaehrlichesEinkommen() * STEUERSATZ_SOZIALABGABEN);
  }

}
