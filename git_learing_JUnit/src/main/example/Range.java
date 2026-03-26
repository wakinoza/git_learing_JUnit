package main.example;

/**
 * 指定された範囲内（最小値以上、最大値以下）に数値が含まれるかを判定するクラス
 */
public record Range(double min, double max) {

  public Range {
    if (min > max) {
      throw new IllegalArgumentException("最小値は最大値以下である必要があります。");
    }
  }

  /**
   * 引数が範囲内（min <= n <= max）であればtrueを返します。
   */
  public boolean contains(double n) {
    return n >= min && n <= max;
  }
}
