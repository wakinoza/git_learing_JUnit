package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringAssertionTest {

  @Test
  void testStringValidation() {
    // 1. 完全一致と大文字小文字の無視 (isEqualTo, isEqualToIgnoringCase)
    String role = "ADMIN";
    assertThat(role).isEqualTo("ADMIN");
    assertThat(role).isEqualToIgnoringCase("admin");

    // 2. 部分一致 (contains)
    String errorMessage = "Error: User ID [123] not found";
    assertThat(errorMessage).contains("User ID", "not found");

    // 3. 空白・空文字の検証 (isNotBlank)
    String inputName = "  Taro Yamada  ";
    assertThat(inputName).isNotBlank(); // null, "", " " ではないこと

    // 4. 前方・後方一致 (startsWith, endsWith)
    String fileName = "report_2026.pdf";
    assertThat(fileName).startsWith("report_").endsWith(".pdf");

    // 5. 文字数と数字のみの検証 (hasSize, containsOnlyDigits)
    String zipCode = "1234567";
    assertThat(zipCode).hasSize(7).containsOnlyDigits();

    // 6. 正規表現による形式チェック (matches)
    // 例: 英字3文字-数字4文字 の形式
    String empId = "STF-9876";
    assertThat(empId).matches("^[A-Z]{3}-\\d{4}$");

  }
}
