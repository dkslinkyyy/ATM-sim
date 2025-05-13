package se.fredaw.tdd.atmsim.bank;

import se.fredaw.tdd.atmsim.bank.transaction.Transaction;
import se.fredaw.tdd.atmsim.bank.transaction.TransactionRequest;
import se.fredaw.tdd.atmsim.bank.transaction.TransactionType;
import se.fredaw.tdd.atmsim.misc.Message;
import se.fredaw.tdd.atmsim.misc.Utils;
import se.fredaw.tdd.atmsim.repository.UserRepository;

public class Bank implements BankService{
    private final String name;
    private final UserRepository userRepository;

    public Bank(String name, UserRepository userRepository) {
        this.name = name;
        this.userRepository = userRepository;
    }

    public String getName() {
        return name;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void attemptTransaction(TransactionRequest request) {
        Account account = request.getAccount();
        int amount = request.getAmount();
        TransactionType type = request.getType();

        switch (type) {
            case WITHDRAW -> {
                if (amount <= 0) {
                    throw new IllegalArgumentException("Amount must be greater than 0");
                }
                if (account.getBalance() < amount) {

                    Utils.throwWith(Message.INSUFFICIENT_BALANCE, IllegalArgumentException::new);
                }
                account.setBalance(account.getBalance() - amount);
                account.addTransaction(new Transaction(type, amount));
            }
            case DEPOSIT -> {
                if (amount <= 0) {
                    throw new IllegalArgumentException("Amount must be greater than 0");
                }
                account.setBalance(account.getBalance() + amount);
                account.addTransaction(new Transaction(type, amount));

            }
        }
    }
}
