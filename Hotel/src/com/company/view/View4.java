package com.company.view;

import javax.swing.*;

public class View4 {

    private JFrame frame = new JFrame("Confirmation");
    private JTextArea name, accountNumber, reservation;

    public View4(){
        initialize();
        frame.setVisible(true);
    }

    public void initialize(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1000, 300);
        panel.setLayout(null);

        // Left section : Name , Account Number, Reservation
        name = new JTextArea("Name");
        name.setBounds(150, 50, 200, 20);
        name.setEditable(false);
        panel.add(name);

        accountNumber = new JTextArea("Account Number");
        setAccountNumber();
        accountNumber.setBounds(150, 100, 200, 20);
        accountNumber.setEditable(false);
        panel.add(accountNumber);

        reservation = new JTextArea("Reservation");
        reservation.setBounds(150, 150, 200, 20);
        reservation.setEditable(false);
        panel.add(reservation);


        // Right Section : Reserve & Cancel Buttons
        JButton reserveButton = new JButton("Reserve");
        reserveButton.setBounds(600, 50, 200, 25);
        panel.add(reserveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(600, 100,200, 25);
        panel.add(cancelButton);

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1000, 300);
        frame.getContentPane().setLayout(null);
    }

    public void setName(String username){ name.setText(username); }

    // Generates random int value from 1000000 - 9999999
    public void setAccountNumber(){
        int random_int = (int)(Math.random() * (9999999 - 1000000 + 1) + 1000000);
        accountNumber.setText(Integer.toString(random_int));
    }

    public void setReservation(){}
}
