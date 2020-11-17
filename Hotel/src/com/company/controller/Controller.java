package com.company.controller;

import com.company.model.Hotel;
import com.company.model.Model;
import com.company.model.User;
import com.company.view.SearchResults;
import com.company.view.View;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Controller {
    private View view;
    private User user;
    private Model model;
    private SearchResults searchResults;

    public Controller(View view, User user, SearchResults searchResults, Model model) {
        this.view = view;
        this.user = user;
        this.searchResults = searchResults;
        this.model = model;

        this.view.searchButtonListener(new searchButtonClick());
    }

    class searchButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                SearchResults.searchResultsImpl();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    class MainSearchClick implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            DefaultTableModel tableModel = (DefaultTableModel) searchResults.getTable().getModel();
            for(int i = 0; i < Model.hotels.size(); i++){
                Hotel hotel = model.hotels.get(i);

                view.setCity(hotel.getLocation());
                view.setMinPrice(hotel.getPrice());
                view.setStar(hotel.getStar());
                view.setReviews(hotel.getReview());
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
