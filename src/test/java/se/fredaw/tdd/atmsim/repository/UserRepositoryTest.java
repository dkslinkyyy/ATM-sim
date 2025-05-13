package se.fredaw.tdd.atmsim.repository;

import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.bank.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserRepositoryTest {
    @Test
    void shouldSaveAndRetrieveAccount() {
        UserRepository repo = new UserRepository();
        User user = new User("123", "TestUser");

        repo.save(user);
        assertEquals(user, repo.findById("123"));
    }

    @Test
    void shouldDeleteAccount() {
        UserRepository repo = new UserRepository();
        User user = new User("123", "TestUser");

        repo.save(user);
        repo.delete("123");

        assertNull(repo.findById("123"));
    }

}
