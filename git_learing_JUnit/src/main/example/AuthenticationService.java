package main.example;

public class AuthenticationService {
  private final AccountDao accountDao;

  public AuthenticationService(AccountDao accountDao) {
    this.accountDao = accountDao;
  }

  public Account authenticate(String userId, String password) {
    Account account = accountDao.findOrNull(userId);

    // アカウントが存在し、かつパスワードが一致するかチェック
    if (account != null && password.equals(account.getPassword())) {
      return account;
    }

    return null;
  }
}
