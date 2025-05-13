package se.fredaw.tdd.atmsim.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank bank;

    @BeforeEach
    void setUp() {
        UserRepository userRepository = new UserRepository();
        bank = new Bank("Swedbank", userRepository);

        User user = new User("300", "Benny");
    }
    @Test
    void bankShouldHaveUserandUserIdAndReturn() {
        //Check if the bank has a user with the ID 300
        assertEquals(300, bank.getUserById("300").getUserId());

        //Check if the bank has a user called Benny
        assertEquals("Benny", bank.getUserById("300").getName());
    }

    @Test
    void shouldReturnNullBecauseTheAccountDoesntExistInTheList(){
        //Try to see if you can find a account by the Id or not
        assertNull(bank.getUserById("400").getUserId());

    }


}
