package com.company.controller;

import com.company.model.Hotel;
import com.company.model.Model;
import com.company.model.User;
import com.company.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private View view;
    private User user;
    private Model model;
//    public List<Hotel> hotelList = new ArrayList<>();

//    private SearchResults searchResults;

    public Controller(View view, User user, Model model) {
        this.view = view;
        this.user = user;
//        this.searchResults = searchResults;
        this.model = model;

        this.view.searchButtonListener(new searchButtonClick());
//        this.view.filterButtonListener(new filterButtonClick());
    }

    class searchButtonClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            try {
//                System.out.println(model.getHotels().size());
//                System.out.println(model.getHotels().get(0).getLocation());
//                System.out.println(model.getHotels().get(1));
//                System.out.println(model.getHotels().get(2));
//                System.out.println(model.getHotels().get(3));
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }

            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            JTextArea results = new JTextArea(20, 6);
            frame.setVisible(true);
            frame.setSize(550, 500);
            frame.setTitle("Search Results");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            List<Hotel> hotelList = new ArrayList<>();
            int hotelsFound = 0;

//            results.setBounds(10, 10, 400, 350);
            results.setEditable(false);

            results.setText("");
            String city = view.getCity();

            if(view.filtered){
                Double review = Double.parseDouble(view.getReview());
                int star = view.getStar();
                int maxPrice = view.getMaxPrice();
                int minPrice = view.getMinPrice();

                try {
                    for (int i = 0; i < 25; ++i) {
                        if (model.getHotels().get(i).getLocation().equals(city)
                        && model.getHotels().get(i).getStar() == star && Double.parseDouble(model.getHotels().get(i).getReview()) >= review
                                && model.getHotels().get(i).getPrice() <= maxPrice && model.getHotels().get(i).getPrice() >= minPrice
                        ) {
                            hotelList.add(model.getHotels().get(i));
//                        hotelList[i] = model.getHotels().get(i);
                            hotelsFound += 1;
//                        results.append(hotelList[i].toString() + "\n");
//                        results.append(i + " " + hotelList.get(i).getLocation() + "\n");

                        }
                    }
                    results.append("    Hotel Name   \t" + "Location    \t" + "Price   \t" + "Star   \t" + "Reviews" + "\n\n");
                    for (int i = 0; i < hotelsFound; i++) {
                        results.append(i+1 + ": " +  hotelList.get(i).getHotel() + "\t" + hotelList.get(i).getLocation() + "\t"
                                + hotelList.get(i).getPrice() + "\t" + hotelList.get(i).getStar() + "\t" + hotelList.get(i).getReview() + "\n");
//                    results.append(hotelList[i].toString());
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

//            Object[] hotelList = new Object[40];
            else {
                try {
                    for (int i = 0; i < 25; ++i) {
                        if (model.getHotels().get(i).getLocation().equals(city)) {
                            hotelList.add(model.getHotels().get(i));
//                        hotelList[i] = model.getHotels().get(i);
                            hotelsFound += 1;
//                        results.append(hotelList[i].toString() + "\n");
//                        results.append(i + " " + hotelList.get(i).getLocation() + "\n");

                        }
                    }
                    results.append("    Hotel Name   \t" + "Location    \t" + "Price   \t" + "Star   \t" + "Reviews" + "\n\n");
                    for (int i = 0; i < hotelsFound; i++) {
                        results.append(i + 1 + ": " + hotelList.get(i).getHotel() + "\t" + hotelList.get(i).getLocation() + "\t"
                                + hotelList.get(i).getPrice() + "\t" + hotelList.get(i).getStar() + "\t" + hotelList.get(i).getReview() + "\n");
//                    results.append(hotelList[i].toString());
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            panel.add(results);
            frame.add(panel);
//            panel.setLayout(null);

        }
    }

//    class filterButtonClick implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//        }
//    }
}
