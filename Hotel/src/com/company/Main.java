package com.company;

import com.company.controller.Controller;
import com.company.model.Model;
import com.company.model.User;
import com.company.view.View;
import com.company.view.View2;
import com.company.view.View3;
import com.company.view.View4;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        View view = new View();

        //These views below will help you test our your code since View3 isn't tied to View4 yet

        //View view2 = new View2();
        //View3 view3 = new View3();
        //View4 view4 = new View4();

        User user = new User();
        Model model = new Model();


        Controller controller = new Controller(view, user, model);


    }
}
