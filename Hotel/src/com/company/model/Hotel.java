package com.company.model;

public class Hotel {
    private String hotel;
    private String location;
    private int price;
    private int star;
    private float review;

    public Hotel(String hotel, String location, int price, int star, float review) {
        this.hotel = hotel;
        this.location = location;
        this.star = star;
        this.price = price;
        this.review = review;
    }

    public String getHotel() {
        return hotel;
    }

    public String getLocation() {
        return location;
    }

    public float getPrice() {
        return price;
    }

    public int getStar() {
        return star;
    }
}
