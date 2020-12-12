package com.galvanize;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> itemList;

    public Cart(){
        itemList = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public String itemizedList(){
    return "";
    }

    public String itemQuantities() {
    return "";

    }
    public String onSaleItems()	{
        return "";
    }

    public boolean isCartEmpty() {
        return itemList.isEmpty();
    }

    public int getItemCount() {
        return itemList.size();
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Item item:itemList ) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
