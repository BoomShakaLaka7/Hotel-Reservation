package com.company.model;

import com.company.view.View;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HotelFinder {
    private String city;
    private Date checkIn;
    private Date checkOut;
    private int numberOfGuests;
    private float minPrice;
    private float maxPrice;
    private String review;

    View view;
    ArrayList<Hotel> hotels = new ArrayList<>();

    public ArrayList<Hotel> sort() throws IOException {
        FileReader file = new FileReader("Hotel.txt");
        BufferedReader inputFile = new BufferedReader(file);
        String str = inputFile.readLine();

        String line = null;
        while((line = inputFile.readLine()) != null){
            String[] values = line.split(", ");

            city = view.getCity();
            numberOfGuests = view.getGuests();
            checkIn = view.getCheckIn();
            checkOut = view.getCheckOut();
            minPrice = view.getMinPrice();
            maxPrice = view.getMaxPrice();
            review = view.getReview();

            for(String val: values){
                if(city.equals(values[0]) ) {//&& review.equals(values[3]))
                    hotels.add(new Hotel(values[1], values[2], Float.parseFloat(values[3]), Integer.parseInt(values[4]),
                            Float.parseFloat(values[5])));
                }
            }
        }

        return hotels;
    }

    public void display(){

    }

//    public void updateValues(String city, Calendar checkIn, Calendar checkOut, int numberOfGuests, float minPrice, float maxPrice, String review){
//        this.city = city;
//        this.checkIn = checkIn;
//        this.checkOut = checkOut;
//        this.numberOfGuests = numberOfGuests;
//        this.minPrice = minPrice;
//        this.maxPrice = maxPrice;
//        this.review = review;
//    }
}
