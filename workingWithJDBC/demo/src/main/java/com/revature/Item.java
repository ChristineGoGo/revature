package com.revature;

public class Item {
    // instance variables
    private int id;
    private String name;
    private double price;

    //constructors
    Item() {}

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    // instance methods
    @Override
    public String toString() {
        return "Item: " + this.name +
        "\nid: " + this.id +
        "\nprice: " + this.price;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
