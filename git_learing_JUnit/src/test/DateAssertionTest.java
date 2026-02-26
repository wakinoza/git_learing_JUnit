package test;

import static org.assertj.core.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;

class DateAssertionTest {

  @Test
  void testDate() {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime yesterday = now.minusDays(1);

    // 1. 過去・未来
    assertThat(yesterday).isInThePast();

    // 2. 範囲指定（文字列も可）
    assertThat(now).isBetween(yesterday, now.plusDays(1));

    // 3. 【重要】実行時のズレを許容する
    // テスト実行中に1秒くらい過ぎても大丈夫なようにする
    assertThat(now).isCloseTo(LocalDateTime.now(), within(1, ChronoUnit.SECONDS));

    // 4. 特定の部分だけ
    assertThat(now).hasYear(2026);

    // 5. LocalDateの便利機能
    assertThat(LocalDate.now()).isToday();
  }
}
