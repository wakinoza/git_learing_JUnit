package test;

import static org.assertj.core.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import main.example.FizzBuzz;

class FizzBuzzTest {

  @Test
  void createFizzBuzzで１６まで取得できる() {
    List<String> antual = FizzBuzz.createFizzBuzz(16);
    assertThat(antual).hasSize(16).containsExactly("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8",
        "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz", "16");
  }

  @Test
  void 引数が０ときは空のリストが返る() {
    assertThat(FizzBuzz.createFizzBuzz(0)).isEmpty();
  }

  @Test
  void 負の数の場合は例外を投げる() {
    assertThatThrownBy(() -> {
      FizzBuzz.createFizzBuzz(-1);
    }).isInstanceOf(IllegalArgumentException.class).hasMessage("引数は0以上である必要があります。");
  }

}
