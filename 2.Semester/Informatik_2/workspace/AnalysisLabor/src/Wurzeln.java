
public class Wurzeln {

  public static void main(String[] args) {
    System.out.println(calculateRoot1(0, -9));
    System.out.println(calculateRoot2(3,0));
  }
  
  private static double calculateRoot1(int k, double x) {
    
    double a_n = -1;
    double a_n_plus_1 = ((k - 1) * Math.pow(a_n, k) + x) / (k * Math.pow(a_n, k - 1));
    
    while (Math.abs(a_n - a_n_plus_1) > 1.0e-11) {
      a_n = a_n_plus_1;
      a_n_plus_1 = ((k - 1) * Math.pow(a_n, k) + x) / (k * Math.pow(a_n, k - 1));
    }
    
    return a_n_plus_1;
    
  }
  
  private static double calculateRoot2(int k, double x) {
    
    return Math.exp((1/(double)k) * Math.log(x));
  }

}