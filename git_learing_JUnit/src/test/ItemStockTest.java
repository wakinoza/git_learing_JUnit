package test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.example.Item;
import main.example.ItemStock;

class ItemStockTest {
  Item apple = new Item("Apple", 100);
  ItemStock stock;

  @BeforeEach
  @Test
  void setUp() {
    stock = new ItemStock();
  }


  @Test
  @DisplayName("初期状態では在庫数は0であること")
  void getNum_初期状態() {
    assertThat(stock.getNum(apple)).isZero();
  }

  @Test
  @DisplayName("addを呼ぶと在庫数が1増えること（voidメソッドのテスト）")
  void add_在庫が追加される() {
    stock.add(apple);

    assertThat(stock.getNum(apple)).as("Appleの在庫数").isEqualTo(1);
  }

  @Test
  @DisplayName("同じ商品を複数回addすると、その分在庫が増えること")
  void add_複数回追加() {
    stock.add(apple);
    stock.add(apple);

    assertThat(stock.getNum(apple)).isEqualTo(2);
  }

  @Test
  @DisplayName("別の商品をaddしても、対象の商品の在庫数には影響しないこと")
  void add_他商品への影響() {
    Item orange = new Item("Orange", 120);
    stock.add(apple);
    stock.add(orange);

    assertThat(stock.getNum(apple)).isEqualTo(1);
    assertThat(stock.getNum(orange)).isEqualTo(1);
  }

  @Test
  @DisplayName("addメソッドにnullを渡すとIllegalArgumentExceptionをスローすること")
  void add_null_should_throw_exception() {
    assertThatThrownBy(() -> stock.add(null)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("item must not be null");
  }

  @Test
  @DisplayName("getNumメソッドにnullを渡すとIllegalArgumentExceptionをスローすること")
  void getNum_null_should_throw_exception() {
    assertThatThrownBy(() -> stock.getNum(null)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("item must not be null");
  }

}
