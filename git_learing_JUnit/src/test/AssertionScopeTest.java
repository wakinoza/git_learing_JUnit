package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.example.Calculator;

class AssertionScopeTest {

  private Calculator calc;

  @BeforeEach
  void setUp() {
    calc = new Calculator();
    System.out.println(">>> @BeforeEach: Calculatorをリセットしました");
  }

  @Test
  @DisplayName("実験A: 1つのメソッド内で連続してアサーション（混入が起きる）")
  void experimentA() {
    System.out.println("  [実行] 実験A開始");

    // 1回目の操作
    calc.add(10, 0);
    assertEquals(10, calc.getTotal(), "1回目: 10であるべき");

    // 2回目の操作（同じメソッド内なので、前回の10が残っている！）
    calc.add(5, 0);
    assertEquals(15, calc.getTotal(), "2回目: 10+5で15になる（混入発生）");
  }

  @Test
  @DisplayName("実験B: メソッドを分けて実行（独立性が保たれる）")
  void experimentB_step1() {
    System.out.println("  [実行] 実験B-1開始");
    calc.add(10, 0);
    assertEquals(10, calc.getTotal());
  }

  @Test
  @DisplayName("実験B: メソッドを分けて実行（独立性が保たれる）")
  void experimentB_step2() {
    System.out.println("  [実行] 実験B-2開始");
    // 実験B-1の後に実行されるが、@BeforeEachでリセットされるため
    // ここでの total は 0 から始まる！
    calc.add(5, 0);
    assertEquals(5, calc.getTotal(), "リセットされているので、単独の5になる");
  }
}
