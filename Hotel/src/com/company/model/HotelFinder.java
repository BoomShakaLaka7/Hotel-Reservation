package com.company.model;

import com.company.view.View;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class HotelFinder{
    private static String city;
    private static String hotelName;
    private static Date checkIn;
    private static Date checkOut;
    private static int numberOfGuests;
    private static int star;
    private static int minPrice;
    private static int maxPrice;
    private static String review;
    private static ArrayList<Hotel> hotels = new ArrayList<>();
//    private static HashMap<String, Hotel> hotels = new HashMap<>();

    public HotelFinder(String hotelName, String city, int star, String review) {
        this.city = city;
        this.numberOfGuests = numberOfGuests;
        this.review = review;
    }

    public HotelFinder() {
    }

    public static void getHotels() throws IOException {
        FileReader file = new FileReader("Hotel.txt");
        BufferedReader inputFile = new BufferedReader(file);
        String str = inputFile.readLine();

        String line = null;
        while((line = inputFile.readLine()) != null){
            String[] values = line.split(", ");

            for(String val: values){
                    hotels.add(new Hotel(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), Float.parseFloat(values[4])));
                }
        }
    }


//    public void updateValues(String city, Date checkIn, Date checkOut, int numberOfGuests, int minPrice, int maxPrice, String review){
//        this.city = city;
//        this.checkIn = checkIn;
//        this.checkOut = checkOut;
//        this.numberOfGuests = numberOfGuests;
//        this.minPrice = minPrice;
//        this.maxPrice = maxPrice;
//        this.review = review;
//    }
}
