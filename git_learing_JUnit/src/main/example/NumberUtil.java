package main.example;

/**
 * 数値操作のユーティリティクラス
 */
public class NumberUtil {

  /**
   * 渡された数値が偶数かどうかを判定します。
   *
   * @param n 判定する数値
   * @return 偶数の場合はtrue, 奇数の場合はfalse
   */
  public static boolean isEven(int n) {
    return n % 2 == 0;
  }
}
