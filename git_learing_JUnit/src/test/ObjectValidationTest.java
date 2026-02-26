package test;

import static org.assertj.core.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import main.example.Address;
import main.example.User;

class ObjectValidationTest {

  @Test
  void testUserObjectValidation() {
    // 1. テスト対象のデータ（実際はDBから取得したりAPIから返ってきたりするもの）
    User actualUser = new User(101, "Alice", "Free", LocalDateTime.now());
    actualUser.setAddress(new Address("Nagoya", "Aichi"));

    // 2. 期待値データ（IDや時間はあえて適当に設定）
    User expectedUser = new User(0, "Gemini", "Free", null);
    expectedUser.setAddress(new Address("Nagoya", "Aichi"));

    // 【実験A】ピンポイント検証 (hasFieldOrPropertyWithValue)
    assertThat(actualUser).hasFieldOrPropertyWithValue("name", "Alice");

    // 【実験B】特定フィールドの抽出 (extracting)
    // 複数の値を一度に抜き出して比較
    assertThat(actualUser).extracting(User::getName, User::getPlan).containsExactly("Alice",
        "Free");

    // 【実験C】再帰的かつ項目除外の比較 (usingRecursiveComparison / ignoringFields)
    // IDと登録日時は毎回変わるので無視し、それ以外の中身（住所含む）が一致するか検証
    assertThat(actualUser).usingRecursiveComparison().ignoringFields("id", "createdAt") // ここで指定したフィールドは比較しない
        .isEqualTo(expectedUser);

    // 【実験D】全フィールドがNULLか確認 (hasAllNullFieldsOrProperties)
    User newUser = new User();
    assertThat(newUser).hasAllNullFieldsOrProperties();
  }
}
