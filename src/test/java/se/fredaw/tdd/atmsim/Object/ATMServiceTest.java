package se.fredaw.tdd.atmsim.Object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ATMServiceTest {

  private ATMService atmService;
  private Account account;



  // When the test is started, the balance is set to 1000
  @BeforeEach
    void setup() {
      atmService = new ATMService();
      account = new Account("0000");
      account.authenticate("0000");

      account.setBalance (1000);

  }

@Test
void insufficientBalanceTest() {
    account.authenticate("0000");
    atmService.withdraw(account, 2001);
    assertEquals(1000, account.getBalance());
}


  @Test
  void shouldAuthenticateWithCorrectPin() {

    account.authenticate("0000");

    assertTrue(account.isAuthenticated());
  }

  //Here we test if the withdrawl function is correct
  @Test
    void withdrawTestandAuthenticate() {
    account.authenticate("0000");
    atmService.withdraw(account, 500);
    assertEquals(500, account.getBalance());



  }

  //Here we try to add money to the account
  @Test
    void depositTestandAuthenticate(){
    account.authenticate("0000");
    assertTrue(account.isAuthenticated());
    atmService.deposit(account, 500);
    assertEquals(1500, account.getBalance());
  }


}