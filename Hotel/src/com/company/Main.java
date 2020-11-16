package com.company;

import com.company.controller.Controller;
import com.company.model.HotelFinder;
import com.company.model.User;
import com.company.view.View;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        View view = new View();
        User model = new User();

        Controller controller = new Controller(view, model);
//        HotelFinder h = new HotelFinder();
//        System.out.println(h.getSearchResults("New-York", 5, 2, 100, 2000, "4"));
//        System.out.println(h.getHotels());
    }
}
