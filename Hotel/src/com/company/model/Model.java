package com.company.model;

import java.io.*;
import java.util.*;

public class Model {
    public static ArrayList<Hotel> hotels = new ArrayList<>();
//    private static HashMap<String, Hotel> hotels = new HashMap<>();

    public Model() {
    }

    public static ArrayList<Hotel> getHotels() throws IOException {
        FileReader file = new FileReader("Hotel.txt");
        BufferedReader inputFile = new BufferedReader(file);
        String str = inputFile.readLine();

        String line = null;
        while((line = inputFile.readLine()) != null){
            String[] values = line.split(", ");

            for(String val: values){
                    hotels.add(new Hotel(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), values[4]));
                }
        }

        return hotels;
    }

    public static Object[][] getSearchResults(String city,  int star, Date checkIn, Date checkOut,
                                       int numberOfGuests, int minPrice, int maxPrice, String reviews){
        ArrayList<Object[]> hotelsList = new ArrayList<>();
        int hotelsFound = 0;
        for(int i = 0; i < hotels.size(); i++)
        {
            if(hotels.get(i).getLocation().equals(city))
            {
                Object[] HotelInfo = new Object[] {
                       hotels.get(i).getHotel(),
                       hotels.get(i).getLocation(),
                       hotels.get(i).getPrice(),
                       hotels.get(i).getStar(),

                };
                hotelsList.add(HotelInfo);
                hotelsFound += 1;
            }
        }

        Object[][] returnList = new Object[hotelsList.size()][4];
        for(int i = 0; i < hotelsFound; i ++)
        {
            returnList[i] = hotelsList.get(i);
        }
        return returnList;
    }

}
