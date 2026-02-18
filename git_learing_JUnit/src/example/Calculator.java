package example;

public class Calculator {


  public int add(int a, int b) {
    int result = a + b;
    return result;
  }


  public double divide(int a, int b) {
    if (b == 0) {
      throw new IllegalArgumentException("0で割ることはできません。");
    }
    return (double) a / b;
  }
}
