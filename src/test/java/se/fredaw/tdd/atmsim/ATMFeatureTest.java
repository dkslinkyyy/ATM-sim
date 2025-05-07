package se.fredaw.tdd.atmsim;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ATMFeatureTest {

  private ATMService atmService;
  private Account account;


  @BeforeEach
    void setup() {
      atmService = new ATMService();
      account = new Account();
      account.setBalance (1000);


  }

  @Test
    void withdrawTest() {
    atmService.withdraw(account, 500);
    assertEquals(500, account.getBalance());



  }

  @Test
    void depositTest(){
    atmService.desposit(account, 500);
    assertEquals(1500, account.getBalance());
  }


}