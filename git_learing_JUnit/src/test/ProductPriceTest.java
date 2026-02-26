package test;

// isCloseToで必要
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProductPriceTest {

  @Test
  void testPriceCalculation() {
    // 1. 基本的な価格の検証 (isEqualTo, isPositive)
    int basePrice = 1000;
    assertThat(basePrice).isPositive().isEqualTo(1000);

    // 2. 割引率の検証 (isBetween, isZero)
    int discountRate = 10; // 10%
    assertThat(discountRate).isBetween(0, 100);

    // 3. 年齢制限などの境界値検証 (isGreaterThanOrEqualTo)
    int targetAge = 18;
    assertThat(targetAge).isGreaterThanOrEqualTo(18);

    // 4. 【重要】浮動小数点数の計算検証 (isCloseTo)
    // 消費税(10%)を加味した計算: 1000 * 1.1 = 1100.0
    double priceWithTax = 1000 * 1.1;

    // 通常の比較だと誤差で落ちることがあるが、isCloseToなら安心
    // 「1100.0 に対して、0.01 までの誤差なら許容する」という意味
    assertThat(priceWithTax).isCloseTo(1100.0, within(0.01));

    // 5. 複数の状態をまとめて検証
    int stockCount = 5;
    assertThat(stockCount).isNotNull().isNotZero().isLessThan(10);
  }
}
