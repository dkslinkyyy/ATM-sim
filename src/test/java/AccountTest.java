import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.Object.Account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void shouldAuthenticateWithCorrectPin() {
        Account account = new Account("1234");
        account.authenticate("1234");

        assertTrue(account.isAuthenticated());
    }
}

