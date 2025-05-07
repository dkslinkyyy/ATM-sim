package se.fredaw.tdd.atmsim.Object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ATMServiceTest {

  private ATMService atmService;
  private Account account;


  // When the test is started, the balance is set to 1000
  @BeforeEach
    void setup() {
      atmService = new ATMService();
      account = new Account();
      account.setBalance (1000);



  }

  //Here we test if the withdraw function is correct
  @Test
    void withdrawTest() {
    atmService.withdraw(account, 500);
    assertEquals(500, account.getBalance());



  }

  //Here we try to add money to the account
  @Test
    void depositTest(){
    atmService.deposit(account, 500);
    assertEquals(1500, account.getBalance());
  }


}