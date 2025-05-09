package se.fredaw.tdd.atmsim.Object.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.fredaw.tdd.atmsim.AccountRepository;
import se.fredaw.tdd.atmsim.Object.Account;
import se.fredaw.tdd.atmsim.auth.Authenticator;


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
        Account account = new Account("abc1234", "1234");
        testRepo.setAccount(account);
        assertTrue(authenticator.authenticate(account, "1234"));
    }


    @Test
    public void testAuthenticationFailsWithWrongPin() {
        Account account = new Account("abc1234", "4321");
        testRepo.setAccount(account);

        assertFalse(authenticator.authenticate(account, "12345"));
    }
}
