package com.company.model;

import com.company.view.View3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * User class
 */
public class User implements Hotels{
    private String name;
    private String username;
    private String password;
    private int accountNumber;

    View3 view3;

    /**
     * constructor for User
     * @param view3
     */
    public User(View3 view3) {
        this.view3 = view3;
    }

    /**
     * writes user information in "UserDatabase.txt"
     * @throws IOException
     */
    public void saveUser() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("UserDatabase.txt"));
        bw.write(view3.getSignUpName());
        bw.newLine();
        bw.write(view3.getSignUpUsername());
        bw.newLine();
        bw.write(view3.getSignUpPassword());
        bw.newLine();
        bw.close();
    }


    /**
     * setter for user name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter for user's username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * setter for user's account number
     * @param accountNumber
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String getHotel() { return null; }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public int getPrice() { return 0; }

    @Override
    public int getStar() {
        return 0;
    }

    @Override
    public String getReview() {
        return null;
    }
}
