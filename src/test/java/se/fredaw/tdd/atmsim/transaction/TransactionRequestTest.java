package se.fredaw.tdd.atmsim.bank;

import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.bank.transaction.TransactionRequest;
import se.fredaw.tdd.atmsim.bank.transaction.TransactionType;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRequestTest {

    @Test
    void testTransactionRequestStoresValuesCorrectly() {
        Account account = new Account("acc123", 1000);
        int amount = 200;
        TransactionType type = TransactionType.WITHDRAW;

        TransactionRequest request = new TransactionRequest(account, amount, type);

        assertEquals(account, request.getAccount());
        assertEquals(amount, request.getAmount());
        assertEquals(type, request.getType());
    }
}
