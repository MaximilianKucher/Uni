package aufgabe.zehn;

import java.util.*;
import java.util.stream.Stream;


/**
 * Verschieden Datenstrukturen auf Laufzeit testen f�r einf�ge-operationenen und zugriffs-operationen.
 * @author HP
 *
 */
public class TestDatenstrukturen {
  
  
  /**
   * F�gt 1.000.000 Elemente mit der Standard add-Methode in die Datenstrukur ein.
   * @param datastructure Eine beliebige Datenstruktur der Collections API.
   */
  public static void add(Collection datastructure) {
    long start = System.currentTimeMillis();
    for(int i = 0; i < 1000000; i++) {
      datastructure.add(i);
    }
    long end = System.currentTimeMillis();
    long durationInMsec = end - start;
    System.out.println(durationInMsec);
  }
  
  
  
  
  /**
   * F�gt 100.000 Elemente an den Anfang der Datenstruktur an.
   * @param list Eine beliebige Datenstruktur der Collections API.
   */
  public static void addFirst(List list) {
    long start = System.currentTimeMillis();
    for(int i = 0; i < 100000; i++) {
      list.add(0, i);
    }
    long end = System.currentTimeMillis();
    long durationInMsec = end - start;
    System.out.println(durationInMsec);
  }
  
  
  
  
  /**
   * Sucht mit einem Iterator nach dem zuletzt eingef�gten Element (hier 999.999).
   * @param datastructure Eine beliebige Datenstruktur der Collections API.
   * @return 1 wenn die Suche erfolgreich beendet wurde, 0 ansonsten.
   */
  public static int searchWithIterator(Collection datastructure) {
    long start = System.currentTimeMillis();
    Iterator iter = datastructure.iterator();
    while(iter.hasNext()) {
      Object element = iter.next();
      if((Integer)element == (Integer) 999999) {
        long end = System.currentTimeMillis();
        long durationInMsec = end - start;
        System.out.println(durationInMsec);
        return 1;
      }
    }
    long end = System.currentTimeMillis();
    long durationInMsec = end - start;
    System.out.println(durationInMsec);
    return 0;
  }
  
 
  
  
  /**
   * Sucht mit Hilfe der Bin�rsuche nach dem zuletzt eingef�gten Element (hier 999.999).
   * @param list Eine Liste der Collections API.
   */
  public static void searchWithBinary(List list) {
    long start = System.currentTimeMillis();
    Collections.binarySearch(list, 999999);
    long end = System.currentTimeMillis();
    long durationInMsec = end - start;
    System.out.println(durationInMsec);
  }
  
  
  
  
  /**
   * Sucht mit Hilfe der Contains-Methode der Collections API nach dem zuletzt eingef�gten Element (hier 999.999).
   * @param datastructure Eine beliebige Datenstruktur der Collections API.
   */
  public static void searchWithMethods(Collection datastructure) {
    long start = System.currentTimeMillis();
    datastructure.contains((Integer)999999);
    long end = System.currentTimeMillis();
    long durationInMsec = end - start;
    System.out.println(durationInMsec);
  }
  
  
  
  
  /**
   * F�gt 1.000.000 zufallszahlen zwischen 0 und 10.000 in die ArrayList mit Hilfe der add-Methode ein.
   * @param arrayList Eine ArrayList aus der Collections API.
   */
  public static void add2(ArrayList arrayList) {
    long start = System.currentTimeMillis();
    for(int i = 0; i < 1000000; i++) {
      int value = (int)(10000.0 * Math.random());
      arrayList.add((Integer)value);
    }
    long end = System.currentTimeMillis();
    long durationInMsec = end - start;
    System.out.println(durationInMsec);
  }
  
  
  
  
  /**
   * F�gt 1.000.000 Zufallszahlen zwischen 0 und 10.000 in die ArrayList
   * mit Hilfe der generate-Methode der Stream API ein.
   * @param arrayList Eine ArrayList aus der Collections API.
   */
  public static void add3(ArrayList arrayList) {
    long start = System.currentTimeMillis();
    long numberOfValues = 1000000;
    Stream<Integer> newStream = Stream.generate(() -> (int)(10000.0 * Math.random()) ).limit(numberOfValues);
    long end = System.currentTimeMillis();
    long durationInMsec = end - start;
    System.out.println(durationInMsec);
  }
  
  
  
  
  /**
   * Addiert alle geraden Zahlen aus der ArrayList mit Hilfe eines Iterators.
   * @param arrayList Eine ArrayList aus der Collections API.
   */
  public static void sum(ArrayList arrayList) {
    long start = System.currentTimeMillis();
    Iterator iter = arrayList.iterator();
    long sum = 0;
    while(iter.hasNext()) {
      Object element = iter.next();
      if((Integer)element % 2 == 0) {
        sum += (Integer)element;
      }
    }
    long end = System.currentTimeMillis();
    long durationInMsec = end - start;
    System.out.println(durationInMsec);
    System.out.println("Summe:" + sum);
  }
  
  
  
  
  /**
   * Addiert alle geraden Zahlen aus der ArrayList mit Hilfe sequentieller Streams.
   * @param arrayList Eine ArrayList aus der Collections API.
   */
  public static void sum2(ArrayList arrayList) {
    long start = System.currentTimeMillis();
    long sum = arrayList.stream().filter(v -> ((int)v % 2 == 0)).mapToInt(v -> (int)v).sum();
    double sum2 = arrayList.stream().mapToDouble(v -> (double)v).sum();
    long end = System.currentTimeMillis();
    long durationInMsec = end - start;
    System.out.println(durationInMsec);
    System.out.println("Summe:" + sum);
  }
  
  
  
  
  /**
   * Addiert alle geraden Zahlen aus der ArrayList mit Hilfe eventuell paralleler Streams.
   * @param arrayList Eine ArrayList aus der Collections API.
   */
  public static void sum3(ArrayList arrayList) {
    long start = System.currentTimeMillis();
    long sum = arrayList.parallelStream().filter(v -> ((int)v % 2 == 0)).mapToInt(v -> (int)v).sum();
    long end = System.currentTimeMillis();
    long durationInMsec = end - start;
    System.out.println(durationInMsec);
    System.out.println("Summe:" + sum);
  }
  
  
  
  
  /**
   * Ausgabe der Laufzeiten auf der Konsole mit Kommentaren.
   * @param args
   */
  public static void main (String[] args) {
    
    System.out.println("am Ende anh�ngen(1.000.000 Elemente):");
    System.out.println("Vector:");
    Collection<Vector<Integer>> vector = new Vector<>();
    add(vector);
    
    System.out.println("ArrayList:");
    Collection<ArrayList<Integer>> arrayList = new ArrayList<>();
    add(arrayList);
    
    System.out.println("LinkedList:");
    Collection<LinkedList<Integer>> linkedList = new LinkedList<>();
    add(linkedList);
    
    System.out.println("HashSet:");
    Collection<HashSet<Integer>> hashSet = new HashSet<>();
    add(hashSet);
    
    System.out.println("TreeSet:");
    Collection<TreeSet<Integer>> treeSet = new TreeSet<>();
    add(treeSet);
    
    System.out.println("Vector mit vorgegebner Gr��e:");
    Collection<Vector<Integer>> vector2 = new Vector<>(1000000);
    add(vector2);
    
    System.out.println("ArrayList mit vorgegebner Gr��e:");
    Collection<ArrayList<Integer>> arrayList2 = new ArrayList<>(1000000);
    add(arrayList2);
    
    
    // ----------------------------------------------------------------------
    
    
    System.out.println("\nam Anfang anf�gen(100.000 Elemente):");
    System.out.println("Vector:");
    Vector<Integer> vector3 = new Vector<>();
    addFirst(vector3);
    
    System.out.println("ArrayList:");
    ArrayList<Integer> arrayList3 = new ArrayList<>();
    addFirst(arrayList3);
    
    System.out.println("LinkedList:");
    LinkedList<Integer> linkedList2 = new LinkedList<>();
    addFirst(linkedList2);
    
   
    // ----------------------------------------------------------------------
    
    
    System.out.println("\nmit Iterator nach zuletzt eingef�gtem Element suchen.");
    System.out.println("Vector:");
    searchWithIterator(vector);
    
    System.out.println("ArrayList:");
    searchWithIterator(arrayList);
    
    System.out.println("LinkedList:");
    searchWithIterator(linkedList);
    
    System.out.println("HashSet:");
    searchWithIterator(hashSet);
    
    System.out.println("TreeSet");
    searchWithIterator(treeSet);
    
    
    // ----------------------------------------------------------------------
    
    
    System.out.println("\nmit Bin�rsuche nach zuletzt eingef�gtem Element suchen.");
    System.out.println("Vector:");
    searchWithBinary((List)vector);
    
    System.out.println("ArrayList:");
    searchWithBinary((List)arrayList);
    
    
    // ----------------------------------------------------------------------
    
    
    System.out.println("\nmit Hilfe der Methoden der Datenstrukturen zuletzt eingef�gtes Element suchen:");
    System.out.println("Vector:");
    searchWithMethods(vector);
    
    System.out.println("ArrayList:");
    searchWithMethods(arrayList);
    
    System.out.println("LinkedList:");
    searchWithMethods(linkedList);
    
    System.out.println("HashSet:");
    searchWithMethods(hashSet);
    
    System.out.println("TreeSet:");
    searchWithMethods(treeSet);
    
    
    // ----------------------------------------------------------------------
    
    
    System.out.println("\nmit Hilfe der add-Methode elemente einf�gen.");
    System.out.println("ArrayList:");
    ArrayList<Integer> arrayList4 = new ArrayList<>();
    add2(arrayList4);
    
    System.out.println("\nmit Hilfe von Streams elemente einf�gen.");
    System.out.println("ArrayList:");
    ArrayList<Integer> arrayList5 = new ArrayList<>();
    add3(arrayList5);
    
    
    // ----------------------------------------------------------------------
    
    
    System.out.println("\nalle geraden Zufallszahlen addieren.");
    System.out.println("ArrayList mit Iterator.");
    sum(arrayList4);
    
    System.out.println("\nArrayList mit sequentiellem Stream.");
    sum2(arrayList4);
    
    System.out.println("\nArrayList mit m�glicherwei�e parallelem Stream.");
    sum3(arrayList4);
  }

}
