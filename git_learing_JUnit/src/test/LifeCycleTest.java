package test;


import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LifeCycleTest {
  private static List<String> sharedLog = new ArrayList<>();

  private List<String> testList;

  @BeforeAll
  static void initAll() {
    System.out.println(">>> @BeforeAll: クラス全体の開始 (1回のみ)");
    sharedLog.add("START");
  }

  @BeforeEach
  void setUp() {
    System.out.println("  > @BeforeEach: テストごとの準備");
    testList = new ArrayList<>();
  }

  @Test
  @DisplayName("テスト1: 要素を追加する")
  void test1() {
    System.out.println("    [実行] テスト1");
    testList.add("DataA");
    assertEquals(1, testList.size(), "テスト1のリストサイズは1であるべき");
  }

  @Test
  @DisplayName("テスト2: 別の要素を追加する")
  void test2() {
    System.out.println("    [実行] テスト2");
    testList.add("DataB");
    assertEquals(1, testList.size(), "テストごとにリセットされるため、サイズは1であるべき");
  }

  @AfterEach
  void tearDown() {
    System.out.println("  > @AfterEach: テストごとの後片付け");
    testList.clear(); // 明示的に空にする
  }

  @AfterAll
  static void tearDownAll() {
    System.out.println(">>> @AfterAll: クラス全体の終了 (1回のみ)");
    sharedLog.add("END");
    System.out.println("最終ログの状態: " + sharedLog);
  }
}
