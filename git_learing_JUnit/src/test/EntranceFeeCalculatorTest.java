package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import main.example.EntranceFeeCalculator;

class EntranceFeeCalculatorTest {
  private EntranceFeeCalculator calculator;

  /**
   * 各テスト実行前にインスタンスを生成
   */
  @BeforeEach
  void setUp() {
    calculator = new EntranceFeeCalculator();
  }

  // --- 正常系のテスト ---
  @ParameterizedTest(name = "{index}: 年齢={0}, 休日={1}, 会員={2} => 期待値={3}円")
  @CsvSource({
      // 年齢, 休日, 会員, 期待値
      " 18, false, false, 2000 ", " 17, false, false, 1000 ", " 18, true,  false, 2200 ",
      " 18, false, true,  1700 ", " 17, true,  true,   900 ", "  0, false, false, 1000 ",
      "149, false, false, 2000 "})
  void 入場料計算ロジックの網羅テスト(int age, boolean isHoliday, boolean isMember, int expected) {
    assertThat(calculator.calculateFee(age, isHoliday, isMember)).as("年齢:%d の時の料金が正しくない", age)
        .isEqualTo(expected);
  }

  // --- 異常系のテスト ---
  @ParameterizedTest(name = "{index}: 不正な年齢 {0} の場合に例外がスローされること")
  @ValueSource(ints = {-1, 150})
  void 不正な年齢の場合は例外をスローする(int invalidAge) {
    assertThatThrownBy(() -> calculator.calculateFee(invalidAge, false, false))
        .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("不正な年齢です");
  }
}
