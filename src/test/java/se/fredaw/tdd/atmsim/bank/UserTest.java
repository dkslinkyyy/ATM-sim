package se.fredaw.tdd.atmsim.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UserTest {
    private User user;
    private List<Account> accounts;

    @BeforeEach
    public void setUp() {
        user = new User(500, "Benny", "377");
        user.addAccount(new Account("acc-001", 1000));
    }

    @Test
    void testToSeeIfThereAreAccountsInTheUserList() {
        List<Account> accounts = user.getAccounts();

        assertEquals(1, accounts.size());
        assertEquals("acc-001", accounts.get(0).getAccountId());
        assertEquals(1000, accounts.get(0).getBalance());
    }
}
