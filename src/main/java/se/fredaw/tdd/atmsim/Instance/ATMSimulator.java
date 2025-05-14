package se.fredaw.tdd.atmsim.Instance;

import se.fredaw.tdd.atmsim.atm.ATMService;
import se.fredaw.tdd.atmsim.bank.Account;
import se.fredaw.tdd.atmsim.bank.Bank;
import se.fredaw.tdd.atmsim.bank.User;
import se.fredaw.tdd.atmsim.misc.Utils;

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

        //* Added a Trycatch in case the user tries to select a bank that is not there
        try {
            validatoionOfBankChoice(bankChoice, banks);
        }

        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        Bank chosenBank = banks.get(bankChoice);

        scanner.nextLine(); // consume newline

        login(scanner,atmService,chosenBank);


    }


    //* Login function
    private void login(Scanner scanner, ATMService atmService, Bank chosenBank) {
        // Login user
        System.out.print("Enter your user ID: ");
        String userId = scanner.nextLine();
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



        ATM(scanner, atmService, chosenBank, chosenAccount);
    }

    private void ATM(Scanner scanner, ATMService atmService, Bank chosenBank, Account chosenAccount) {
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
            printMenu();
            int choice = Utils.scannerInt(scanner,"");

            switch (choice) {
                case 1 -> withdraw(scanner,atmService,chosenBank,chosenAccount);
                case 2 -> deposit(scanner,atmService,chosenBank,chosenAccount);
                case 3 -> balance(chosenAccount);
                case 4 -> transactionHistory(chosenAccount);
                case 5 -> isRunning=false;
                default -> System.out.println("Invalid option.");
            }
        }
    }





    private void withdraw(Scanner scanner,ATMService atmService, Bank chosenBank, Account chosenAccount){
        int amount = promptAmount(scanner, "withdraw");

        try {
            atmService.withdraw(chosenBank, chosenAccount, amount);
            System.out.println("Withdrawal successful.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void deposit(Scanner scanner,ATMService atmService, Bank chosenBank, Account chosenAccount){
        int amount = promptAmount(scanner, "deposit");

        try {
            atmService.deposit(chosenBank, chosenAccount, amount);
            System.out.println("Deposit successful.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void transactionHistory(Account chosenAccount){
        System.out.println("Transaction history:");
        chosenAccount.getTransactions().forEach(System.out::println);
    }

    private void balance(Account chosenAccount){
        System.out.println("Balance: " + chosenAccount.getBalance());
    }

    private void printMenu() {
        System.out.println("\n1. Withdraw\n2. Deposit\n3. Print balance\n4. Transaction history\n5. Exit");
        System.out.print("Your choice: ");
    }

    private void validatoionOfBankChoice(int choice, List<Bank> banks){
        if (choice < 0 || choice >= banks.size()){
            throw new IllegalArgumentException("Invalid bank choice. Please choose a valid bank.");
        }

    }

    //Help function to make it easier to read.
    // Adds the scanner function and an amount for both deposit and withdrawal
    private int promptAmount(Scanner scanner, String action){
        return Utils.scannerInt(scanner, "Enter amount to " + action + ": ");
    }


}
