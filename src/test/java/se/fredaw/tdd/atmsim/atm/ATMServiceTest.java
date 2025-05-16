package se.fredaw.tdd.atmsim.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.bank.*;
import se.fredaw.tdd.atmsim.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

class ATMServiceTest {

  private ATMService atmService;
  private Account account;
  private Bank bank;

  @BeforeEach
  void setUp() {
    atmService = new ATMService();
    UserRepository userRepository = new UserRepository();
    account = new Account("acc001", 1234);
    bank = new Bank("Swedbank", userRepository);
  }

  @Test
  void testWithdrawValidAmount() {
    atmService.withdraw(bank, account, 200);
    assertEquals(1034, account.getBalance());
  }

  @Test
  void testWithdrawInvalidAmount() {
    assertThrows(IllegalArgumentException.class, () -> {
      atmService.withdraw(bank, account, -100);
    });
  }

  @Test
  void testWithdrawTooMuch() {
    assertThrows(RuntimeException.class, () -> {
      atmService.withdraw(bank, account, 1500);
    });
  }

  @Test
  void testDepositValidAmount() {
    atmService.deposit(bank, account, 300);
    assertEquals(1534, account.getBalance());
  }

  @Test
  void testDepositInvalidAmount() {
    assertThrows(IllegalArgumentException.class, () -> {
      atmService.deposit(bank, account, 0);
    });
  }
}
