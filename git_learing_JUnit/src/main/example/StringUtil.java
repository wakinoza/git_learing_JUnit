package main.example;


/**
 * 文字列操作に関するユーティリティクラス
 */
public class StringUtil {

  /**
   * キャメルケース等の文字列をスネークケースに変換します。 * @param target 変換対象の文字列
   *
   * @return スネークケースに変換された文字列
   */
  public static String toSnakeCase(String target) {
    if (target == null) {
      return null;
    }

    String result = target.replaceAll("([a-z])([A-Z])", "$1_$2");

    return result.toLowerCase();
  }
}
