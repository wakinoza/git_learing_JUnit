package main.example;

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

  public void reset() {
    this.total = 0;
  }
}
