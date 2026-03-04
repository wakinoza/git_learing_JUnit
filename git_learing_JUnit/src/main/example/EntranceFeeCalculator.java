package main.example;

// テスト対象クラス
public class EntranceFeeCalculator {

  /**
   * 入場料を計算するメソッド
   *
   * 異常値: age < 0 または age >= 150 の場合は IllegalArgumentException
   */
  public int calculateFee(int age, boolean isHoliday, boolean isMember) {

    if (age < 0 || age >= 150) {
      throw new IllegalArgumentException("不正な年齢です: " + age);
    }

    int fee = (age < 18) ? 1000 : 2000;

    if (isHoliday) {
      fee += 200;
    }

    if (isMember) {
      fee -= 300;
    }

    return fee;
  }
}
