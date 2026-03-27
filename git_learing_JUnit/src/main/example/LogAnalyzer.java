package main.example;

import java.io.IOException;

public class LogAnalyzer {
  private final LogLoader loader;

  public LogAnalyzer(LogLoader loader) {
    this.loader = loader;
  }

  public void analyze(String fileName) {
    try {
      loader.load(fileName);
      // 解析処理
    } catch (IOException e) {
      throw new AnalyzeException("Log load failed", e);
    }
  }
}
