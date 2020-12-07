package com.company.view;

import com.company.model.Hotel;
import com.company.model.Model;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * View2 displays sorted hotel list
 */
public class View2 {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    Date checkIn;
    Date checkOut;
    int guests;
    int star;

    JTextArea results = new JTextArea(20, 6);
    public List<Hotel> hotelList = new ArrayList<>();
    int hotelsFound = 0;
    JButton reserveButton = new JButton("Reserve");

    JTextField enteredValue = new JTextField("Enter Selected Hotel ID");

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * Constructor for View2
     * @param model
     * @param view
     */
    public View2(Model model, View view) {

        frame.setVisible(true);
        frame.setSize(550, 500);
        frame.setTitle("Search Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        results.setEditable(false);
        results.setText("");

        String city = view.getCity();
        checkIn = view.getCheckIn();
        checkOut = view.getCheckOut();
        guests = view.getGuests();
        Date today = new Date();

        if(view.filtered){
            Double review = Double.parseDouble(view.getReview());
            star = view.getStar();
            int maxPrice = view.getMaxPrice();
            int minPrice = view.getMinPrice();

            try {
                for (int i = 0; i < 25; ++i) {
                    if (model.getHotels().get(i).getLocation().equals(city) && checkIn.before(checkOut) && checkIn.after(today)
                            && model.getHotels().get(i).getStar() == star && Double.parseDouble(model.getHotels().get(i).getReview()) >= review
                            && model.getHotels().get(i).getPrice() <= maxPrice && model.getHotels().get(i).getPrice() >= minPrice
                    ) {
                        hotelList.add(model.getHotels().get(i));
                        hotelsFound += 1;
                    }
                }
                results.append("    Hotel Name   \t" + "Location    \t" + "Price   \t" + "Star   \t" + "Reviews" + "\n\n");
                for (int i = 0; i < hotelsFound; i++) {
                    results.append(i+1 + ": " +  hotelList.get(i).getHotel() + "\t" + hotelList.get(i).getLocation() + "\t"
                            + hotelList.get(i).getPrice() + "\t" + hotelList.get(i).getStar() + "\t" + hotelList.get(i).getReview() + "\n");
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        else {
            try {
                for (int i = 0; i < 25; ++i) {
                    if (model.getHotels().get(i).getLocation().equals(city) && checkIn.before(checkOut)
                            && checkIn.after(today)) {
                        hotelList.add(model.getHotels().get(i));
                        hotelsFound += 1;
                    }
                }
                results.append("    Hotel Name   \t" + "Location    \t" + "Price   \t" + "Star   \t" + "Reviews" + "\n\n");
                for (int i = 0; i < hotelsFound; i++) {
                    results.append(i + ": " + hotelList.get(i).getHotel() + "\t" + hotelList.get(i).getLocation() + "\t"
                            + hotelList.get(i).getPrice() + "\t" + hotelList.get(i).getStar() + "\t" + hotelList.get(i).getReview() + "\n");
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


        panel.add(results);
        panel.add(enteredValue);
        panel.add(reserveButton);
        frame.add(panel);

    }

    public void reserveButtonListener(ActionListener reserveButtonL){
        reserveButton.addActionListener(reserveButtonL);
    }

    public int getHotelsFound(){return hotelsFound;}

    public String getEnteredValue(){return enteredValue.getText();}

    public String getHotelName(){
        int ind = Integer.parseInt(getEnteredValue());
        return hotelList.get(ind).getHotel();
    }

    public int getHotelPrice(){
        int ind = Integer.parseInt(getEnteredValue());
        int diff = (int) (checkOut.getTime() - checkIn.getTime())/ (1000 * 60 * 60 * 24);
        return hotelList.get(ind).getPrice() * diff * guests;
    }

    public int getStar() { return star; }

}
