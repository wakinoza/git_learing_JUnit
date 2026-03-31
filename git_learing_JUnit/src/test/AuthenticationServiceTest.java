package test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import main.example.Account;
import main.example.AccountDao;
import main.example.AuthenticationService;

class AuthenticationServiceTest {

  @Test
  void 認証成功_正しいIDとパスワードならAccountが返ること() {
    Account mockAccount = new Account();
    mockAccount.setName("Alice");
    mockAccount.setPassword("secret123");
    AccountDao mockDao = mock(AccountDao.class);
    when(mockDao.findOrNull("user001")).thenReturn(mockAccount);

    AuthenticationService sut = new AuthenticationService(mockDao);

    Account result = sut.authenticate("user001", "secret123");

    assertThat(result).isNotNull();
    assertThat(result.getName()).isEqualTo("Alice");
  }

  @Test
  void 認証失敗_存在するIDに違うぱすわーどを送信したときnullがかえること() {
    Account mockAccount = new Account();
    mockAccount.setName("Alice");
    mockAccount.setPassword("secret123");
    AccountDao mockDao = mock(AccountDao.class);
    when(mockDao.findOrNull("user001")).thenReturn(mockAccount);

    AuthenticationService sut = new AuthenticationService(mockDao);

    Account result = sut.authenticate("user001", "secret999");

    assertThat(result).isNull();
  }

  @Test
  void 認証失敗_ユーザーが存在しない場合はnullが返ること() {
    AccountDao mockDao = mock(AccountDao.class);

    when(mockDao.findOrNull("unknown")).thenReturn(null);

    AuthenticationService sut = new AuthenticationService(mockDao);

    assertThat(sut.authenticate("unknown", "anyPass")).isNull();
  }
}
