package test;

import static org.assertj.core.api.Assertions.*;
import java.time.LocalDateTime;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import main.example.User;

class SoftAssertionExperimentTest {
  @Test
  // 比較用：SoftAssertionがない通常のアサーションの場合
  void testNormalAssertion() {
    User user = new User(101, "Ａｌｉｃｅ", "Free", LocalDateTime.now());

    // 失敗する検証
    assertThat(user.getId()).as("【通常】ユーザーID").isEqualTo(200);

    // 失敗する検証
    assertThat(user.getPlan()).as("【通常】契約プラン").isEqualTo("Premium");
  }

  @Test
  void testUserWithSoftAssertions() {
    // テスト対象のデータ（あえていくつか期待値と違う値に設定しています）
    User user = new User(101, "Ａｌｉｃｅ", "Free", LocalDateTime.now());

    SoftAssertions.assertSoftly(softly -> {

      // 1. 成功する検証
      softly.assertThat(user.getName()).as("ユーザー名").isEqualTo("Ａｌｉｃｅ");

      // 2. 失敗する検証
      softly.assertThat(user.getId()).as("ユーザーID").isEqualTo(200);

      // 3. 失敗する検証
      softly.assertThat(user.getPlan()).as("契約プラン").isEqualTo("Premium");


    });
  }


}
