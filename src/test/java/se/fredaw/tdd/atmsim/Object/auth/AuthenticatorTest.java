package se.fredaw.tdd.atmsim.Object.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.Object.Account;

import java.net.Authenticator;

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

        assertTrue(authenticator.attempt("abc123", "1234"));
    }


    @Test
    public void testAuthenticationFailsWithWrongPin() {
        Account account = new Account("abc123", "4321");

        assertFalse(authenticator.attempt("abc123", "12345"));
    }
}
