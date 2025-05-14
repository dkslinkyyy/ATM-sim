package se.fredaw.tdd.atmsim.auth;

import se.fredaw.tdd.atmsim.bank.User;

import java.util.Scanner;

public class Authenticator {

    private static final int MAX_ATTEMPTS = 3;

    public boolean authenticateWithRetries(User user, Scanner scanner) {
        int attemptsLeft = MAX_ATTEMPTS;

        while (attemptsLeft > 0) {
            System.out.print("Enter PIN: ");
            String inputPin = scanner.nextLine();

            Credentials userCredentials = user.getCredentials();

            if (isPinValid(userCredentials, inputPin)) {
                System.out.println("Authentication successful.");
                return true;
            } else {
                attemptsLeft--;
                if (attemptsLeft == 0) {
                    System.out.println("Too many failed attempts. Exiting.");
                } else {
                    System.out.println("Wrong PIN. Attempts left: " + attemptsLeft);
                }
            }
        }

        return false;
    }

    private boolean isPinValid(Credentials credentials, String inputPin) {
        return credentials.getPincode().equals(inputPin);
    }
}
