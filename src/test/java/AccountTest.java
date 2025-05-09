import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.Object.Account;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account account;
    @BeforeEach
    void setup() {
        account = new Account("1234", startingBalance);
        account.authenticate("1234");
    }

    @Test
    void shouldAuthenticateWithCorrectPin() {


        assertTrue(account.isAuthenticated());
    }

    @Test
    void shouldNotAuthenticateWithWrongPin() {
        account.authenticate("");
        assertFalse(account.isAuthenticated());
    }



}

