
package test;

import static org.assertj.core.api.Assertions.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.example.BackgrounfTask;

class BackgrounfTaskTest {

  @Test
  @DisplayName("invokeを呼ぶと、別スレッドで渡したタスクが実行されること")
  void invoke_shouldExecuteTaskInBackground() throws InterruptedException {
    AtomicBoolean isExecuted = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);

    Runnable task = () -> {
      isExecuted.set(true);
      latch.countDown();
    };

    BackgrounfTask sut = new BackgrounfTask(task);

    sut.invoke();

    boolean done = latch.await(1, TimeUnit.SECONDS);

    assertThat(done).as("タイムアウトせずにタスクが完了したか").isTrue();
    assertThat(isExecuted.get()).as("タスクが実際に実行されたか").isTrue();
  }
}
