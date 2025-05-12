package se.fredaw.tdd.atmsim.bank;

import java.time.LocalDateTime;

public class Transaction {
    public enum Type {DEPOSIT, WITHDRAWAL}

    private final Type type;
    private final int amount;
    private final LocalDateTime time;

    public Transaction(Type type, int amount) {
        this.type = type;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    public Type getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
