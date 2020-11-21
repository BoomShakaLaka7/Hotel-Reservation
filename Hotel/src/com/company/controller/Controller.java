package com.company.controller;

import com.company.model.Hotel;
import com.company.model.Model;
import com.company.model.User;
import com.company.view.SearchResults;
import com.company.view.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
            JTextArea results = new JTextArea();
            frame.setVisible(true);
            frame.setSize(500, 500);
            frame.setTitle("Search Results");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            results.setEditable(false);
            results.setText("");
            String city = view.getCity();
            Double review = Double.parseDouble(view.getReview());
            int star = view.getStar();
            int price = view.getMinPrice();


            List<Hotel> hotelList = new ArrayList<>();
            int hotelsFound = 0;
            try {
                for (int i = 1; i <= model.getHotels().size(); i++) {
                    if (model.getHotels().get(i).getLocation().equals(city)) {
                        hotelList.add(model.getHotels().get(i));
                        hotelsFound += 1;
                    }
                }

//                System.out.println(hotelsFound);
                for(int i = 1; i <= hotelsFound; i++){
                    results.append(i + " " + hotelList.get(i).getLocation() + "\n");
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }



            panel.add(results);
            frame.add(panel);
//            panel.setLayout(null);
        }
    }

}
