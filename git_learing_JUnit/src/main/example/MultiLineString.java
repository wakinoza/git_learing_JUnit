package main.example;

/**
 * 複数行の文字列を操作するクラス
 */
public class MultiLineString {

  /**
   * 与えられた文字列をシステムの改行コードで連結します。
   *
   * @param lines 連結する文字列（可変長引数）
   * @return 連結された文字列
   */
  public static String join(String... lines) {
    if (lines == null || lines.length == 0) {
      return "";
    }
    return String.join(System.lineSeparator(), lines);
  }
}
