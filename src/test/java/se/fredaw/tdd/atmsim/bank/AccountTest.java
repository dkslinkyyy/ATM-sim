package se.fredaw.tdd.atmsim.bank;

import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.bank.transaction.Transaction;
import se.fredaw.tdd.atmsim.bank.transaction.TransactionType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {
//
//
//    @Test
//    void shouldWithDrawalTheMoneyAndBalanceShouldDecrease() {
//        Account account = new Account("abc1234", "1234", 1000);
//        account.withdraw(200);
//
//        assertEquals(800, account.getBalance());
//    }
//
//    @Test
//    void withDrawalOfNegativeAmountShouldThrowException(){
//        Account account = new Account("abc1234", "1234", 1000);
//        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1200) );
//    }
//
//    @Test
//    void shouldDepositTheMoneyAndBalanceShouldIncrease() {
//        Account account = new Account("abc1234", "1234", 1000);
//        account.deposit(200);
//
//        assertEquals(1200, account.getBalance());
//    }
//
//
//
//    @Test
//    void shouldRecordTheTranssationHistoryAndReturnIt(){
//        Account account = new Account("abc1234", "1234", 1000);
//        account.deposit(300);
//        account.withdraw(500);
//
//        List<Transaction> accountHistory = account.getTransactions();
//
//        assertEquals(2, accountHistory.size());
//
//
//        //Check the history of deposit
//        assertEquals(TransactionType.DEPOSIT, accountHistory.get(0).getType());
//        assertEquals(300, accountHistory.get(0).getAmount());
//
//        //Check the history of withdraw
//        assertEquals(TransactionType.WITHDRAW, accountHistory.get(1).getType());
//        assertEquals(500, accountHistory.get(1).getAmount());
//
//
//    }
}