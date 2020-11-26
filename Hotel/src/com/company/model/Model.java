package com.company.model;

import com.company.view.View;

import java.io.*;
import java.util.*;

public class Model {
    public ArrayList<Hotel> hotels = new ArrayList<>();
//    public static ArrayList<Hotel> sortedHotels = new ArrayList<>();

    public ArrayList<Hotel> getHotels() throws IOException {
        FileReader file = new FileReader("Hotel.txt");
        BufferedReader inputFile = new BufferedReader(file);
        String str = inputFile.readLine();

        String line = null;
        while((line = inputFile.readLine()) != null){
            String[] values = line.split(", ");

//            for(String val: values){
                    hotels.add(new Hotel(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), values[4]));
//                }
        }
//        inputFile.close();
        file.close();
        return hotels;
    }


}
