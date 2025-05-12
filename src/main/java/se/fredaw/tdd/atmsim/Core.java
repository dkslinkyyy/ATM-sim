package se.fredaw.tdd.atmsim;

import se.fredaw.tdd.atmsim.atm.ATMService;
import se.fredaw.tdd.atmsim.bank.Account;
import se.fredaw.tdd.atmsim.bank.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Core {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMService atmService = new ATMService();

        //Create a list of Bank that will store stuff
        List<Bank> banks = new ArrayList<>();

        //Adding a Bank called Swedbank
        Bank swedbank = new Bank("Swedbank");
        swedbank.addAccount(new Account("Transsaction", "666", 666));
        swedbank.addAccount(new Account("Saving-Account", "666", 377));

        //Adding more banks
        Bank nordea = new Bank("Nordea");
        nordea.addAccount(new Account("Transsaction", "500", 5000));
        nordea.addAccount(new Account("Saving-Account","500", 6000));

        //Adding the banks to the list
        banks.add(swedbank);
        banks.add(nordea);

        //Choose your bank
        System.out.println("Choose your bank");
        for (int i = 0; i < banks.size(); i++){
            System.out.println((i+1) + ". " + banks.get(i).getName());

        }
        System.out.println();
        System.out.print("Ditt val: ");
        int bankChoice = scanner.nextInt() -1;
        Bank chosenBank = banks.get(bankChoice);

        //Write the account from the chosen bank
        System.out.println("Account in: " + chosenBank.getName());
        List<Account> accounts = chosenBank.getAccounts();

        for (int i = 0; i < accounts.size(); i++){
            System.out.println((i+1) + ". Account ID: " + accounts.get(i).getAccountId());
        }
        int accountChoice = scanner.nextInt() -1;
        Account chosenAccount = accounts.get(accountChoice);

        //Log in with your PINCODE
        int authAttempts = 3;
        String pincode = "";
        pincode = scanner.nextLine();
        while (authAttempts > 0) {
            System.out.println("Log in with your PINCODE:");
            pincode = scanner.nextLine();

            if (chosenAccount.checkPin(pincode)) {
                System.out.println("PIN correct");
                break;
            } else {
                authAttempts--;
                if (authAttempts == 0) {
                    System.out.println("\nToo many failed attempts.");
                    System.out.println("EXITING");
                    break;
                }
                System.out.println("Wrong pincode. Attempts left: " + authAttempts);

            }
        }

        //Avbryt programmet
        if(!chosenAccount.checkPin(pincode)) return;



        boolean isRunning = true;
        while (isRunning){
            System.out.println();
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Print the balance");
            System.out.println();
            System.out.print("Ditt val: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 ->{
                    System.out.println();
                    System.out.println("Enter the amount to withdraw");
                    scanner.nextLine();
                    int amountToWithdraw = scanner.nextInt();
                    atmService.withdraw(chosenAccount, amountToWithdraw);

                }
                case 2 -> {
                    System.out.println();
                    System.out.println("Enter the amount to deposit");
                    scanner.nextLine();
                    int amountToDeposit = scanner.nextInt();
                    atmService.deposit(chosenAccount, amountToDeposit);


                }
                case 3 -> {
                    System.out.println();
                    System.out.println("Printing the balance");
                    System.out.println();
                    System.out.println();
                    atmService.printBalance(chosenAccount);

                }

                case 4 -> {
                    System.out.println("Exiting");
                    isRunning = false;
                }

            }
        }

    }

}
