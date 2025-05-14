package se.fredaw.tdd.atmsim.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import se.fredaw.tdd.atmsim.bank.User;
import se.fredaw.tdd.atmsim.repository.UserRepository;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticatorTest {

    private UserRepository userRepository;
    private Authenticator authenticator;
    private User testUser;

    @BeforeEach
    public void setup() {
        userRepository = mock(UserRepository.class);
        authenticator = new Authenticator(userRepository);
        testUser = new User("user123", "1234");
    }

    @Test
    public void testSuccessfulAuthenticationFirstTry() {
        when(userRepository.findById("user123")).thenReturn(testUser);

        Scanner scanner = new Scanner("1234\n");
        boolean result = authenticator.authenticateWithRetries(testUser, scanner);

        assertTrue(result);
    }

    @Test
    public void testSuccessfulAuthenticationOnThirdTry() {
        when(userRepository.findById("user123")).thenReturn(testUser);

        Scanner scanner = new Scanner("0000\n1111\n1234\n");
        boolean result = authenticator.authenticateWithRetries(testUser, scanner);

        assertTrue(result);
    }

    @Test
    public void testFailedAuthenticationAllAttempts() {
        when(userRepository.findById("user123")).thenReturn(testUser);

        Scanner scanner = new Scanner("0000\n1111\n2222\n");
        boolean result = authenticator.authenticateWithRetries(testUser, scanner);

        assertFalse(result);
    }

    @Test
    public void testUserNotFoundReturnsFalse() {
        when(userRepository.findById("user123")).thenReturn(null);

        Scanner scanner = new Scanner("1234\n");
        boolean result = authenticator.authenticateWithRetries(testUser, scanner);

        assertFalse(result);
    }
}
