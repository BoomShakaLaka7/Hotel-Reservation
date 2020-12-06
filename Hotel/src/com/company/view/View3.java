package com.company.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * View3 class displays login/signup page
 */
public class View3 {

        private JFrame frame = new JFrame("Authentication");
        private JLabel headDescription, loginDescription, signUpDescription;
        private JTextField loginUsername = new JTextField("Username", 10);

        /**
         * gets user information to login to the account
         */
        private JTextField loginPassword = new JTextField("Password", 10);
        private JTextField signUpName = new JTextField("name", 10);
        private JTextField signUpUsername = new JTextField("Username", 10);
        private JTextField signUpPassword = new JTextField("Password", 10);
        private JTextField signUpPasswordConfirmation = new JTextField("Confirm password", 10);

        /**
         * Constructor for View3
         */
        public View3() {
                initialize();
                frame.setVisible(true);
        }

        /**
         * UI for View3
         */
        public void initialize() {
                JPanel panel = new JPanel();
                panel.setBounds(0, 0, 1000, 300);
                panel.setLayout(null);

                // Page Header
                headDescription = new JLabel("To complete the process, please login or create a new account.");
                headDescription.setBounds(300, 0, 400, 50);
                panel.add(headDescription);

                // Login Section
                loginDescription = new JLabel("Existing Users? Login to continue.");
                loginDescription.setBounds(105, 70, 250, 25);
                panel.add(loginDescription);

                loginUsername.setBounds(100, 100, 200, 25);
                panel.add(loginUsername);

                loginPassword.setBounds(100, 130, 200, 25);
                panel.add(loginPassword);

                JButton loginButton = new JButton("Login");
                loginButton.setBounds(100, 160, 100, 25);
                loginButton.addActionListener(new ActionListener() {

                                                      @Override
                                                      public void actionPerformed(ActionEvent e) {

                                                              // TODO Auto-generated method stub

                                                              View4 view4 = new View4();
                                                              frame.setVisible(false);
                                                      }


                                              }

                );

                panel.add(loginButton);

                // Sign-up Section
                signUpDescription = new JLabel("New User? Create an account to continue.");
                signUpDescription.setBounds(505, 70, 450, 25);
                panel.add(signUpDescription);

                signUpName.setBounds(500, 100, 175, 25);

                panel.add(signUpName);

                signUpUsername.setBounds(500, 130, 175, 25);
                panel.add(signUpUsername);

                signUpPassword.setBounds(700, 100, 175, 25);
                panel.add(signUpPassword);

                signUpPasswordConfirmation.setBounds(700, 130, 175, 25);

                panel.add(signUpPasswordConfirmation);

                JButton signUpButton = new JButton("Sign-Up");
                signUpButton.setBounds(500, 160, 100, 25);
                signUpButton.addActionListener(e1 -> {
                        if ((getSignUpPasswordConfirmation().equalsIgnoreCase((getSignUpPassword())))) {
                                try {
                                        BufferedWriter bw = new BufferedWriter(new FileWriter("UserDatabase.txt"));
                                        bw.write(getSignUpName());
                                        bw.newLine();
                                        bw.write(getSignUpUsername());
                                        bw.newLine();
                                        bw.write(getSignUpPassword());
                                        bw.newLine();
                                        bw.close();
                                        View3 view3 = new View3();
                                } catch (Exception ex) {
                                        ex.printStackTrace();
                                }

                        } else {
                                JOptionPane.showMessageDialog(frame, "Passwords do not match!");
                                // }
                        }


                });
                panel.add(signUpButton);

                frame.getContentPane().add(panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(100, 100, 1000, 300);
                frame.getContentPane().setLayout(null);
        }

        /**
         * getter for login username
         * @return String
         */
        public String getLoginUsername() {
                return loginUsername.getText();
        }

        /**
         * getter for login password
         * @return String
         */
        public String getLoginPassword() {
                return loginPassword.getText();
        }

        /**
         * getter for signed up name
         * @return String
         */
        public String getSignUpName() {
                return signUpName.getText();
        }

        /**
         * getter for signed up username
         * @return String
         */
        public String getSignUpUsername() {
                return signUpUsername.getText();
        }

        /**
         * getter for signed up password
         * @return String
         */
        public String getSignUpPassword() {
                return signUpPassword.getText();
        }

        /**
         * getter for password confirmation
         * @return String
         */
        public String getSignUpPasswordConfirmation() {
                return signUpPasswordConfirmation.getText();
        }

        /**
         * setter for login username
         * @param username
         */
        public void setLoginUsername(String username) {
                loginUsername.setText(username);
        }

        /**
         * setter for login password
         * @param password
         */
        public void setLoginPassword(String password) {
                loginPassword.setText(password);
        }

        /**
         * setter for signed up name
         * @param name
         */
        public void setSignUpName(String name) {
                signUpName.setText(name);
        }

        /**
         * setter for password confirmation
         * @param password
         */
        public void setSignUpPasswordConfirmation(String password) {
                signUpPasswordConfirmation.setText(password);
        }

        private void setAction() {

                //loginButton.addActionListener(this);
                //signUpButton.addActionListener(this);


                //  if (e.getSource() == UserDatabase.txt) {

                //check if username is exist
                //if ((getLoginUsername()) == null) {
                //     JOptionPane.showMessageDialog(frame, "this username does not exist");
                //}
                //else{ //check if the right password
                //  if(UserDatabase.getUser_map().get(getLoginUsername()).doesPasswordEqual(getLoginPassword())){
                // JOptionPane.showMessageDialog(frame,"login successfully");

                // else{ // notify wrong password
                //  JOptionPane.showMessageDialog(frame,"wrong password, please try again");
                //  }
                // }
                //  }

                //if(e.getSource() == signUpButton){

                //check if username already exist


                //else{// if then check if password and confirmation is the same
                // if(signUpPassword.equals(signUpPasswordConfirmation)){
                //User newUser = User(signUpName,signUpUsername,signUpPassword);
                //UserDatabase.getUser_map().put(newUser.getUserName(),newUser);
                //}

                // else{
                //JOptionPane.showMessageDialog(frame,"passwords does not match, try again");
                // }

                // }

                // }

                //  }

                //  }
        }

}






