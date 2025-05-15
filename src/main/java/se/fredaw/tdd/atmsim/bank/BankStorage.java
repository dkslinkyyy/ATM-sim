package se.fredaw.tdd.atmsim.bank;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;

public class BankStorage {

    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public static void saveBank(List<Bank> bank) {
        //Skriv vart detta ska sparas
        String filepath = "C:/Users/Fredrik/Documents/bank.json";

        try{
            mapper.writeValue(new File(filepath), bank);
        }
        catch (IOException e) {
            System.out.println("Could not create file" + filepath);
            throw new RuntimeException(e);
        }
    }

    public static Bank loadBank() {
        String filepath = "C:/Users/Fredrik/Documents/bank.json";

        try{
            return mapper.readValue(new File(filepath), Bank.class);

        }
        catch (IOException e) {
            System.out.println("Could not read file" + filepath);
            throw new RuntimeException(e);
        }
    }
}
