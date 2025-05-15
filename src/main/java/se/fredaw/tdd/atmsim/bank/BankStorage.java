package se.fredaw.tdd.atmsim.bank;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BankStorage {
    public static void bankInformationCollection(Bank bank, String fileName) throws IOException {
        try(OutputStream bankOut = new FileOutputStream("bankOutput.json")) {


        }
        catch (IOException e){
            System.out.println("Fel vid skrivning till fil: " + e.getMessage());

        }


    }
}
