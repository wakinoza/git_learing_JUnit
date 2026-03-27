package main.example;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import java.io.IOException;
import org.junit.jupiter.api.Test;


class LogAnalyzerTest {

  @Test
  void loadがIOExceptionを投げたときAnalyzeExceptionが再スローされること() throws Exception {
    LogLoader sutLoader = org.mockito.Mockito.mock(LogLoader.class);
    doThrow(new IOException("Disk Error")).when(sutLoader).load(anyString());
    LogAnalyzer sutAnalyzer = new LogAnalyzer(sutLoader);
    assertThatThrownBy(() -> sutAnalyzer.analyze("test.log")).isInstanceOf(AnalyzeException.class)
        .hasMessage("Log load failed").hasCauseInstanceOf(IOException.class);
  }

}
