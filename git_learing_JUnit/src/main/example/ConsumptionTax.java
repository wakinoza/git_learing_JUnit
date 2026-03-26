package main.example;

/**
 * 消費税計算を行うクラス
 */
public class ConsumptionTax {
  private final int rate;

  public ConsumptionTax(int rate) {
    if (rate < 0) {
      throw new IllegalArgumentException("税率は0以上である必要があります。");
    }
    this.rate = rate;
  }

  /**
   * 税込金額を計算して返します（端数切り捨て）
   */
  public int apply(int price) {
    return (int) (price * (1 + rate / 100.0));
  }
}
