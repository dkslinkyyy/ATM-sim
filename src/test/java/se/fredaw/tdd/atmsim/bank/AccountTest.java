package se.fredaw.tdd.atmsim.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {
    @BeforeEach
    void setUp(){
        Account account = new Account("abc1234", "1234", 1000);
    }

    //1: Uttag med giltigt belopp
    //2 Uttag med för stort belopp
    //3 Uttag med 0 pengar på kontot
    //4 Uttag med negativt belopp

    @Test
    void shouldWithDrawalTheMoneyAndBalanceShouldDecrease() {
        Account account = new Account("abc1234", "1234", 1000);
        account.withdraw(200);

        assertEquals(800, account.getBalance());
    }

    @Test
    void deposit() {
        Account account = new Account("abc1234", "1234", 1000);
        account.deposit(200);

        assertEquals(1200, account.getBalance());
    }

    @Test
    void shouldRecordTheTranssationHistoryAndReturnIt(){
        Account account = new Account("abc1234", "1234", 1000);
        account.deposit(300);
        account.withdraw(500);

        List<Transaction> accountHistory = account.getTransactions();

        assertEquals(2, accountHistory.size());


        //Check the history of deposit
        assertEquals(Transaction.Type.DEPOSIT, accountHistory.get(0).getType());
        assertEquals(300, accountHistory.get(0).getAmount());

        //Check the history of withdraw
        assertEquals(Transaction.Type.WITHDRAWAL, accountHistory.get(1).getType());
        assertEquals(500, accountHistory.get(1).getAmount());


    }
}