package se.fredaw.tdd.atmsim.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    @Test
    void bankShouldHaveAccountsAndReturn() {
        Bank bank = new Bank("Testbank");
        Account account1 = new Account("person1", "1234", 1000);
        Account account2 = new Account("person2", "1234", 1000);

        bank.addAccount(account1);
        bank.addAccount(account2);

        //Check if the bank has 2 accounts or not
        assertEquals(2, bank.getAccounts().size());
        assertEquals(account1, bank.findAccountbyId("person1"));
        assertEquals(account2, bank.findAccountbyId("person2"));
    }

    @Test
    void shouldReturnNullBecauseTheAccountDoesntExistInTheList(){
        Bank bank = new Bank("Testbank");
        bank.addAccount(new Account("person1", "1234", 1000));

        //Try to see if you can find a account or not
        assertNull(bank.findAccountbyId("person2"));

    }





}
