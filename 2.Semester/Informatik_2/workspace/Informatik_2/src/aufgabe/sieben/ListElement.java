package aufgabe.sieben;

/**
 * Ein Listenelement.
 * @author Max
 *
 */
public class ListElement<E> {
  
  private E data;
  private ListElement<E> vorgaenger;
  private ListElement<E> nachfolger;

  
  public E getData() {
    return data;
  }
  
  public void setData(E data) {
    this.data = data;
  }
  
  public ListElement<E> getVorgaenger() {
    return vorgaenger;
  }
  
  public void setVorgaenger(ListElement<E> vorgaenger) {
    this.vorgaenger = vorgaenger;
  }
  
  public ListElement<E> getNachfolger() {
    return nachfolger;
  }
  
  public void setNachfolger(ListElement<E> nachfolger) {
    this.nachfolger = nachfolger;
  }
  
}
