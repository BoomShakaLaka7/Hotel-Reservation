package com.company.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class HotelFinder {
    private String city;
    private Date checkIn;
    private Date checkOut;
    private int numberOfGuests;
    private float minPrice;
    private float maxPrice;
    private float review;

    public ArrayList<Hotel> sort() throws IOException {
        File file = new File("Hotel.txt");
        FileWriter fw = new FileWriter(file, true);

        ArrayList<Hotel> hotels = new ArrayList<>();
        return hotels;
    }

    public void display(){

    }

}
