package main.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品の在庫を管理するクラス
 */
public class ItemStock {
  private final Map<String, Integer> values = new HashMap<>();

  /**
   * 商品を1つ追加します（void戻り値）
   */
  public void add(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("item must not be null");
    }
    Integer current = values.getOrDefault(item.name(), 0);
    values.put(item.name(), current + 1);
  }

  /**
   * 指定した商品の在庫数を返します
   */
  public int getNum(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("item must not be null");
    }
    return values.getOrDefault(item.name(), 0);
  }
}
