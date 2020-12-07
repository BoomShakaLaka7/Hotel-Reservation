package com.company;

import com.company.controller.Controller;
import com.company.model.Model;
import com.company.view.View;
import com.company.view.View3;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        View view = new View();
//        User user = new User();
        Model model = new Model();

        Controller controller = new Controller(view, model);
    }
}
