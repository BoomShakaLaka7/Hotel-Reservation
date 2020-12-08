package com.company.controller;

import com.company.model.Model;
import com.company.model.User;
import com.company.view.View;
import com.company.view.View2;
import com.company.view.View3;
import com.company.view.View4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Controller class
 */
public class Controller {
    private View view;
    private Model model;

    /**
     *Constructor for Controller
     * @param view sets View
     * @param model sets Model
     */
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.searchButtonListener(new searchButtonClick());
    }

    /**
     * displays the View2 when search button clicked
     */
    class searchButtonClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            View2 view2 = new View2(model, view);
            if(view2.getEnteredValue() != ""){
                view2.reserveButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                        View3 view3 = new View3(view2.getEnteredValue(), view2.hotelList);
                        View3 view3 = new View3();
                        view3.loginButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int price = view2.getHotelPrice();
                                String selectedHotel = view2.getHotelName();
                                View4 view4 = new View4(selectedHotel, price);
                            }
                        });
                    }
                });
            }
        }
    }
}
