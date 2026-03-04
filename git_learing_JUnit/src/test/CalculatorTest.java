package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

  // テスト対象のメソッド
  boolean square(int number) {
    return number > 0;
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 5, 100})
  void 数値が正の数か正しく判定されること(int input) {
    boolean result = square(input);

    // AssertJによる検証
    // 期待値：true
    assertThat(result).as("%d が正の数かチェック", input).isTrue();
  }
}
