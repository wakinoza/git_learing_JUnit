package main.example;


import java.util.List;
import java.util.stream.IntStream;

/**
 * FizzBuzzリスト生成クラス
 */
public class FizzBuzz {

  /**
   * 1から指定された数までのFizzBuzzリストを生成します。
   *
   * @param n 生成する上限（1以上）
   * @return FizzBuzzの結果リスト
   * @throws IllegalArgumentException 引数が負の数の場合
   */
  public static List<String> createFizzBuzz(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("引数は0以上である必要があります。");
    }

    return IntStream.rangeClosed(1, n).mapToObj(i -> {
      if (i % 15 == 0)
        return "FizzBuzz";
      if (i % 3 == 0)
        return "Fizz";
      if (i % 5 == 0)
        return "Buzz";
      return String.valueOf(i);
    }).toList();
  }
}
