package se.fredaw.tdd.atmsim.auth;

import se.fredaw.tdd.atmsim.bank.User;
import se.fredaw.tdd.atmsim.repository.UserRepository;


public class Authenticator {
    private final UserRepository repository;

    public Authenticator(UserRepository accountRepository) {
        this.repository = accountRepository ;
    }
    public boolean authenticate(User user, String inputPin) {
        User foundUser = repository.findById(user.getUserId());
        //return foundAccount != null && foundUser.checkPin(inputPin);
        //temporary fix
        return false;
    }
}
