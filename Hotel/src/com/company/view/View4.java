package com.company.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * View4 displays account information
 */
public class View4 {

    private JFrame frame = new JFrame("Confirmation");
    private JTextArea name, accountNumber, hotel;
    private JLabel nameLabel, accountNumberLabel, hotelLabel;

    String hotelName;
    int price;

    /**
     * View4 constructor
     */
    public View4(String hotelName, int price){
//        initialize();
        frame.setVisible(true);
        this.hotelName = hotelName;

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1000, 300);
        panel.setLayout(null);

        // Left section : Name , Account Number, Reservation
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds( 100, 50, 100, 20);
        panel.add(nameLabel);

        name = new JTextArea(" ");
        name.setBounds(150, 50, 200, 20);

        try {
            BufferedReader br = Files.newBufferedReader(Paths.get("UserDatabase.txt"));

            String line;
            line = br.readLine();
            String[] strings = new String[3];
            strings = line.split("\\r?\\n");
            String signUpName = strings [0];


            name.append(signUpName);
            br.close();

            System.out.println(name);

        } catch (IOException e) {
            e.printStackTrace();
        }

        name.setEditable(false);
        panel.add(name);

        accountNumberLabel = new JLabel("Account Number:");
        accountNumberLabel.setBounds( 30, 100, 150, 20);
        panel.add(accountNumberLabel);

        accountNumber = new JTextArea("Account Number");
        setAccountNumber();
        accountNumber.setBounds(150, 100, 200, 20);
        accountNumber.setEditable(false);
        panel.add(accountNumber);

        hotelLabel = new JLabel("Selected Hotel:");
        hotelLabel.setBounds( 45, 150, 150, 20);
        panel.add(hotelLabel);

        hotel = new JTextArea(" ");
        hotel.setBounds(150, 150, 200, 20);
        hotel.setEditable(false);

        hotel.append(hotelName);
        panel.add(hotel);

        // Right Section : Reserve & Cancel Buttons
        JButton reserveButton = new JButton("Reserve");
        reserveButton.setBounds(600, 50, 200, 25);
        reserveButton.addActionListener(new ActionListener() {

                                            @Override
                                            public void actionPerformed(ActionEvent e) {

                                                // TODO Auto-generated method stub
                                                JOptionPane.showMessageDialog(frame, "Reservation is Confirmed!\n"
                                                        + "Total amount: " + price + "$");

                                                View view = new View();
                                                frame.setVisible(false);
                                            }
                                        }
        );
        panel.add(reserveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(600, 100,200, 25);
        panel.add(cancelButton);

        /**
         * Action Listener for cancel button
         */
        cancelButton.addActionListener(new ActionListener() {

                                           @Override
                                           public void actionPerformed(ActionEvent e) {

                                               // TODO Auto-generated method stub

                                               View view = new View();
                                               frame.setVisible(false);
                                           }
                                       }
        );

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1000, 300);
        frame.getContentPane().setLayout(null);
    }

    /**
     * setter for the name
     */
   public void setName(){

   }
    // Generates random int value from 1000000 - 9999999
    /**
     * generates random number for account number
     */
    public void setAccountNumber(){
        int random_int = (int)(Math.random() * (9999999 - 1000000 + 1) + 1000000);
        accountNumber.setText(Integer.toString(random_int));
    }

}
