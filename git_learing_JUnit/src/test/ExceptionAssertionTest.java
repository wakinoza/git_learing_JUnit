package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ExceptionAssertionTest {

  @Test
  void testException() {
    // 1. 基本的な例外検証
    assertThatThrownBy(() -> {
      throw new IllegalArgumentException("不正な値です: -1");
    }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("不正な値")
        .hasMessage("不正な値です: -1");

    // 2. 境界値などで例外が「出ない」ことの確認
    assertThatCode(() -> {
    }).doesNotThrowAnyException();

  }
}
