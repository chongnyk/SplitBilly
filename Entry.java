package com.example.splitbilly;

import static com.example.splitbilly.Tax.applyTax;

public class Entry {
    private String name;
    private double quantity;
    private double price;
    private double tax;
    private double priceWTax;
    private double taxMulti;

    public Entry(){
        this("default", 0, 0, 0);
    }

    public Entry(String name, double quantity, double price, int taxType){
        this.name = name;
        this.quantity = quantity;
        this.price = price * this.quantity;
        tax = applyTax(taxType, this.price);
        priceWTax = this.price + tax;
    }

    public String getName(){
        return this.name;
    }

    public double getQuant(){
        return this.quantity;
    }

    public double getPrice(){
        return this.price;
    }

    public double getTax(){
        return this.tax;
    }

    public double getPriceWTax(){
        return this.priceWTax;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setQuant(double newQuantity){
        this.quantity = newQuantity;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public String toString(){
        String result = "Name: " + getName() + "\n" +
                        "Quantity: " + getQuant() + "\n" +
                        "Price: " + getPrice() + "\n" +
                        "Tax: " + getTax() + "\n" +
                        "Total Price: " + getPriceWTax();
        return result;
    }
}
