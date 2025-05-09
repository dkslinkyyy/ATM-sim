package se.fredaw.tdd.atmsim.auth;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.bank.Account;
import se.fredaw.tdd.atmsim.bank.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;

public class AuthentatorTestAccountNotFound {


    class TestAccountRepository implements AccountRepository {
        private Account storedAccount;

        public void setAccount(Account account) {
            this.storedAccount = account;
        }

        @Override
        public Account findById(String accountId) {
            if (storedAccount != null && storedAccount.getAccountId().equals(accountId)) {
                return storedAccount;
            }
            return null;
        }

        @Override
        public boolean doesAccountExist(String accountId){

            return storedAccount != null && storedAccount.getAccountId().equals(accountId);
        }
    }

    private TestAccountRepository testRepo;
    private Authenticator authenticator;

    @BeforeEach
    void setup() {
        testRepo = new TestAccountRepository();

        authenticator = new Authenticator(testRepo);
        testRepo.setAccount(new Account("testperson", "1234", 1000 ));
    }



    @Test void testAuthenticationWillSuccessWithTheAccountFound(){
        Account account = new Account("testperson", "4321", 1000);
        assertTrue(testRepo.doesAccountExist(account.getAccountId()));

    }

    @Test void testAuthenticationFailsWithAccountNotFound(){
        Account account = new Account("doesntExist", "4321", 1000);
        assertFalse(testRepo.doesAccountExist(account.getAccountId()));

    }


}
