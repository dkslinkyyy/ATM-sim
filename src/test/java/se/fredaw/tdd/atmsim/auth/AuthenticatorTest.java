package se.fredaw.tdd.atmsim.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import se.fredaw.tdd.atmsim.bank.User;
import se.fredaw.tdd.atmsim.repository.Repository;
import se.fredaw.tdd.atmsim.repository.UserRepository;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticatorTest {

    private Authenticator authenticator;
    private User testUser;

    @BeforeEach
    public void setup() {
        authenticator = new Authenticator();
        testUser = new User(12, "TestUser", "1234");
    }

    @Test
    public void testSuccessfulAuthenticationFirstTry() {

        Scanner scanner = new Scanner("1234\n");
        boolean result = authenticator.authenticateWithRetries(testUser, scanner);

        assertTrue(result);
    }

    @Test
    public void testSuccessfulAuthenticationOnThirdTry() {
        Scanner scanner = new Scanner("0000\n1111\n1234\n");
        boolean result = authenticator.authenticateWithRetries(testUser, scanner);

        assertTrue(result);
    }

}
