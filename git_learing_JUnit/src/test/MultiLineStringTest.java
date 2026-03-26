package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.example.MultiLineString;

class MultiLineStringTest {

  @Test
  @DisplayName("引数がNullまたは空の場合は空文字を返すこと")
  void join_nullOrEmpty_shouldReturnEmpty() {
    assertThat(MultiLineString.join((String[]) null)).isEmpty();
    assertThat(MultiLineString.join()).isEmpty();
  }

  @Test
  @DisplayName("複数の文字列がシステム改行コードで連結されること")
  void join_normalCase() {
    String ls = System.lineSeparator();
    String actual = MultiLineString.join("ABC", "DEF", "GHI");

    assertThat(actual).isEqualTo("ABC" + ls + "DEF" + ls + "GHI");

    assertThat(actual).isEqualToNormalizingNewlines("ABC\nDEF\nGHI");
  }

  @Test
  @DisplayName("1行だけの場合は改行が含まれないこと")
  void join_singleLine() {
    assertThat(MultiLineString.join("ONLY")).isEqualTo("ONLY");
  }

}
