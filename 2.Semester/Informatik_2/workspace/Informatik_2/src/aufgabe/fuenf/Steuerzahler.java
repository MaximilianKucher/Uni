package aufgabe.fuenf;

/**
 * Ein Steuerzahler mit jährlichem Einkommen.
 * Es gibt einen Steuersatz für eventuelle Sozialabgaben sowie 5 Steuersätze für 5 Steuerklassen.
 * @author Max
 *
 */
public abstract class Steuerzahler {
  
  public static final double STEUERSATZ_STEUERKLASSE_EINS = 0.1;
  public static final double STEUERSATZ_STEUERKLASSE_ZWEI = 0.25;
  public static final double STEUERSATZ_STEUERKLASSE_DREI = 0.3;
  public static final double STEUERSATZ_STEUERKLASSE_VIER = 0.4;
  public static final double STEUERSATZ_STEUERKLASSE_FUENF = 0.5;
  
  public static final double STEUERSATZ_SOZIALABGABEN = 0.28;
  
  
  
  private double jaehrlichesEinkommen;
  
  
  
  public double getJaehrlichesEinkommen() {
    return jaehrlichesEinkommen;
  }


  public void setJaehrlichesEinkommen(double jaehrlichesEinkommen) {
    this.jaehrlichesEinkommen = jaehrlichesEinkommen;
  }

}
