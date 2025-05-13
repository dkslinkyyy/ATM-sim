package se.fredaw.tdd.atmsim;

import se.fredaw.tdd.atmsim.atm.ATMService;
import se.fredaw.tdd.atmsim.bank.Account;
import se.fredaw.tdd.atmsim.bank.Bank;
import se.fredaw.tdd.atmsim.bank.User;
import se.fredaw.tdd.atmsim.repository.UserRepository;
import java.util.List;
import java.util.Scanner;

public class Core {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMService atmService = new ATMService();
        UserRepository userRepoSwed = new UserRepository();
        UserRepository userRepoNord = new UserRepository();

        // Create banks and users
        Bank swedbank = new Bank("Swedbank", userRepoSwed);
        User user1 = new User("123", "Dawid");
        user1.addAccount(new Account("acc-001", "666", 377));
        swedbank.addUser(user1);

        Bank nordea = new Bank("Nordea", userRepoNord);
        User user2 = new User("500", "Fredrik");
        user2.addAccount(new Account("acc-002", "500", 5000));
        user2.addAccount(new Account("acc-003", "500", 6000));
        nordea.addUser(user2);

        List<Bank> banks = List.of(swedbank,  nordea);

        //?                  TODO:

        //* Break out the actual simulator from here to another class
        //* To much is going on and the Core class should only initialize it

        // Choose bank
        System.out.println("Choose your bank:");
        for (int i = 0; i < banks.size(); i++) {
            System.out.println((i + 1) + ". " + banks.get(i).getName());
        }
        System.out.print("Ditt val: ");
        int bankChoice = scanner.nextInt() - 1;
        Bank chosenBank = banks.get(bankChoice);

        scanner.nextLine(); // consume newline

        // Login user
        System.out.print("Enter your user ID: ");
        String userId = scanner.nextLine();
        User user = chosenBank.getUserById(userId);

        if (user == null) {
            System.out.println("User not found. Exiting.");
            return;
        }

        // Select account
        List<Account> accounts = user.getAccounts();
        if (accounts.isEmpty()) {
            System.out.println("No accounts found for user.");
            return;
        }

        System.out.println("Available accounts:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". Account ID: " + accounts.get(i).getAccountId());
        }
        System.out.print("Choose an account: ");
        int accountChoice = scanner.nextInt() - 1;
        scanner.nextLine();
        Account chosenAccount = accounts.get(accountChoice);

        // Authenticate with PIN
        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();
            if (chosenAccount.checkPin(pin)) {
                System.out.println("Authentication successful.");
                break;
            } else {
                attempts--;
                if (attempts == 0) {
                    System.out.println("Too many failed attempts. Exiting.");
                    return;
                }
                System.out.println("Wrong PIN. Attempts left: " + attempts);
            }
        }


        // Main menu
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n1. Withdraw\n2. Deposit\n3. Print balance\n4. Transaction history\n5. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount to withdraw: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        atmService.withdraw(chosenBank, chosenAccount, amount);
                        System.out.println("Withdrawal successful.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        atmService.deposit(chosenBank, chosenAccount, amount);
                        System.out.println("Deposit successful.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 3 -> atmService.printBalance(chosenAccount);
                case 4 -> {
                    System.out.println("Transaction history:");
                    chosenAccount.getTransactions().forEach(System.out::println);
                }
                case 5 -> {
                    System.out.println("Goodbye.");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
