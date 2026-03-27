package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import main.example.Frameworks;
import main.example.Frameworks.ApplicationServer;
import main.example.Frameworks.Database;

class FrameworksTest {

  @ParameterizedTest(name = "第{index}回：入力値 {0}と{1}のとき、期待値がtrueであること")
  @CsvSource({"GlassFish,Oracle", "GlassFish,DB2", "GlassFish,PostgreSQL", "GlassFish,MySQL",
      "JBoss,DB2", "JBoss,PostgreSQL", "Tomcat,MySQL",})
  void positiveTest(ApplicationServer server, Database db) {
    boolean actual = Frameworks.isSupport(server, db);

    assertThat(actual).isTrue();
  }

  @ParameterizedTest(name = "第{index}回：入力値 {0}と{1}のとき、期待値がFalseであること")
  @CsvSource({"JBoss,Oracle", "JBoss,MySQL", "Tomcat,Oracle", "Tomcat,DB2", "Tomcat,PostgreSQL",})
  void negativeTest(ApplicationServer server, Database db) {
    boolean actual = Frameworks.isSupport(server, db);

    assertThat(actual).isFalse();
  }


}
