package main.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 従業員情報を保持するRecord
 */
public record Employee(String firstName, String lastName, String email) {

  /**
   * InputStreamからCSV形式のデータを読み込み、Employeeのリストを生成します。
   * 
   * @param is 入力ストリーム
   * @return 従業員のリスト
   * @throws IOException 読み込みエラー時
   */
  public static List<Employee> load(InputStream is) throws IOException {

    String regex = "[\\s　]*,[\\s　]*";

    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
      return reader.lines().filter(line -> !line.isBlank()).map(line -> line.split(regex))
          .filter(parts -> parts.length == 3)
          .map(parts -> new Employee(parts[0], parts[1], parts[2])).collect(Collectors.toList());
    }
  }
}
