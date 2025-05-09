package se.fredaw.tdd.atmsim;

import se.fredaw.tdd.atmsim.Object.ATMService;
import se.fredaw.tdd.atmsim.Object.Account;
import se.fredaw.tdd.atmsim.Object.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Core {

    public static void main(String[] args) {

        ATMService atmService = new ATMService();

        //Skapa en lista med banker som man kan välja
        List<Bank> banks = new ArrayList<>();

        banks.add(new Bank("SwedBank", "5555", 1000));
        banks.add(new Bank("HandelsBanken", "5555", 1000));
        banks.add(new Bank("Nordea", "5555", 1000));

        //Create an account with a specific pin
        Account acc = new Account("0000", startingBalance);
        Scanner scanner = new Scanner(System.in);
        acc.setBalance(1000);

        //Meny that will apear if the user is correct
        boolean isRunning = true;

        boolean isAuthenticated = true;

        while (isAuthenticated){
            System.out.println();
            System.out.println("Enter your pincode");
            String pincode = scanner.nextLine();
            acc.authenticate(pincode);

            if(acc.isAuthenticated()) {
                isAuthenticated = false;
                System.out.println();
                System.out.println("Authenticated is successful");
            }

            else{
                System.out.println();
                System.out.println("Authentication failed");
                System.out.println("Please try again");
            }
        }

        while (isRunning){



            System.out.println();
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println();
                    System.out.println("Enter the amount to withdraw");
                    scanner.nextLine();
                    int amountToWithdraw = scanner.nextInt();
                    if(acc.attemptTransaction(Account.TransactionType.WITHDRAW, amountToWithdraw)) {
                        atmService.withdraw(acc, amountToWithdraw);
                        System.out.println("Amount withdrawn: " + amountToWithdraw);
                        System.out.println(acc);
                    }else {
                        System.out.println("Insufficient funds");
                    }

                    break;
                case 2:
                    System.out.println();
                    System.out.println("Enter the amount to deposit");
                    scanner.nextLine();
                    int amountToDeposit = scanner.nextInt();
                    if(acc.attemptTransaction(Account.TransactionType.DEPOSIT, amountToDeposit)) {
                        atmService.deposit(acc, amountToDeposit);
                        System.out.println("Amount deposited: " + amountToDeposit);
                        System.out.println(acc);
                    }
                    break;

                case 3:
                    isRunning = false;
                    break;
            }
        }

    }

}
