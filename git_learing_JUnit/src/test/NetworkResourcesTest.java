package test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import main.example.NetworkLoader;
import main.example.NetworkResources;

class NetworkResourcesTest {

  @Test
  void load_ネットワークから取得した文字列が正しく返されること() throws Exception {
    String expectedText = "Hello Mockito!";
    InputStream fakeStream = new ByteArrayInputStream(expectedText.getBytes());

    NetworkLoader mockLoader = mock(NetworkLoader.class);
    when(mockLoader.getInput()).thenReturn(fakeStream);

    NetworkResources sut = new NetworkResources(mockLoader);

    String actual = sut.load();
    assertThat(actual).isEqualTo(expectedText);
  }
}
