package se.fredaw.tdd.atmsim.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.bank.transaction.Transaction;
import se.fredaw.tdd.atmsim.bank.transaction.TransactionRequest;
import se.fredaw.tdd.atmsim.bank.transaction.TransactionType;
import se.fredaw.tdd.atmsim.repository.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {
    private Bank bank;
    private Account account;

    @BeforeEach
    void setUp() {
        UserRepository userRepository = new UserRepository();
        bank = new Bank("Swedbank", userRepository);
        account = new Account("300", "500", 1000);

    }


    @Test
    void shouldWithDrawalTheMoneyAndBalanceShouldDecrease() {

        bank.attemptTransaction(new TransactionRequest(account,200, TransactionType.WITHDRAW));

        assertEquals(800, account.getBalance());
    }

    @Test
    void withDrawalOfNegativeAmountShouldThrowException(){

        assertThrows(IllegalArgumentException.class, () -> bank.attemptTransaction(new TransactionRequest(account,1200, TransactionType.WITHDRAW)) );
    }

    @Test
    void shouldDepositTheMoneyAndBalanceShouldIncrease() {
        bank.attemptTransaction(new TransactionRequest(account,200, TransactionType.DEPOSIT));

        System.out.println("Account balance should be 1200 to be correct:  ");
        System.out.println("Account balance is :" + account.getBalance());
        assertEquals(1200, account.getBalance());

    }



    @Test
    void shouldRecordTheTranssationHistoryAndReturnIt(){
        bank.attemptTransaction(new TransactionRequest(account,200, TransactionType.WITHDRAW));

        List<Transaction> accountHistory = account.getTransactions();

        assertEquals(2, accountHistory.size());


        //Check the history of deposit
        assertEquals(TransactionType.DEPOSIT, accountHistory.get(0).getType());
        assertEquals(300, accountHistory.get(0).getAmount());

        //Check the history of withdraw
        assertEquals(TransactionType.WITHDRAW, accountHistory.get(1).getType());
        assertEquals(500, accountHistory.get(1).getAmount());


    }

}