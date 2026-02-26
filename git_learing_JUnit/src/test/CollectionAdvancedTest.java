package test;

import static org.assertj.core.api.Assertions.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CollectionAdvancedTest {

  @Test
  void testAdvancedCollections() {
    // Listの検証
    List<String> colors = List.of("Red", "Green", "Blue");
    assertThat(colors).hasSize(3).containsSubsequence("Red", "Blue");

    // Setの検証 （allSatisfy）
    Set<Integer> scores = Set.of(85, 92, 78);
    assertThat(scores).allSatisfy(score -> {
      assertThat(score).isGreaterThan(70); // 全員70点より高いこと
      assertThat(score).isLessThan(100); // 全員100点未満であること
    });

    // Mapの検証
    Map<Integer, String> userMap = Map.of(1, "Taro", 2, "Hanako", 3, "John");

    assertThat(userMap).hasSize(3).containsEntry(1, "Taro").containsKey(2);

    // extractingFromEntries
    // Mapのエントリ（Key-Valueのペア）から値(Value)だけを抽出してリストとして検証
    assertThat(userMap).extractingFromEntries(Map.Entry::getValue).containsExactlyInAnyOrder("Taro",
        "Hanako", "John");


  }
}
