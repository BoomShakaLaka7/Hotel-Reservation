package com.company.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HotelFinder {
    private String city;
    private Calendar checkIn;
    private Calendar checkOut;
    private int numberOfGuests;
    private float minPrice;
    private float maxPrice;
    private String review;

    public ArrayList<Hotel> sort() throws IOException {
        File file = new File("Hotel.txt");
        FileWriter fw = new FileWriter(file, true);

        

        ArrayList<Hotel> hotels = new ArrayList<>();
        return hotels;
    }

    public void display(){

    }

    public void updateValues(String city, Calendar checkIn, Calendar checkOut, int numberOfGuests, float minPrice, float maxPrice, String review){
        this.city = city;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfGuests = numberOfGuests;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.review = review;
    }
}
