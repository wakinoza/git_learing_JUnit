package main.example;

public class Address {
  private String city;
  private String prefecture;

  public Address(String city, String prefecture) {
    this.city = city;
    this.prefecture = prefecture;
  }

  // Getter
  public String getCity() {
    return city;
  }

  public String getPrefecture() {
    return prefecture;
  }
}
