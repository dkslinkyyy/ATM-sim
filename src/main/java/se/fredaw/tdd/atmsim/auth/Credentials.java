package se.fredaw.tdd.atmsim.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {
    private int ID;
    private String pincode;



    public Credentials(
            @JsonProperty ("id") int ID,
            @JsonProperty ("pincode") String pincode) {
        this.pincode = pincode;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getPincode() {
        return pincode;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "ID=" + ID +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
