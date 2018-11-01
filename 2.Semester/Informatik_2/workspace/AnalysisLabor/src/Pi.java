
public class Pi {
  
  static int counter = 0;
  
  public static int piByLeibnitzReihe() {
    double pi = 0;
    double counter = 0;
    
    while (Math.floor(4 * pi * 100000) != 314159) {
      pi += Math.pow(-1.0, counter) / (2.0 * counter + 1);
      counter++;
    }
    
    return (int)counter;
  }
  
  
  
  public static int piByBailey() {
    double pi = 0;
    double counter = 0;
    
    while (Math.floor(pi * 100000) != 314159) {
      pi += (1.0 / Math.pow(16, counter)) * (4.0 / (8 * counter + 1) - 2.0 / (8 * counter + 4) - 1.0 / (8 * counter + 5) - 1.0 / (8 * counter + 6));
      counter++;
    }
    
    return (int)counter;
  }
  
  
  public static int piByEuler() {
    double pi = 0;
    double counter = 1;
    
    while (Math.floor(Math.sqrt(pi * 6) * 100000) != 314159) {
      pi += 1.0 / Math.pow(counter, 2);
      counter++;
    }
    
    return (int)counter - 1;
  }
  
 
  
  public static void main(String[] args) {
    System.out.println(piByLeibnitzReihe());
    System.out.println(piByBailey());
    System.out.println(piByEuler());
  }

}
