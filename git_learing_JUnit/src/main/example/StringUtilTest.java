package main.example;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringUtilTest {


  @ParameterizedTest(name = "第{index}回：入力値 {0} のとき、期待値が {1} であること")
  @CsvSource({"aaa,aaa", "HelloWorld,hello_world", "practiceJunit,practice_junit",})
  void 正常系のテスト(String input, String expected) {
    String actual = StringUtil.toSnakeCase(input);
    assertThat(actual).isEqualTo(expected);

  }
}
