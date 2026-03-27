package main.example;

import java.time.Clock;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MonthlyCalendar {
  private final Clock clock;

  // 通常用：システム時間を使う
  public MonthlyCalendar() {
    this(Clock.systemDefaultZone());
  }

  // テスト用：外部から時間を注入できるようにする
  public MonthlyCalendar(Clock clock) {
    this.clock = clock;
  }

  /**
   * 月末までの残り日数を返します。
   */
  public int getRemainingDays() {
    LocalDate today = LocalDate.now(clock);
    LocalDate lastDayOfMonth = today.withDayOfMonth(today.lengthOfMonth());

    // 当日と月末日の差分（日数）を計算
    return (int) ChronoUnit.DAYS.between(today, lastDayOfMonth);
  }
}
