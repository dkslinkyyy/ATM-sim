package se.fredaw.tdd.atmsim.bank.transaction;

import java.time.LocalDateTime;

public class Transaction {
    private TransactionType transactionType;

    private final TransactionType type;
    private final int amount;
    private final LocalDateTime time;

    public Transaction(TransactionType type, int amount) {
        this.type = type;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    public TransactionType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
