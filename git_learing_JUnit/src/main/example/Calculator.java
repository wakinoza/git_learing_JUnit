package main.example;

/**
 * 計算機クラス
 */
public class Calculator {

  /**
   * 除算を行います。
   *
   * @param x 被除数
   * @param y 除数
   * @return 計算結果
   * @throws IllegalArgumentException y が 0 の場合
   */
  public int divide(int x, int y) {
    if (y == 0) {
      throw new IllegalArgumentException("divide by zero");
    }
    if (x == Integer.MIN_VALUE && y == -1) {
      throw new ArithmeticException("integer overflow");
    }
    return x / y;
  }
}
