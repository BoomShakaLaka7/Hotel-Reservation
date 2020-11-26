package com.company.controller;

import com.company.model.Hotel;
import com.company.model.Model;
import com.company.model.User;
import com.company.view.View;
import com.company.view.View2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {
    private View view;
    private User user;
    private Model model;

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
            View2 view2 = new View2(model, view);
        }
    }

}
