package main.example;

public interface AccountDao {
  Account findOrNull(String userId);
}
