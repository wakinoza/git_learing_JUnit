package main.example;

public class Counter {
  private int count = 0;

  /**
   * 呼び出すたびにカウントを1増やして返します。
   *
   * @return 増加後の値
   * @throws ArithmeticException int型の最大値を超えた場合
   */
  public int increment() {
    if (count == Integer.MAX_VALUE) {
      throw new ArithmeticException("counter overflow");
    }
    return ++count;
  }
}
