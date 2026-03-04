package test;

import static org.assertj.core.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import main.example.DiscountService;
import main.example.Member;

class DiscountServiceTest {

  private final DiscountService service = new DiscountService();

  @ParameterizedTest(name = "{index}: {1}")
  @MethodSource("provideMemberTestData")
  void 会員種別に応じた割引率が正しく計算されること(Member member, String description, double expected) {
    double actual = service.calculateDiscountRate(member);

    assertThat(actual).as(description).isEqualTo(expected);
  }

  /**
   * テストデータを供給するメソッド
   */
  private static Stream<Arguments> provideMemberTestData() {
    return Stream.of(
        // 引数: Memberオブジェクト, テストケースの説明, 期待値
        Arguments.of(new Member("田中", 25, true), "ゴールド会員は一律20%引き", 0.2),
        Arguments.of(new Member("佐藤", 17, false), "一般の未成年は10%引き", 0.1),
        Arguments.of(new Member("鈴木", 40, false), "一般の成人は割引なし", 0.0));
  }
}
