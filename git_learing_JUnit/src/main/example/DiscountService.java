package main.example;

// DiscountService.java
public class DiscountService {
  public double calculateDiscountRate(Member member) {
    if (member.isGoldCard())
      return 0.2;
    if (member.age() < 18)
      return 0.1;
    return 0.0;
  }
}
