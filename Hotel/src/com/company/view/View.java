package com.company.view;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * View class represents the main page
 */
public class View {

    private JFrame frame = new JFrame("Hotel Reservation System");
    static JButton search, filter;
    private JTextField city = new JTextField(10);
    private JTextField guests = new JTextField(10);
    private JTextField minPrice = new JTextField(10);
    private JTextField maxPrice = new JTextField(10);
    private JTextField hotelName = new JTextField(10);
    private JComboBox<String> reviews = new JComboBox<>();
    private JComboBox<Integer> star = new JComboBox<>();
    public boolean filtered = false;
    private JDatePickerImpl datePicker;
    private JDatePickerImpl datePicker2;

    /**
     * Constructor for View
     */
    public View() {
        initialize();
        frame.setVisible(true);
    }

    /**
     * GUI of the Main page
     */
    public void initialize(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1000, 300);
        panel.setLayout(null);
        JLabel l1, l2, l4, l5, l6, l7, l8;
        UtilDateModel model = new UtilDateModel();
        UtilDateModel model2 = new UtilDateModel();

        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
        datePicker2 = new JDatePickerImpl(datePanel2, new DateComponentFormatter());

        search = new JButton("Search");
        filter = new JButton("Filter");

        l1 = new JLabel("City");
        l1.setBounds(10, 0, 50, 50);
        l2 = new JLabel("Number of guests");
        l2.setBounds(150, 0, 150, 50);
        JLabel l3 = new JLabel("Min Price");
        l3.setBounds(400,35,100,50);
        l4 = new JLabel("Max Price");
        l4.setBounds(570, 35, 100, 50);
        l5 = new JLabel("Check in");
        l5.setBounds(380, 0, 70, 50);
        l6 = new JLabel("Check out");
        l6.setBounds(620, 0, 70, 50);
        l7 = new JLabel("Reviews");
        l7.setBounds(740, 35, 70,50);
        l8 = new JLabel("Star");
        l8.setBounds(310, 35, 70, 50);

        panel.add(l1);
        city.setBounds(40, 15, 100, 20);
        panel.add(city);
        panel.add(l2);
        guests.setBounds(270, 15, 100, 20);
        panel.add(guests);
        panel.add(l5);
        datePicker.setBounds(440, 15, 170, 20);
        panel.add(datePicker);
        panel.add(l6);
        datePicker2.setBounds(700, 15, 170, 20);
        panel.add(datePicker2);
        search.setBounds(880, 15, 100, 20);
        panel.add(search);

        filter.setBounds(880, 50, 100, 20);
        panel.add(filter);
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);

        filter.addActionListener(event -> {
            panel.add(l3);
            minPrice.setBounds(460, 50, 100, 20);
            panel.add(minPrice);
            panel.add(l4);
            maxPrice.setBounds(630, 50, 100, 20);
            panel.add(maxPrice);
            panel.add(l7);
            panel.add(reviews);
            panel.add(l8);
            panel.add(star);

            reviews.addItem("2");
            reviews.addItem("2.5");
            reviews.addItem("3");
            reviews.addItem("3.5");
            reviews.addItem("4");
            reviews.addItem("4.5");
            reviews.setEditable(true);
            reviews.setBounds(790, 50, 50, 20);

            star.addItem(2);
            star.addItem(3);
            star.addItem(4);
            star.addItem(5);
            star.setEditable(true);
            star.setBounds(340, 50, 50, 20);

            filtered = true;

            frame.repaint();
        });

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1000, 300);
        frame.getContentPane().setLayout(null);
    }

    /**
     * getter for city entered by the user
     * @return
     */
    public String getCity() {
        return city.getText();
    }

    /**
     * getter for number of guests entered by the user
     * @return
     */
    public int getGuests() {
        return Integer.parseInt(guests.getText());
    }

    /**
     * getter for min price entered by the user
     * @return
     */
    public int getMinPrice() {
        return Integer.parseInt(minPrice.getText());
    }

    /**
     * getter for max price entered by the user
     * @return
     */
    public int getMaxPrice() {
        return Integer.parseInt(maxPrice.getText());
    }

    /**
     * getter for check in date entered by the user
     * @return
     */
    public Date getCheckIn(){
        return (Date) datePicker.getModel().getValue();
    }

    /**
     * getter for check out date entered by the user
     * @return
     */
    public Date getCheckOut(){
        return (Date) datePicker2.getModel().getValue();
    }

    /**
     * getter for hotel review entered by the user
     * @return
     */
    public String getReview(){
        return reviews.getSelectedItem().toString();
    }

    /**
     * getter for hotel star entered by the user
     * @return
     */
    public int getStar() { return (int) star.getSelectedItem(); }

    /**
     * getter for hotel name entered by the user
     * @return
     */
    public String getHotelName() {
        return hotelName.getText();
    }

    /**
     * Listens for search button
     * @param searchButton
     */
    public void searchButtonListener(ActionListener searchButton){
        search.addActionListener(searchButton);
    }

    /**
     * setter for city
     * @param Pcity
     */
    public void setCity(String Pcity) {
        city.setText(Pcity);
    }

    /**
     * setter for number of guests
     * @param Pguests
     */
    public void setGuests(int Pguests) {
        guests.setText(Integer.toString(Pguests));
    }

    /**
     * setter for min price
     * @param PminPrice
     */
    public void setMinPrice(int PminPrice) {
        minPrice.setText(Integer.toString(PminPrice));
    }

    /**
     * setter for max price
     * @param PmaxPrice
     */
    public void setMaxPrice(int PmaxPrice) {
        maxPrice.setText(Integer.toString(PmaxPrice));
    }

    /**
     * setter for reviews
     * @param Previews
     */
    public void setReviews(String Previews) {
        reviews.setSelectedIndex(Integer.parseInt(Previews));
    }

    /**
     * setter for star
     * @param Pstar
     */
    public void setStar(int Pstar) {
        star.setSelectedIndex(Pstar);
    }

    /**
     * setter for hotel name
     * @param Pname
     */
    public void setHotelName(String Pname){
        hotelName.setText(Pname);
    }
}
