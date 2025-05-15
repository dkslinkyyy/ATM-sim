package se.fredaw.tdd.atmsim.bank;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;



public class BankStorageTest {
    //@Test
    //void bankInformationFileShouldExist(){
        //assertTrue(new File("bankOutput.json").exists());

    //}

    @Test
    void simpleFileShouldExist(){
        assertTrue(new File("C:/Users/Fredrik/Documents/bank.json").exists());

    }
}
