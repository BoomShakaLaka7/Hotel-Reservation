package com.company.model;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Testing the input taken from txt file
 */
public class HotelTest {

    /**
     * Method to test if hotel import from txt work properly
     */
    public void testHotelInputFromTxt() throws IOException {
        Model testModel = new Model();
        ArrayList<Hotel> testHotels = testModel.getHotels();

        //assert statements to test if hotel imported properly

        //first one
        assertEquals("1st Hotel name must be Hilton Union Square","Hilton Union Square", testHotels.get(1).getHotel());
        assertEquals("1st Hotel location must be San Francisco","San Francisco", testHotels.get(1).getLocation());
        assertEquals("1st Hotel price must be 135", "135", testHotels.get(1).getPrice());
        assertEquals("1st Hotel star must be 4","4", testHotels.get(1).getStar());
        assertEquals("1st Hotel review must be 4.2","4.2", testHotels.get(1).getReview());

        //second one
        assertEquals("2nd Hotel name must be Hilton Financial District","Hilton Financial District", testHotels.get(2).getHotel());
        assertEquals("2nd Hotel location must be San Francisco","San Francisco", testHotels.get(2).getLocation());
        assertEquals("2nd Hotel price must be 95","95", testHotels.get(2).getPrice());
        assertEquals("2nd Hotel star must be 4","4", testHotels.get(2).getStar());
        assertEquals("2nd Hotel review must be 4.3","4.3", testHotels.get(2).getReview());

        //third one

        assertEquals("3rd Hotel name must be Marriott Marquis","Marriott Marquis", testHotels.get(3).getHotel());
        assertEquals("3rd Hotel location must be San Francisco","San Francisco", testHotels.get(3).getLocation());
        assertEquals("3rd Hotel price must be 169","169", testHotels.get(3).getPrice());
        assertEquals("3rd Hotel star must be 5","5", testHotels.get(3).getStar());
        assertEquals("3rd Hotel review must be 4.4","4.4", testHotels.get(3).getReview());

        //fourth one

        assertEquals("4th Hotel name must be Intercontinental","Intercontinental", testHotels.get(4).getHotel());
        assertEquals("4th Hotel location must be San Francisco","San Francisco", testHotels.get(4).getLocation());
        assertEquals("4th Hotel price must be 144","144", testHotels.get(4).getPrice());
        assertEquals("4th Hotel star must be 4","4", testHotels.get(4).getStar());
        assertEquals("4th Hotel review must be 4.4","4.4", testHotels.get(4).getReview());

        //fifth one

        assertEquals("5th Hotel name must be Hyatt Regency","Hyatt Regency", testHotels.get(5).getHotel());
        assertEquals("5th Hotel location must be San Francisco","San Francisco", testHotels.get(5).getLocation());
        assertEquals("5th Hotel price must be 179","179", testHotels.get(5).getPrice());
        assertEquals("5th Hotel star must be 5","5", testHotels.get(5).getStar());
        assertEquals("5th Hotel review must be 4.5","4.5", testHotels.get(5).getReview());

    }}
