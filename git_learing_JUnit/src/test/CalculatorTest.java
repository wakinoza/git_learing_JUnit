package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.example.Calculator;

class CalculatorTest {
  private Calculator calc;


  @BeforeEach
  void setUp() {
    calc = new Calculator();
    System.out.println("@BeforeEach");
  }

  @Test
  @DisplayName("加算のテスト：5 + 3 = 8 であること")
  void testAdd() {
    assertEquals(8, calc.add(5, 3), "加算の結果が正しくありません");
    System.out.println("加算のテスト");
  }

  @Test
  @DisplayName("乗算のテスト：5 * 3 = 15 であること")
  void testMultiply() {
    assertEquals(15, calc.multiply(5, 3), "乗算の結果が正しくありません");
    System.out.println("乗算のテスト");
  }

  @AfterEach
  void setDown() {
    System.out.println("@AfterEach");
  }
}
