package se.fredaw.tdd.atmsim;

import se.fredaw.tdd.atmsim.Instance.ATMSimulator;
import se.fredaw.tdd.atmsim.atm.ATMService;
import se.fredaw.tdd.atmsim.bank.Account;
import se.fredaw.tdd.atmsim.bank.Bank;
import se.fredaw.tdd.atmsim.bank.BankStorage;
import se.fredaw.tdd.atmsim.bank.User;
import se.fredaw.tdd.atmsim.misc.Message;
import se.fredaw.tdd.atmsim.misc.Utils;
import se.fredaw.tdd.atmsim.repository.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Core {
    public static void main(String[] args) throws IOException {
        //Test for writer of information
        BankStorage bankStorage = new BankStorage();
        bankStorage.makeFileJava7();
        System.out.println("Skapar en fil");

        String content = Files.readString(Path.of("myFile.txt"));
        System.out.println("Information i filen: " + content);
        /*
        Scanner scanner = new Scanner(System.in);
        ATMService atmService = new ATMService();
        UserRepository userRepoSwed = new UserRepository();
        UserRepository userRepoNord = new UserRepository();

        // Create banks and users
        Bank swedbank = new Bank("Swedbank", userRepoSwed);
        User user1 = new User(123, "Dawid", "333");
        user1.addAccount(new Account("acc-001", 377));
        swedbank.addUser(user1);

        Bank nordea = new Bank("Nordea", userRepoNord);
        User user2 = new User(500, "Fredrik", "123");
        user2.addAccount(new Account("acc-002", 5000));
        user2.addAccount(new Account("acc-003", 6000));
        nordea.addUser(user2);

        List<Bank> banks = List.of(swedbank,  nordea);

        ATMSimulator atmsim = new ATMSimulator();
        atmsim.init(banks, scanner,atmService);

         */

    }
}
