package main.java.spil;

import java.util.List;

public class Account {
    //Variables for account
    private int balance = 0;
    private List<Field> ownedProperties;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account(int balance, List<Field> ownedProperties) {
        this.balance = balance;
        this.ownedProperties = ownedProperties;
    }

    //Lists the owned properties of a player (Will be used later)
    public List<Field> getOwnedProperties() {
        return ownedProperties;
    }

    public void setOwnedProperties(List<Field> ownedProperties) {
        this.ownedProperties = ownedProperties;
    }
}
