package test;

import static org.assertj.core.api.Assertions.*;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.example.MonthlyCalendar;

class MonthlyCalendarTest {

  @Test
  @DisplayName("2026年1月30日のとき、残り日数が1日であること")
  void shouldReturn1DayWhenJanuary30() {
    // 1. 影武者（Clock）の作成：2026-01-30 に固定
    Clock fixedClock = Clock.fixed(Instant.parse("2026-01-30T10:00:00Z"), ZoneId.of("UTC"));

    // 2. モックを注入してインスタンス化
    MonthlyCalendar sut = new MonthlyCalendar(fixedClock);

    // 3. 検証
    assertThat(sut.getRemainingDays()).isEqualTo(1);
  }

  @Test
  @DisplayName("月末日のとき、残り日数が0日であること")
  void shouldReturn0DayWhenLastDayOfMonth() {
    Clock fixedClock = Clock.fixed(Instant.parse("2026-01-31T10:00:00Z"), ZoneId.of("UTC"));

    MonthlyCalendar sut = new MonthlyCalendar(fixedClock);

    assertThat(sut.getRemainingDays()).isEqualTo(0);
  }

  @Test
  @DisplayName("2026年2月1日のとき、残り日数が27日であること")
  void shouldReturn27DayWhenFirstDayOfMonth() {
    Clock fixedClock = Clock.fixed(Instant.parse("2026-02-01T10:00:00Z"), ZoneId.of("UTC"));

    MonthlyCalendar sut = new MonthlyCalendar(fixedClock);

    assertThat(sut.getRemainingDays()).isEqualTo(27);
  }

  @Test
  @DisplayName("2024年（うるう年）2月1日のとき、残り日数が28日であること")
  void leapYearTest() {
    Clock fixedClock = Clock.fixed(Instant.parse("2024-02-01T10:00:00Z"), ZoneId.of("UTC"));
    MonthlyCalendar sut = new MonthlyCalendar(fixedClock);
    assertThat(sut.getRemainingDays()).isEqualTo(28);
  }
}
