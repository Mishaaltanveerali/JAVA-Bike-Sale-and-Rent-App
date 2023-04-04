package com.example.bikerapplication;

public class Bike {
    String bikeName;
    String bikePrice;
    String bikeColor;
    public Bike() {

    }

    public Bike(String bikeName,String bikePrice, String bikeColor) {
        this.bikeName = bikeName;
        this.bikePrice = bikePrice;
        this.bikeColor = bikeColor;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public void setBikePrice(String bikePrice) {
        this.bikePrice = bikePrice;
    }

    public void setBikeColor(String bikeColor) {
        this.bikeColor = bikeColor;
    }


    public String getBikeName() {
        return bikeName;
    }

    public String getBikePrice() {
        return bikePrice;
    }

    public String getBikeColor() {
        return bikeColor;
    }
}

