package se.fredaw.tdd.atmsim.bank.transaction;

import se.fredaw.tdd.atmsim.bank.Account;

public class TransactionRequest {
    private final Account account;
    private final int amount;
    private final TransactionType type;

    public TransactionRequest(Account account, int amount, TransactionType type) {
        this.account = account;
        this.amount = amount;
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public int getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
}
