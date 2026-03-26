package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import main.example.ConsumptionTax;

class ConsumptionTaxTest {

  @ParameterizedTest(name = "第{index}回：税率が{0}で入力値が {1} のとき、期待値が {2} であること")
  @CsvSource({"5,100,105", "5,3000,3150", "10,50,55", "3,50,51", "0, 100, 100", // 税率0%
      "10, 0, 0" // 金額0円
  })
  void test(int tax, int price, int expected) {
    ConsumptionTax sut = new ConsumptionTax(tax);
    assertThat(sut.apply(price)).isEqualTo(expected);
  }

  @Test
  void 税率に負の数を指定した場合は例外を投げること() {
    assertThatThrownBy(() -> new ConsumptionTax(-1)).isInstanceOf(IllegalArgumentException.class);
  }
}
