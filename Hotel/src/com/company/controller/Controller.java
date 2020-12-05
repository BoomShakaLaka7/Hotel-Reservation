package com.company.controller;

import com.company.model.Hotel;
import com.company.model.Model;
import com.company.model.User;
import com.company.view.View;
import com.company.view.View2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class
 */
public class Controller {
    private View view;
    private User user;
    private Model model;

    /**
     *Constructor for Controller
     * @param view sets View
     * @param user sets User
     * @param model sets Model
     */
    public Controller(View view, User user, Model model) {
        this.view = view;
        this.user = user;
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
        }
    }

}
