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
        user = new User("500", "Benny");
        user.addAccount(new Account("acc-001", "666", 377));
    }

    @Test
    void testToSeeIfThereAreAccountsInTheUserList() {
        assertEquals("acc-001", user.getAccounts());
    }
}
