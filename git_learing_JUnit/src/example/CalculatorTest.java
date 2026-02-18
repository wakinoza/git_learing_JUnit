package example;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {

  @Test
  @DisplayName("基本のアサーションを試す")
  void testBasicAssertions() {
    String str1 = "JUnit";
    String str2 = "JUnit";
    String str3 = "JUnit";

    // 値の比較
    assertEquals("JUnit２", str1, "値が一致しない");

    // インスタンス（参照）の比較
    assertSame(str1, str3, "異なる参照");
    assertNotSame(str1, str2, "同じ参照");

    // 真偽値
    assertTrue(10 < 5);
    assertFalse(10 > 5);
  }

  @Test
  @DisplayName("Nullのテスト")
  void testNull() {
    Object obj = null;

    List<String> list = new ArrayList<>();
    assertNull(list);
    assertNotNull(obj);

  }

  @Test
  @DisplayName("assertAllでまとめて検証する")
  void testGroupedAssertions() {
    Calculator calc = new Calculator();

    // 1つが失敗しても、残りの検証もすべて実行して結果を出してくれる
    assertAll("電卓の基本演算", () -> assertEquals(3, calc.add(1, 1)),
        () -> assertEquals(10, calc.add(5, 5)), () -> assertEquals(1, calc.add(-1, 1)));
  }

}
