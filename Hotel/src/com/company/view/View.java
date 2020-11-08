package com.company.view;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Properties;

public class View {

    JFrame frame = new JFrame("Hotel Reservation System");
    static JButton search, filter;
    private JTextField city = new JTextField(10);
    private JTextField guests = new JTextField(10);
    private JTextField minPrice = new JTextField(10);
    private JTextField maxPrice = new JTextField(10);
    private JTextField reviews = new JTextField(10);

    public View(){
        JPanel panel = new JPanel();
        JPanel filterPanel = new JPanel();
        JLabel l1, l2, l3, l4, l5, l6;
//        CalendarDemo calendarDemo = new CalendarDemo("Calendar");
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

        JDatePanelImpl datePanel2 = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateComponentFormatter());

        search = new JButton("Search");
        filter = new JButton("Filter");

        l1 = new JLabel("City");
        l2 = new JLabel("Number of guests");
        l3 = new JLabel("Min Price");
        l4 = new JLabel("Max Price");
        l5 = new JLabel("Check in");
        l6 = new JLabel("Check out");

        panel.add(l1);
        panel.add(city);
        panel.add(l2);
        panel.add(guests);
        panel.add(l5);
        panel.add(datePicker);
        panel.add(l6);
        panel.add(datePicker2);
        panel.add(search);
        panel.setLayout(new FlowLayout());

        filterPanel.add(l3);
        filterPanel.add(minPrice);
        filterPanel.add(l4);
        filterPanel.add(maxPrice);
//        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(700, 500);

    }
}
