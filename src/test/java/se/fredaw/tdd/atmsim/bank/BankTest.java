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

        assertEquals(2, bank.getAccounts().size());
        assertEquals(account1, bank.getAccounts().get(0));
        assertEquals(account2, bank.getAccounts().get("id2"));
    }




}
