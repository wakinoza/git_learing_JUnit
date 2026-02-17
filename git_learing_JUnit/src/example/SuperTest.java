package example;

import org.junit.jupiter.api.BeforeAll;


public abstract class SuperTest {
  protected static Calculator calc;

  @BeforeAll
  static void initAll() {
    calc = new Calculator();
    System.out.println(">>> [親クラス] @BeforeAll: calcを1回だけ生成しました");
  }

}
