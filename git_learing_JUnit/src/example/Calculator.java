package example;

public class Calculator {
  public int add(int a, int b) {
    return a + b;
  }

  public double divide(int a, int b) {
    if (b == 0) {
      throw new IllegalArgumentException("0で割ることはできません。");
    }
    return (double) a / b;
  }
}
