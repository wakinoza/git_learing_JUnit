package test;

import static org.assertj.core.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.example.HelloWorld;

class HelloWorldTest {
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {

    System.setOut(standardOut);
  }

  @Test
  void say_標準出力にHelloWorldが出力されること() {
    HelloWorld sut = new HelloWorld();
    sut.say();


    assertThat(outputStreamCaptor.toString()).isEqualTo("Hello World");
  }
}
