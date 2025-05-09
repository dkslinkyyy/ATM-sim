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
}