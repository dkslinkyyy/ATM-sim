package se.fredaw.tdd.atmsim;

import se.fredaw.tdd.atmsim.Object.ATMService;

import java.util.Scanner;

public class Core {
    public static void main(String[] args) {
        ATMService atmService = new ATMService(1000);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM simulator");
        System.out.println("Enter your pincode");
        String pincode = scanner.nextLine();

        //Test if the user has entered the correct Pin number
        if (!pincode.equals("0000")){
            System.out.println("Wrong pincode");
            System.out.println("Exiting the atm");
            System.out.println("Please try again with a correct pincode");
            return;
        }

        //Meny that will apear if the user is correct
        boolean authenticated = true;
        System.out.println("Authenticated");
        while (authenticated){
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the amount to withdraw");
                    scanner.nextLine();
                    int amountToWithdraw = scanner.nextInt();
                    System.out.println("Amount withdrawn: " + amountToWithdraw);
                    System.out.println(atmService.toString());
                    break;
                case 2:
            }
        }

        System.out.println("Enter amount to withdraw");
        int amount = scanner.nextInt();

        System.out.println("Enter amount to deposit");
        int amount2 = scanner.nextInt();

    }
}
