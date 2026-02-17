package example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  private Calculator calc;

  @BeforeEach
  void setUp() {
    calc = new Calculator();
    System.out.println("インスタンスを生成しました");
  }

  @Test
  @DisplayName("3 + 5 が 8 になること")
  void testAdd() {
    assertEquals(8, calc.add(3, 5));
  }

  @Test
  @DisplayName("0で割った時に例外が発生すること")
  void testDivideException() {
    assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0));
  }

}
