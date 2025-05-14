package se.fredaw.tdd.atmsim.Instance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.bank.Bank;
import se.fredaw.tdd.atmsim.repository.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ATMSimulatorTest {
    private ATMSimulator atm;
    private List<Bank> banks;
    @BeforeEach
    void setUp() {
        atm = new ATMSimulator();

        banks = List.of(new Bank("Swedbank", new UserRepository()));


    }
    //* This test is to make sure that it throws an exception
    //* When the user choice of a bank is negative/not there
    @Test
    void whenTheBankChoiceIsNegativeItShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            atm.validatoionOfBankChoice(-1, banks);
        });

    }
}