package com.company.controller;

import com.company.model.Model;
import com.company.view.View;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }
}
