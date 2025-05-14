package se.fredaw.tdd.atmsim.auth;

public class Credentials {
    private int ID;
    private String pincode;

    public Credentials(int ID, String pincode) {
        this.pincode = pincode;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getPincode() {
        return pincode;
    }
}
