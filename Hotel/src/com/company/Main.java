package com.company;

import com.company.controller.Controller;
import com.company.model.Model;
import com.company.view.View;

public class Main {

    private static View view;
    private static Model model;

    public static void main(String[] args) {
        Controller controller = new Controller(view, model);
    }
}
