package com.wengel.astenagaj.models;

public class MenuItem {
    private String name;
    int imageId;
    private double price;
    private int quantitySold;

    public MenuItem(String name, int imageId, double price, int quantitySold) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.quantitySold = quantitySold;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
