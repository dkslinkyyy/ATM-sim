package se.fredaw.tdd.atmsim.Object;

public class Bank {
    private final String name;
    private final Account account;

    //Skapar en bank med ett konto kopplat


    public Bank(String name, String pin, int startingBalance) {
        this.name = name;
        this.account = new Account(startingBalance);

    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }


}
