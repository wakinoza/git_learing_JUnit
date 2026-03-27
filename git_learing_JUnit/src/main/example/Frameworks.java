package main.example;

public class Frameworks {

  public enum ApplicationServer {
    GlassFish, JBoss, Tomcat
  }

  public enum Database {
    Oracle, DB2, PostgreSQL, MySQL
  }

  /**
   * アプリケーションサーバーとデータベースの組み合わせがサポートされているか判定します。
   */
  public static boolean isSupport(ApplicationServer server, Database db) {
    return switch (server) {
      case GlassFish -> true; // 全てサポート
      case JBoss -> (db == Database.DB2 || db == Database.PostgreSQL);
      case Tomcat -> (db == Database.MySQL);
    };
  }
}
