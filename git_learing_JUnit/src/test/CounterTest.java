package test;


import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.example.Counter;

class CounterTest {
  Counter counter;

  @BeforeEach
  void setUp() {
    counter = new Counter();
  }

  @Test
  @DisplayName("初回呼び出し時は1を返すこと")
  void increment_初回() {
    assertThat(counter.increment()).isEqualTo(1);
  }

  @Test
  @DisplayName("2回連続で呼び出すと2が返ること")
  void increment_2回目() {
    counter.increment(); // 1回目
    assertThat(counter.increment()).as("2回目の呼び出し結果").isEqualTo(2);
  }

  @Test
  @DisplayName("最大値直前まで正常にうごくこと")
  void increment_最大値直前() {
    for (int i = 1; i < Integer.MAX_VALUE; i++) {
      counter.increment();
    }
    assertThat(counter.increment()).as("最大値ちょうどの呼び出し結果").isEqualTo(Integer.MAX_VALUE);
  }

  @Test
  @DisplayName("最大値を超えると例外をスローすること")
  void increment_オーバーフロー() {
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      counter.increment();
    }
    assertThatThrownBy(() -> counter.increment()).isInstanceOf(ArithmeticException.class)
        .hasMessage("counter overflow");
  }

}
