package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.example.Calculator;

class CalculatorTest {

  private Calculator calc;

  @BeforeEach
  void setUp() {
    calc = new Calculator();
  }

  // --- 正常系のテスト ---

  @Test
  @DisplayName("正常系：正の数を加算すると合計が正しく更新されること")
  void testAddSuccess() {
    int result = calc.add(10);

    assertThat(result, is(equalTo(10)));
    assertThat(calc.getTotal(), is(not(0)));
  }

  @Test
  @DisplayName("正常系：割り算が正しく計算されること")
  void testDivideSuccess() {
    int result = calc.divide(10, 2);

    assertThat(result, is(5));
  }

  // --- 異常系のテスト ---

  @Test
  @DisplayName("異常系：負の数を加算すると例外が発生すること")
  void testAddNegativeException() {
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> calc.add(-5));

    // 例外メッセージの検証
    assertThat(exception.getMessage(), containsString("負の数は加算できません"));
  }

  @Test
  @DisplayName("異常系：0で除算すると例外が発生すること")
  void testDivideByZeroException() {
    assertThrows(ArithmeticException.class, () -> {
      calc.divide(10, 0);
    });
  }
}
