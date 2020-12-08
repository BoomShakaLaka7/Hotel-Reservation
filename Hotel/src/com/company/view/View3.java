package com.company.view;

import com.company.model.Model;
import com.company.model.User;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * View3 class displays login/signup page
 */
public class View3 {

        private JFrame frame = new JFrame("Authentication");
        private JLabel headDescription, loginDescription, signUpDescription;
        private JTextField loginUsername = new JTextField("Username", 10);
//        private int hotelIndex;
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

        /**
         * Constructor for View3
         */
//        public View3(String hotelIndex, List<Hotel> hotelsList) {
//                initialize();
//                frame.setVisible(true);
//                this.hotelIndex = Integer.parseInt(hotelIndex);
//                this.hotelArrayList = hotelsList;
//        }

        public View3() {
                //super(model, view);
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
                loginPassword.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                loginPassword.setText(null);
                        }
                });
                loginPassword.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent focusEvent) {
                                loginPassword.setText(null);
                        }

                        @Override
                        public void focusLost(FocusEvent focusEvent) {
                                // do nothing
                        }
                });
                panel.add(loginPassword);

                loginButton.setBounds(100, 160, 100, 25);
                loginButton.addActionListener(e1 -> {
                        String pwd = "";
                        try {
                                BufferedReader br = Files.newBufferedReader(Paths.get("UserDatabase.txt"));

                                String line;
                                line = br.readLine();
                                line = br.readLine();
                                line = br.readLine();
                                pwd = line;
                                System.out.println("PWD Passed: "+line);

                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                        if ((getLoginPassword().equals((pwd)))) {
                                try {
                                        View4 view4 = new View4(View2.getHotelName(), View2.getHotelPrice());
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
                signUpName.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                signUpName.setText(null);
                        }
                });
                signUpName.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent focusEvent) {
                                signUpName.setText(null);
                        }

                        @Override
                        public void focusLost(FocusEvent focusEvent) {
                                // do nothing
                        }
                });
                panel.add(signUpName);


                signUpUsername.setBounds(500, 130, 175, 25);
                signUpUsername.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                signUpUsername.setText(null);
                        }
                });
                signUpUsername.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent focusEvent) {
                                signUpUsername.setText(null);
                        }

                        @Override
                        public void focusLost(FocusEvent focusEvent) {
                                // do nothing
                        }
                });
                panel.add(signUpUsername);


                signUpPassword.setBounds(700, 100, 175, 25);
                signUpPassword.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                signUpPassword.setText(null);
                        }
                });
                signUpPassword.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent focusEvent) {
                                signUpPassword.setText(null);
                        }

                        @Override
                        public void focusLost(FocusEvent focusEvent) {
                                // do nothing
                        }
                });
                panel.add(signUpPassword);

                signUpPasswordConfirmation.setBounds(700, 130, 175, 25);
                signUpPasswordConfirmation.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                signUpPasswordConfirmation.setText(null);
                        }
                });
                signUpPasswordConfirmation.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent focusEvent) {
                                signUpPasswordConfirmation.setText(null);
                        }

                        @Override
                        public void focusLost(FocusEvent focusEvent) {
                                // do nothing
                        }
                });
                panel.add(signUpPasswordConfirmation);

                signUpButton.setBounds(500, 160, 100, 25);
                signUpButton.addActionListener(e1 -> {
                        if ((getSignUpPasswordConfirmation().equalsIgnoreCase((getSignUpPassword())))) {
                                try {
                                        user.saveUser();

                                        View3 view3 = new View3 ();
                                        
                                        frame.setVisible(false);
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

        /**
         * listens for login button to be pressed
         * @param loginButtonL
         */
        public void loginButtonListener(ActionListener loginButtonL){
                loginButton.addActionListener(loginButtonL);
        }

}






