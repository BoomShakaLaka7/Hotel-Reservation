package com.company.view;

import com.company.model.Hotel;
import com.company.model.Model;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class View2 {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    //    Model model;
//    View view = new View();
    JTextArea results = new JTextArea(20, 6);
    List<Hotel> hotelList = new ArrayList<>();
    int hotelsFound = 0;
    JButton reserveButton = new JButton("Reserve");
    //JTextArea selectedFieldName = new JTextArea();

    JTextField enteredValue = new JTextField("Enter Selected Hotel ID");

    public View2(Model model, View view) {
        //            results.setBounds(10, 10, 400, 350);
//        this.model = model;
        frame.setVisible(true);
        frame.setSize(550, 500);
        frame.setTitle("Search Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        results.setEditable(false);
        results.setText("");

        reserveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO Auto-generated method stub
                for(int i = 0; i<hotelsFound; i++) {
                    if(Integer.parseInt(enteredValue.getText()) == i) {
                        View3 view3 = new View3();
                    frame.setVisible(false);
                    }
                }
            }


        }

        );

        String city = view.getCity();
        Date checkIn = view.getCheckIn();
        Date checkOut = view.getCheckOut();

        if(view.filtered){
            Double review = Double.parseDouble(view.getReview());
            int star = view.getStar();
            int maxPrice = view.getMaxPrice();
            int minPrice = view.getMinPrice();

            try {
                for (int i = 0; i < 25; ++i) {
                    if (model.getHotels().get(i).getLocation().equals(city) && checkIn.before(checkOut)
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
                    if (model.getHotels().get(i).getLocation().equals(city) && checkIn.before(checkOut)) {
                        hotelList.add(model.getHotels().get(i));
//                        hotelList[i] = model.getHotels().get(i);
                        hotelsFound += 1;
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
        //panel.add(selectedFieldName);
        panel.add(enteredValue);
        panel.add(reserveButton);
        frame.add(panel);


//            panel.setLayout(null);
    }

}
