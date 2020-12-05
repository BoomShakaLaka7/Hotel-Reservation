package com.company.model;

/**
 * Hotel class
 */
public class Hotel {
    private String hotel;
    private String location;
    private int price;
    private int star;
    private String review;

    /**
     * Constructor for Hotel class
     * @param hotel
     * @param location
     * @param price
     * @param star
     * @param review
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
     * @return
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * getter for location
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * getter for hotel price
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * getter for star of the hotel
     * @return
     */
    public int getStar() {
        return star;
    }

    /**
     * getter for review of the hotel
     * @return
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
