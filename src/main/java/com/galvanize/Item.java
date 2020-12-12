package com.galvanize;

public class Item {

    public int itemCode;
    public String name;
    public double price;
    public boolean onSale;

    public Item(int itemCode,String name, double price, boolean onSale){
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.onSale = onSale;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
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

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }



}
