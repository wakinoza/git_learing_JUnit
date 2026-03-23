package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import main.example.Calculator;

class CalculatorTest {
  private Calculator calc;

  @BeforeEach
  void setUp() {
    calc = new Calculator();
  }

  @ParameterizedTest(name = "第{index}回：入力値 {0} のとき、期待値が {1} であること")
  @CsvSource({"18,3,6", // 正常系
      "18,-3,-6", // 正常系
      "-18,3,-6", // 正常系
      "-18,-3,6", // 正常系
      "4,1,4", // 境界値
      "4,-1,-4", // 境界値
  })
  void positiveTest(int input1, int input2, int expected) {
    int actual = calc.divide(input1, input2);

    assertThat(actual).isEqualTo(expected);

  }

  @Test
  @DisplayName("0除算時にIllegalArgumentExceptionを投げること")
  void shouldThrowException_WhenDivideByZero() {
    assertThatThrownBy(() -> calc.divide(10, 0)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("divide by zero");
  }

  @Test
  @DisplayName("最小値を-1で割った時にオーバーフロー例外を投げること")
  void shouldThrowException_WhenOverflowOccurs() {
    assertThatThrownBy(() -> calc.divide(Integer.MIN_VALUE, -1))
        .isInstanceOf(ArithmeticException.class).hasMessage("integer overflow");
  }


  @Test
  @DisplayName("int型の限界値における挙動の確認")
  void boundaryValueTest() {
    assertThat(calc.divide(Integer.MAX_VALUE, 1)).isEqualTo(2147483647);
    assertThat(calc.divide(Integer.MIN_VALUE, 1)).isEqualTo(-2147483648);

  }

}
