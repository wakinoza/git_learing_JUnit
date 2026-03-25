package main.example;

import java.util.concurrent.Executors;

public class BackgrounfTask {
  private final Runnable task;

  public BackgrounfTask(Runnable task) {
    this.task = task;
  }

  public void invoke() {
    Executors.newSingleThreadExecutor().execute(task);
  }
}
