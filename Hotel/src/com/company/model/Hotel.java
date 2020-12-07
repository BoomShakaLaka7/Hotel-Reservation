package com.company.model;

/**
 * Hotel class
 */
public class Hotel implements Hotels{

    private String hotel;
    private String location;
    private int price;
    private int star;
    private String review;

    /**
     * Constructor for Hotel class
     * @param hotel holds the name of the hotel
     * @param location holds the location of the hotel
     * @param price stores the price of the hotel
     * @param star stores the star of the hotel
     * @param review stores review of the hotel
     */
    public Hotel(String hotel, String location, int price, int star, String review) {
        this.hotel = hotel;
        this.location = location;
        this.star = star;
        this.price = price;
        this.review = review;
    }

    /**
     * getter for hotel name
     * @return String
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * getter for location
     * @return String
     */
    public String getLocation() {
        return location;
    }

    /**
     * getter for hotel price
     * @return int
     */
    public int getPrice() {
        return price;
    }

    /**
     * getter for star of the hotel
     * @return int
     */
    public int getStar() {
        return star;
    }

    /**
     * getter for review of the hotel
     * @return String
     */
    public String getReview(){
        return review;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel='" + hotel + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", star=" + star +
                ", review='" + review + '\'' +
                '}';
    }
}
