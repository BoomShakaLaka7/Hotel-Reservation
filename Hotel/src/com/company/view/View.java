package com.company.view;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    JFrame frame = new JFrame("Hotel Reservation System");
    static JButton search, filter;
    private JTextField city = new JTextField(10);
    private JTextField guests = new JTextField(10);
    private JTextField minPrice = new JTextField(10);
    private JTextField maxPrice = new JTextField(10);
    private JTextField reviews = new JTextField(10);

    public View(){
        JPanel panel = new JPanel();
        JLabel l1, l2, l3, l4, l5;

        search = new JButton("Search");
        filter = new JButton("Filter");

        l1 = new JLabel("City");
        l2 = new JLabel("Number of guests");
        l3 = new JLabel("Min Price");
        l4 = new JLabel("Max Price");

        frame.add(l1);
        frame.add(city);
        frame.add(l2);
        frame.add(guests);
        frame.add(l3);
        frame.add(minPrice);
        frame.add(l4);
        frame.add(maxPrice);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
