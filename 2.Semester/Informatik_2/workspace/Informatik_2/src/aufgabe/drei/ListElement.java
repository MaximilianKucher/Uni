package aufgabe.drei;

/**
 * Ein Listenelement.
 * @author Max
 *
 */
public class ListElement {
  
  private String data;
  private ListElement vorgaenger;
  private ListElement nachfolger;

  
  public String getData() {
    return data;
  }
  
  public void setData(String data) {
    this.data = data;
  }
  
  public ListElement getVorgaenger() {
    return vorgaenger;
  }
  
  public void setVorgaenger(ListElement vorgaenger) {
    this.vorgaenger = vorgaenger;
  }
  
  public ListElement getNachfolger() {
    return nachfolger;
  }
  
  public void setNachfolger(ListElement nachfolger) {
    this.nachfolger = nachfolger;
  }
  
}
