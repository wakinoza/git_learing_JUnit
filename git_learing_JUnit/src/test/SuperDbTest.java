package test;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SuperDbTest {
  // データベースに見立てた共有リスト
  protected static List<String> database = new ArrayList<>();

  @BeforeEach
  void initDatabase() {
    database.add("ADMIN_USER");
    database.add("SYSTEM_CONFIG");
    System.out.println(">>> [親] DBに共通データを投入しました。現在の件数: " + database.size());
  }

  @AfterEach
  void clearDatabase() {
    database.clear();
    System.out.println("<<< [親] DBをクリーンアップしました。");
  }
}
