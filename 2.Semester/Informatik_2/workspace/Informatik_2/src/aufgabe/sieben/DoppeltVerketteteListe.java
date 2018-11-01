package aufgabe.sieben;

/**
 * Eine doppelt verkettete Liste.
 * @author Max
 *
 */
public class DoppeltVerketteteListe<E> {
  
  
  
  private ListElement<E> first;
  private ListElement<E> last;
  private int size;
  
  
  
  
  /**
   * F�gt ein neues erstes Element in die Liste ein. Es wird unterschieden ob
   * schon Elemente in der Liste sind oder nicht.
   * @param value Daten f�r das neue Listenelement.
   */
  public void addFirst(E value) {
    ListElement<E> element = new ListElement<E>();
    element.setData(value);
    if (size > 0) {
      element.setNachfolger(first);
      first.setVorgaenger(element);
      first = element;
    } else {
      assert size == 0;
      first = element;
      last = element;
    }
    size++; 
  }
  
  
  
  
  
  /**
   * F�gt ein neues letztes Element in die Liste ein. Es wird unterschieden ob
   * schon Elemente in der Liste sind oder nicht.
   * @param value Daten f�r das neue Listenelement.
   */
  public void addLast(E value) {
    ListElement<E> element = new ListElement<E>();
    element.setData(value);
    if (size > 0) {
      element.setVorgaenger(last);
      last.setNachfolger(element);
      last = element;
    } else {
      assert size == 0;
      first = element;
      last = element;
    }
    size++; 
  }
  
  
  
  
  
  /**
   * F�gt ein neues Listenelement an einer beliebigen Position ein.
   * @param index muss gr��er als 0 sein!
   * @param value Daten f�r das neue Listenelement.
   */
  public void add(int index, E value) {
    if (index <= 0) {
      throw new IllegalArgumentException("Index muss gr��er als 0 sein!");
    } else {
      if (index == 1) {
        this.addFirst(value);
      } else if (index >= size) {
        this.addLast(value);
      } else {
        assert (index > 1) & (index < size);
        ListElement<E> iteratorElement = first;
        
        // iterieren bis zur richtigen Position in der Liste 
        while (index > 1) {
          iteratorElement = iteratorElement.getNachfolger();
          index--;
        }
        ListElement<E> newElement = new ListElement<E>();
        newElement.setData(value);
        
        // der Nachfolger des Neuen Elements ist die Position des iteratorElements.
        newElement.setNachfolger(iteratorElement);
        
        // das neue Element wird der Nachfolger des Vorg�ngerelements
        newElement.getNachfolger().getVorgaenger().setNachfolger(newElement);
        
        /* der Vorg�nger des Nachfolgers des neuen Elements wird jetzt der Vorg�nger
           des neuen Elements. */
        newElement.setVorgaenger(newElement.getNachfolger().getVorgaenger());
        
        // das neue Element wird der neue Vorg�nger seines Nachfolgers.
        newElement.getNachfolger().setVorgaenger(newElement);
        size++;
      } 
    }
  }
  
  
  
  
  
  /**
   * Liest die Daten am �bergebenen Index aus.
   * @param index Position des Elements, muss gr��er als 0 sein!
   * @return daten des Elements an der Stelle index in der Liste.
   */
  public E get(int index) {
    if (index <= 0) {
      throw new IllegalArgumentException("Index muss gr��er als 0 sein!");
    } else if (index == 1) {
      return first.getData();
    } else if (index == size) {
      return last.getData();
    } else {
      ListElement<E> iteratorElement = first;
      
      /* der Nachfolger des Nachfolgers wird zum neuen Nachfolger bis wir die
         gew�nschte Position in der Liste erreicht haben. */
      while (index > 1) {
        iteratorElement = iteratorElement.getNachfolger();
        index--;
      }
 
      return iteratorElement.getData();
    }
  }
  
  
  
  
  
  /**
   * Entfernt das erste Element aus der Liste.
   * @return Daten des ersten Elements.
   */
  public E removeFirst() {
    assert size > 0;
    final E data = first.getData();
    first = first.getNachfolger();
    first.setVorgaenger(null);
    size--;
    return data;
  }
  
  
  
  
  
  /**
   * Entfernt das letzte Element aus der Liste.
   * @return Daten des letzten Elements.
   */
  public E removeLast() {
    assert size > 0;
    final E data = last.getData();
    last = last.getVorgaenger();
    last.setNachfolger(null);
    size--;
    return data;
  }
  
  
  

  public ListElement<E> getFirst() {
    return first;
  }

  public void setFirst(ListElement<E> first) {
    this.first = first;
  }

  public ListElement<E> getLast() {
    return last;
  }

  public void setLast(ListElement<E> last) {
    this.last = last;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
  
  
}
