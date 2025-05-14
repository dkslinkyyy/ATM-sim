package se.fredaw.tdd.atmsim.Instance;

import se.fredaw.tdd.atmsim.atm.ATMService;
import se.fredaw.tdd.atmsim.auth.Authenticator;
import se.fredaw.tdd.atmsim.bank.Account;
import se.fredaw.tdd.atmsim.bank.Bank;
import se.fredaw.tdd.atmsim.bank.User;

import java.util.List;
import java.util.Scanner;

public class ATMSimulator {


    public void init(List<Bank> banks, Scanner scanner, ATMService atmService) {

        System.out.println("Choose your bank:");
        for (int i = 0; i < banks.size(); i++) {
            System.out.println((i + 1) + ". " + banks.get(i).getName());
        }
        System.out.print("Ditt val: ");
        int bankChoice = scanner.nextInt() - 1;
        Bank chosenBank = banks.get(bankChoice);

        scanner.nextLine(); // consume newline

        login(scanner,atmService,chosenBank);


    }


    //* Login function
    private void login(Scanner scanner, ATMService atmService, Bank chosenBank) {
        // Login user
        System.out.print("Enter your user ID: ");
        int userId = scanner.nextInt();
        User user = chosenBank.getUserById(userId);

        if (user == null) {
            System.out.println("User not found. Exiting.");
            return;
        }


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



        ATM(scanner, atmService, chosenBank, chosenAccount, user);
    }

    private void ATM(Scanner scanner, ATMService atmService, Bank chosenBank, Account chosenAccount, User user) {
        // Authenticate with PIN

        //! TODO TODO TODO
        //!
        //! Remove this authentator and replace it with the already existing class
        //!

        Authenticator authenticator = new Authenticator();

        if(!authenticator.authenticateWithRetries(user, scanner)) {
            return;
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
