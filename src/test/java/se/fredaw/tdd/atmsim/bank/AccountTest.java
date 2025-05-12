package se.fredaw.tdd.atmsim.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
    void withdraw() {
    }

    @Test
    void deposit() {
    }

    @Test
    void shouldRecordTheTranssationHistoryAndReturnIt(){
        Account account = new Account("abc1234", "1234", 1000);
        account.deposit(300);
        account.withdraw(500);

        List<Transsaction> accountHistory = acc.getTranssationHistory();

        assertEquals(2, accountHistory.size);


        //Check the history of deposit
        assertEquals(Transsaction.Type.WITHDRAWAL, history.get(0),getType());
        assertEquals(300, history.get(0).getAmount());

        //Check the history of withdraw
        assertEquals(Transsaction.Type.DEPOSIT, history.get(0),getType());
        assertEquals(100, history.get(1).getAmount());


    }
}