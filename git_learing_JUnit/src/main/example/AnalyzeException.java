package main.example;

public class AnalyzeException extends RuntimeException {
  public AnalyzeException(String message, Throwable cause) {
    super(message, cause);
  }
}
