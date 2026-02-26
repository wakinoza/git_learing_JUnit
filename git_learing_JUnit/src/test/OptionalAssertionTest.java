package test;

import static org.assertj.core.api.Assertions.*;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import main.example.User;

class OptionalAssertionTest {

  @Test
  void testOptional() {
    // 1. 値が存在する場合
    Optional<String> found = Optional.of("Success");

    assertThat(found).isPresent().hasValue("Success").contains("Success");

    // 2. 値が空の場合
    Optional<String> notFound = Optional.empty();

    assertThat(notFound).isEmpty();

    // 3. オブジェクトが入っている場合（hasValueSatisfying）
    Optional<User> userOpt = Optional.of(new User(1, "Taro", "Free", null));

    assertThat(userOpt).hasValueSatisfying(user -> {
      assertThat(user.getName()).isEqualTo("Taro");
      assertThat(user.getId()).isPositive();
    });
  }
}
