package com.company;

import com.company.controller.Controller;
import com.company.model.User;
import com.company.view.View;

public class Main {

    public static void main(String[] args) {

        View view = new View();
        User model = new User();

        Controller controller = new Controller(view, model);
    }
}
