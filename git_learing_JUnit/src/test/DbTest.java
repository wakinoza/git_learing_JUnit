package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DbTest {

  @BeforeAll
  static void setupAll() {
    // DB接続処理
    System.out.println("@BeforeAll");
  }

  @BeforeEach
  void setUp() {
    // DBに初期値を投入する処理
    System.out.println("@BeforeEach");
  }

  @Test
  @DisplayName("DBのテスト１")
  void testDb1() {
    // DBの挙動のテスト
    System.out.println("DBのテスト１を実行");
  }

  @Test
  @DisplayName("DBのテスト2")
  void testDb2() {
    // DBの挙動のテスト
    System.out.println("DBのテスト2を実行");
  }

  @AfterEach
  void setDown() {
    // DBの値を消去する処理
    System.out.println("@AfterEach");
  }

  @AfterAll
  static void setDownAll() {
    // DBとの接続を解除する処理
    System.out.println("@AfterAll");
  }
}
