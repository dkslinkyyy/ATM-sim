package se.fredaw.tdd.atmsim.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.bank.Account;
import se.fredaw.tdd.atmsim.bank.AccountRepository;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticatorTest {


    //bara en test klass som BARA sköter ett konto i taget för testens skull
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
        public boolean doesAccountExist(String accountId) {
            return false;
        }
    }
    private TestAccountRepository testRepo;
    private Authenticator authenticator;
    @BeforeEach
    void setup() {
        testRepo = new TestAccountRepository();

        authenticator = new Authenticator(testRepo);
    }

    @Test
    void testAuthenticationSuccess() {
        Account account = new Account("abc1234", "1234", 1000);
        testRepo.setAccount(account);
        assertTrue(authenticator.authenticate(account, "1234"));
    }


    @Test
    public void testAuthenticationFailsWithWrongPin() {
        Account account = new Account("abc1234", "4321", 1000);
        testRepo.setAccount(account);

        assertFalse(authenticator.authenticate(account, "12345"));
    }
}
