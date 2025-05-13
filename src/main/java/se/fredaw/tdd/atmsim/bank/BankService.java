package se.fredaw.tdd.atmsim.bank;

import se.fredaw.tdd.atmsim.bank.transaction.TransactionRequest;

public interface BankService {
    void attemptTransaction(TransactionRequest request);
}
