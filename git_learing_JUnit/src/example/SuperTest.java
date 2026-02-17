package example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class SuperTest {
  protected Calculator calc;

  @BeforeEach
  void init() {
    calc = new Calculator();
    System.out.println("--- [親クラス] テスト環境を初期化しました ---");
  }

  @AfterEach
  void tearDown() {
    System.out.println("--- [親クラス] テストが終了しました ---");
  }

}
