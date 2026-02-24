package main.example;

public class Calculator {
  private int total = 0;

  public int add(int a) {
    if (a < 0)
      throw new IllegalArgumentException("負の数は加算できません");
    total += a;
    return total;
  }

  public int divide(int a, int b) {
    if (b == 0)
      throw new ArithmeticException("0で割ることはできません");
    return a / b;
  }

  public int getTotal() {
    return total;
  }
}
