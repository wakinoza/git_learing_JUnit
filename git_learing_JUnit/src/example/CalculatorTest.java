package example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest extends SuperTest {

  @Test
  @Order(1)
  void test1_FirstAdd() {
    System.out.println("--- テスト1開始 ---");
    calc.add(10, 20);
    System.out.println("テスト1終了時の合計: " + calc.getTotal());
    assertEquals(30, calc.getTotal());
  }

  @Test
  @Order(2)
  void test2_SecondAdd() {
    System.out.println("--- テスト2開始 ---");
    calc.add(5, 5);

    System.out.println("テスト2実行中の合計: " + calc.getTotal());

    assertEquals(40, calc.getTotal(), "テスト1の結果が残っているため40になります");
  }

}
