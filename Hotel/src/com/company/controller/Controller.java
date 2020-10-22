package com.company.controller;

import com.company.model.User;
import com.company.view.View;

public class Controller {
    private View view;
    private User model;

    public Controller(View view, User model) {
        this.view = view;
        this.model = model;
    }
}
