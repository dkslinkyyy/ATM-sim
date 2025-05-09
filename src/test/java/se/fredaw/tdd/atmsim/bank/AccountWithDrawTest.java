package se.fredaw.tdd.atmsim.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountWithDrawTest {

    @Test
    void withdrawItShouldFailBecauseTheAmountisLowerThenWhatisInTotal() {
        Account account = new Account("0000",1000);

        try{
            account.withdraw(700);
        }
        catch (IllegalArgumentException e){
            assertEquals("Insufficient funds", e.getMessage());
        }

        assertEquals(500, account.getBalance());

    }

    @Test
    void withdrawItShouldWorkBecauseTotalisCorrect() {
        Account account = new Account("0000",1000);

        try{
            account.withdraw(700);
        }
        catch (IllegalArgumentException e){
            assertEquals("Insufficient funds", e.getMessage());
        }

        assertEquals(300, account.getBalance());

    }


}