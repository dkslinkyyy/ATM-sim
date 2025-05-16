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
        account = new Account("Benny", 300);

    }

    @Test
    void ThrowsExceptionWhenWithdrawingMoreThanBalance() {
        TransactionRequest request = new TransactionRequest(account, 500, TransactionType.WITHDRAW);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            bank.attemptTransaction(request);
        });

        assertEquals(300, account.getBalance(), "Saldo ska inte ändras vid misslyckat uttag");
    }

    @Test
    void shouldWithdrawBalanceSuccessfully() {
        bank.attemptTransaction(new TransactionRequest(account, 300, TransactionType.WITHDRAW));

        assertEquals(0, account.getBalance(), "Saldo ska vara 0 efter korrekt uttag");
    }

}