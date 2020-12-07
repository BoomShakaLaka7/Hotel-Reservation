package com.company.model;

import com.company.view.View3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class User implements Hotels{
    private String name;
    private String username;
    private String password;
    private int accountNumber;

    View3 view3;

    public User(View3 view3) {
        this.view3 = view3;
    }

    public void saveUser(View3 view3) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("UserDatabase.txt"));
        bw.write(view3.getSignUpName());
        bw.newLine();
        bw.write(view3.getSignUpUsername());
        bw.newLine();
        bw.write(view3.getSignUpPassword());
        bw.newLine();
        bw.close();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String getHotel() {
        return view3.getHotelName();
    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public int getPrice() {
        return view3.getHotelPrice();
    }

    @Override
    public int getStar() {
        return view3.getStar();
    }

    @Override
    public String getReview() {
        return null;
    }
}
