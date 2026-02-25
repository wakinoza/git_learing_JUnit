package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserAssertionsTest {

  @Test
  void testUserOperations() {
    // 1. 基本的な値の検証 (isEqualTo, isTrue, isFalse)
    String status = "ACTIVE";
    boolean isAdmin = true;
    int loginCount = 0;

    assertThat(status).isEqualTo("ACTIVE"); // 等価性
    assertThat(isAdmin).isTrue(); // 真理値
    assertThat(loginCount == 0).isTrue(); // 条件式もOK
    assertThat(loginCount > 5).isFalse();

    // 2. Nullチェック (isNull, isNotNull)
    String middleName = null;
    String firstName = "Taro";

    assertThat(middleName).isNull();
    assertThat(firstName).isNotNull();

    // 3. インスタンスの検証 (isSameAs, isInstanceOf)
    Object obj = "Hello AssertJ";

    // 型の検証 (isInstanceOf)
    assertThat(obj).isInstanceOf(String.class);

    // 同一性の検証 (isSameAs)
    // new String() は中身が同じでもインスタンス（メモリ上の住所）が別になる
    String str1 = "Java";
    String str2 = str1;
    String str3 = "Java";

    assertThat(str1).isSameAs(str2); // 同じインスタンスなので成功
    assertThat(str1).isEqualTo(str3); // 中身（値）は同じなので成功
    // assertThat(str1).isSameAs(str3); // ← これは「失敗」する（インスタンスが別なため）
  }
}
