package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserFunctionTest extends SuperDbTest {
  @Test
  void testUserRegistration() {
    System.out.println("  [実行] ユーザー登録テスト");
    database.add("NEW_USER"); // データを1つ追加

    // 初期データ2件 + 新規1件 = 3件
    assertEquals(3, database.size(), "登録後は3件であるべき");
  }

  @Test
  void testDataDeletion() {
    System.out.println("  [実行] データ削除テスト");
    database.remove("ADMIN_USER"); // 初期データを1つ消す

    // 初期データ2件 - 1件 = 1件
    assertEquals(1, database.size(), "削除後は1件であるべき");
  }
}
