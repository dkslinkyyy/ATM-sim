import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.Object.Account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void shouldSetBalanceWithCorrectPin() {
        Account account = new Account("1234");
        account.setBalance(500, "1234");
        assertEquals(500, account.getBalance());
    }

    @Test
    void shouldThrowIfWrongPin() {
        Account account = new Account("1234");
        Exception exception = assertThrows(SecurityException.class, () -> {
            account.setBalance(500, "0000");
        });
        assertEquals("PIN code is incorrect", exception.getMessage());
    }
}

