package example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest extends SuperTest {

  @Test
  @DisplayName("3 + 5 が 8 になること")
  void testAdd() {
    assertEquals(8, calc.add(3, 5));
    System.out.println("子クラス: 足し算のテストを実行中");
  }

  @Test
  @DisplayName("0で割った時に例外が発生すること")
  void testDivideException() {
    assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0));
    System.out.println("子クラス: 割り算のテストを実行");
  }

}
