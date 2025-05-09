package se.fredaw.tdd.atmsim.Object.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.Object.Account;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticatorTest {

    private Authenticator authenticator;
    @BeforeEach
    void setup() {
        authenticator = new Authenticator();
    }



    @Test
    void testAuthenticationSuccess() {
        Account account = new Account("abc123", "1234");
        boolean result = authenticator.attempt("abc123", "1234",
                (acc, pin) -> acc.getPin().equals(pin));
        assertTrue(result);
    }


    @Test
    public void testAuthenticationFailsWithWrongPin() {
        Account account = new Account("abc123", "4321");
        boolean result = authenticator.attempt("abc123", "1234",
                (acc, pin) -> acc.getPin().equals(pin));

        assertFalse(result);
    }
}
