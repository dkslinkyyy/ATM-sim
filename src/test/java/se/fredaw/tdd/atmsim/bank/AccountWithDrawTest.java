package se.fredaw.tdd.atmsim.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.bank.transaction.TransactionRequest;
import se.fredaw.tdd.atmsim.bank.transaction.TransactionType;
import se.fredaw.tdd.atmsim.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

class AccountWithDrawTest {
    private Bank bank;
    private Account account;

    @BeforeEach
    void setUp() {
        UserRepository userRepository = new UserRepository();
        bank = new Bank("Swedbank", userRepository);
        account = new Account("Benny", "300", 1000);

    }

    @Test
    void withdrawItShouldFailBecauseTheAmountisLowerThenWhatisInTotal() {

        try{
            bank.attemptTransaction(new TransactionRequest(account,300, TransactionType.WITHDRAW));
        }
        catch (IllegalArgumentException e){
            assertEquals("Insufficient funds", e.getMessage());
        }

        assertNotEquals(500, account.getBalance());

    }

    @Test
    void withdrawItShouldWorkBecauseTotalisCorrect() {

        try{
            bank.attemptTransaction(new TransactionRequest(account,700, TransactionType.WITHDRAW));
        }
        catch (IllegalArgumentException e){
            assertEquals("Insufficient funds", e.getMessage());
        }

        assertEquals(300, account.getBalance());
    }

}