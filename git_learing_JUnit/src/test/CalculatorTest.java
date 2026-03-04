package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

  // テスト対象メソッド
  int square(int number) {
    return number * number;
  }

  @ParameterizedTest(name = "第{index}回：入力値 {0} のとき、期待値が {1} であること")
  @CsvSource({" 0,   0", // 境界値
      " 1,   1", // 正常系
      " 5,  25", // 正常系
      "-3,   9", // 負の数
  })
  void squareメソッドの計算テスト(int input, int expected) {
    int actual = square(input);

    // AssertJで検証
    assertThat(actual).as("入力値 %d に対する計算結果の検証", input).isEqualTo(expected) // 期待値と一致するか
        .isGreaterThanOrEqualTo(0); // 常に0以上か(追加の検証もチェーン)
  }
}
