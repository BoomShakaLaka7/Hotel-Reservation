package com.company.model;

import com.company.view.View;

import java.io.*;
import java.util.*;

/**
 * Model class
 */
public class Model {

    /**
     * stores list of hotels from txt file
     */
    public ArrayList<Hotel> hotels = new ArrayList<>();

    /**
     * Gets hotels from the file and stores it in the ArrayList
     * @return ArrayList
     * @throws IOException
     */
    public ArrayList<Hotel> getHotels() throws IOException {
        FileReader file = new FileReader("Hotel.txt");
        BufferedReader inputFile = new BufferedReader(file);
        String str = inputFile.readLine();

        String line = null;
        while((line = inputFile.readLine()) != null){
            String[] values = line.split(", ");

                    hotels.add(new Hotel(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), values[4]));
        }
        file.close();
        return hotels;
    }

}
