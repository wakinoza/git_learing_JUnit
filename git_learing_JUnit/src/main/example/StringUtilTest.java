package main.example;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringUtilTest {


  @ParameterizedTest(name = "第{index}回：入力値 {0} のとき、期待値が {1} であること")
  @CsvSource({"aaa,aaa", "HelloWorld,hello_world", "practiceJunit,practice_junit",
      "My100Test,my100_test"})
  @DisplayName("正常系のテスト")
  void PositiveTests(String input, String expected) {
    String actual = StringUtil.toSnakeCase(input);
    assertThat(actual).isEqualTo(expected);

  }

  @Nested
  @DisplayName("境界値・異常値のテスト")
  class BoundaryTests {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("nullまたは空文字が入力された場合はそのまま返す")
    void shouldReturnInput_WhenInputIsNullOrEmpty(String input) {
      assertThat(StringUtil.toSnakeCase(input)).isEqualTo(input);
    }

    @Test
    @DisplayName("1文字（小文字）の場合はそのまま返ること")
    void shouldReturnLower_WhenSingleCharLower() {
      assertThat(StringUtil.toSnakeCase("a")).isEqualTo("a");
    }

    @Test
    @DisplayName("1文字（大文字）の場合は小文字になって返ること")
    void shouldReturnLower_WhenSingleCharUpper() {
      assertThat(StringUtil.toSnakeCase("A")).isEqualTo("a");
    }

    @Test
    @DisplayName("すでにスネークケースの文字列は、変化しないこと")
    void shouldNotChange_WhenAlreadySnakeCase() {
      String input = "already_snake_case";
      assertThat(StringUtil.toSnakeCase(input)).isEqualTo(input);
    }

    @Test
    @DisplayName("連続する大文字も適切に処理されること")
    void shouldHandleContinuousUpperChars() {
      assertThat(StringUtil.toSnakeCase("isHTTP")).isEqualTo("is_http");
    }
  }
}
