package com.galvanize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {

    private List<Item> itemList;

    //Create the empty cart object.
    public Cart(){
        itemList = new ArrayList<Item>();
    }

    //Add the item to the cart
    public void addItem(Item item) {
        itemList.add(item);
    }

    //Check is the cart is empty
    public boolean isCartEmpty() {
        return itemList.isEmpty();
    }

    //Get the item count in the cart
    public int getItemCount() {
        return itemList.size();
    }

    //Get the total price of the all items in the cart
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Item item:itemList ) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    //Get the total quantity of items in the cart
    public int getCartQuantity() {
        return itemList.size();
    }

    //Get the itemized list and quantity and price of items in the cart
    public String getItemizedListWithQtyAndPrice() {
        StringBuffer buffer = new StringBuffer();
        Map<Integer,List<Item>> itemizedQty = new HashMap<>();
        itemizedQty =  itemList.stream().collect(Collectors.groupingBy(Item::getItemCode));
        itemizedQty.entrySet().stream().forEach(e->buffer.append(getItemizedList(e.getValue())));
        System.out.println(buffer);
        return buffer.toString();
    }

    //check is the item on the sale
    public String getItemNotOnSale() {

        List<String> isItemOnSale = new ArrayList<String>();
        for (Item item : itemList) {
            if (! item.isOnSale()) {
                isItemOnSale.add(item.getName());
            }
        }
        isItemOnSale= isItemOnSale.stream().distinct().collect(Collectors.toList());

        return isItemOnSale.toString();
    }

    //Get the itemized list
    private String getItemizedList(List<Item> items) {
        StringBuffer buffer = new StringBuffer();
        int itemCnt = 0;
        String itemName = "";
        double itemPrice = 0.0;
        for (Item item:items) {
            itemPrice+= item.getPrice();
            itemName = item.getName();
            itemCnt++;
           }
        buffer.append("Item name: "+itemName+" Item count: "+itemCnt+" Item price "+itemPrice);
        buffer.append(" ");
        return buffer.toString();
    }

    //Get the update itemized list of the items
    public String getUpdatedItemizedList() {
        StringBuffer buffer = new StringBuffer();
        Map<Integer,List<Item>> itemizedQty = new HashMap<>();
        itemizedQty =  itemList.stream().collect(Collectors.groupingBy(Item::getItemCode));
        itemizedQty.entrySet().stream().forEach(e->buffer.append(getItemizedList(e.getValue())));
        return buffer.toString();
    }

    //Remove the item from the cart
    public int removeItem(Item itemParam) {
        itemList.remove(itemParam);
        return itemList.size();
    }
}
