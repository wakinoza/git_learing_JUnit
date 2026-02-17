package example;

public class Calculator {
  private int total = 0;

  public int add(int a, int b) {
    int result = a + b;
    total += result;
    return result;
  }

  public int getTotal() {
    return total;
  }

  public double divide(int a, int b) {
    if (b == 0) {
      throw new IllegalArgumentException("0で割ることはできません。");
    }
    return (double) a / b;
  }
}
