package se.fredaw.tdd.atmsim;

import se.fredaw.tdd.atmsim.atm.ATMService;
import se.fredaw.tdd.atmsim.bank.Account;
import se.fredaw.tdd.atmsim.bank.Bank;

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
        Account acc = new Account("abc1234", "1234", 0000);
        Scanner scanner = new Scanner(System.in);
        acc.setBalance(1000);

        //Meny that will appear if the user is correct
        boolean isRunning = true;

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
                    try{
                        atmService.withdraw(acc, amountToWithdraw);
                        System.out.println(acc);
                    }
                    catch (IllegalArgumentException e){
                        System.out.println("The withdraw failed due to an error" + " " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Enter the amount to deposit");
                    scanner.nextLine();
                    int amountToDeposit = scanner.nextInt();
                    try{
                        atmService.deposit(acc, amountToDeposit);
                        System.out.println(acc);
                    }
                    catch (IllegalArgumentException e){
                        System.out.println("The deposit failed due to an error" + e.getMessage());
                    }

                case 3:
                    isRunning = false;
                    break;
            }
        }

    }

}
