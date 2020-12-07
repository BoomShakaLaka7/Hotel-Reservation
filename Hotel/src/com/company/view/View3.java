package com.company.view;

import com.company.model.Hotel;
import com.company.model.Model;
import com.company.model.User;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * View3 class displays login/signup page
 */
public class View3 extends View2{

        private JFrame frame = new JFrame("Authentication");
        private JLabel headDescription, loginDescription, signUpDescription;
        private JTextField loginUsername = new JTextField("Username", 10);
        public User user = new User(this);
        JButton loginButton = new JButton("Login");
        JButton signUpButton = new JButton("Sign-Up");
        Model model;
        View view;

        /**
         * gets user information to login to the account
         */
        private JTextField loginPassword = new JTextField("Password", 10);
        private JTextField signUpName = new JTextField("name", 10);
        private JTextField signUpUsername = new JTextField("Username", 10);
        private JTextField signUpPassword = new JTextField("Password", 10);
        private JTextField signUpPasswordConfirmation = new JTextField("Confirm password", 10);


        public View3(Model model, View view) {
                super(model, view);
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

                loginButton.setBounds(100, 160, 100, 25);
                loginButton.addActionListener(e1 -> {
                        if ((getLoginPassword().equals((getSignUpPassword())))) {
                                try {
                                        View4 view4 = new View4(getHotelName(),getHotelPrice());
                                } catch (Exception ex) {
                                        ex.printStackTrace();
                                }

                        } else {
                                JOptionPane.showMessageDialog(frame, "Passwords do not match!");
                        }

                });
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

                signUpButton.setBounds(500, 160, 100, 25);
                signUpButton.addActionListener(e1 -> {
                        if ((getSignUpPasswordConfirmation().equalsIgnoreCase((getSignUpPassword())))) {
                                try {
                                        user.saveUser(new View3(model, view));
                                        View3 view3 = new View3(model, view);
                                } catch (Exception ex) {
                                        ex.printStackTrace();
                                }

                        } else {
                                JOptionPane.showMessageDialog(frame, "Passwords do not match!");
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

        public void loginButtonListener(ActionListener loginButtonL){
                loginButton.addActionListener(loginButtonL);
        }

}






