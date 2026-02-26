package main.example;

import java.time.LocalDateTime;

public class User {
  // hasAllNullFieldsOrProperties()の検証のため、Integer型を指定
  private Integer id;
  private String name;
  private String plan;
  private LocalDateTime createdAt;
  private Address address;

  public User() {}

  public User(Integer id, String name, String plan, LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.plan = plan;
    this.createdAt = createdAt;
  }

  // Getter / Setter
  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPlan() {
    return plan;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
