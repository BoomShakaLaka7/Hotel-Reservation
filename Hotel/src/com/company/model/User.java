package com.company.model;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String username;
    private String password;
    private int reservationNumber;

    private int accountNumber;

    public User(String name, String username, String password, int reservationNumber, int accountNumber) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.reservationNumber = reservationNumber;
        this.accountNumber = accountNumber;
    }

    public User(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getReservationNumber() { return reservationNumber; }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getAccountNumber() { return accountNumber; }



    public boolean doesPasswordEqual(String password){
        return this.password.equals(password);
    }


}
