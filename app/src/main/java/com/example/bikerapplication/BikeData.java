package com.example.bikerapplication;

public class BikeData {
    String name;
    String price;
    String color;

    public BikeData(String name, String price, String colore) {
        this.name = name;
        this.price = price;
        this.color = colore;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}
