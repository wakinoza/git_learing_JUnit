package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import main.example.Range;

class RangeTest {

  Range sut1 = new Range(0.0, 10.5);
  Range sut2 = new Range(-5.1, 5.1);

  @ParameterizedTest
  @CsvSource({"0.1", "10.4", "0.0", "10.5"})
  @DisplayName("sut1: 境界値を含む範囲内テスト")
  void sut1PositiveTests(double input) {
    assertThat(sut1.contains(input)).isTrue();
  }

  @ParameterizedTest

  @ValueSource(doubles = {-0.1, 10.6, Double.MAX_VALUE, -Double.MAX_VALUE})
  @DisplayName("sut1: 範囲外テスト")
  void sut1NegativeTests(double input) {
    assertThat(sut1.contains(input)).isFalse();
  }

  @ParameterizedTest
  @CsvSource({"-5.1", "-5.0", "5.0", "5.1"})
  @DisplayName("sut2: 負の数を含む範囲内テスト")
  void sut2PositiveTests(double input) {
    assertThat(sut2.contains(input)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(doubles = {-5.2, 5.2, 100.0})
  @DisplayName("sut2: 負の数を含む範囲外テスト")
  void sut2NegativeTests(double input) {
    assertThat(sut2.contains(input)).isFalse();
  }
}
