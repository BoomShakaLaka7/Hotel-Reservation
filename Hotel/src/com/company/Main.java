package com.company;

import com.company.controller.Controller;
import com.company.model.Model;
import com.company.model.User;
import com.company.view.SearchResults;
import com.company.view.View;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        View view = new View();
        User user = new User();
        Model model = new Model();
//        SearchResults searchResults = new SearchResults();

        Controller controller = new Controller(view, user, model);

//        HotelFinder h = new HotelFinder();
//        System.out.println(h.getSearchResults("New-York", 5, 2, 100, 2000, "4"));
//        System.out.println(h.getHotels());
    }
}
