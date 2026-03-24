package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import main.example.NumberUtil;

class NumberUtilTest {

  @ParameterizedTest(name = "trueの同値クラス")
  @ValueSource(ints = {2, -2})
  void trueTest(int input) {
    assertThat(NumberUtil.isEven(input)).isTrue();
  }

  @ParameterizedTest(name = "falseの同値クラス")
  @ValueSource(ints = {3, -3})
  void falseTest(int input) {
    assertThat(NumberUtil.isEven(input)).isFalse();
  }


  @ParameterizedTest(name = "trueの境界値")
  @ValueSource(ints = {0, Integer.MAX_VALUE - 1, Integer.MIN_VALUE})
  void trueBorderTest(int input) {
    assertThat(NumberUtil.isEven(input)).isTrue();
  }

  @ParameterizedTest(name = "falseの境界値")
  @ValueSource(ints = {1, -1, Integer.MAX_VALUE, Integer.MIN_VALUE + 1})
  void falseBorderTest(int input) {
    assertThat(NumberUtil.isEven(input)).isFalse();
  }

}
