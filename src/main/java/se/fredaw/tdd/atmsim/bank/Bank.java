package se.fredaw.tdd.atmsim.bank;

import se.fredaw.tdd.atmsim.repository.UserRepository;

public class Bank {
    private final String name;
    private final UserRepository userRepository;

    public Bank(String name, UserRepository userRepository) {
        this.name = name;
        this.userRepository = userRepository;
    }

    public String getName() {
        return name;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId);
    }
}
