package com.galvanize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {

    private List<Item> itemList;

    //Create t
    public Cart(){
        itemList = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        itemList.add(item);
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

    public int getCartQuantity() {
        return itemList.size();
    }

    public String getItemizedListWithQtyAndPrice() {
        StringBuffer buffer = new StringBuffer();
        Map<Integer,List<Item>> itemizedQty = new HashMap<>();
        itemizedQty =  itemList.stream().collect(Collectors.groupingBy(Item::getItemCode));
        itemizedQty.entrySet().stream().forEach(e->buffer.append(getItemizedList(e.getValue())));
        System.out.println(buffer);
        return buffer.toString();
    }

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


    public String getUpdatedItemizedList() {
        StringBuffer buffer = new StringBuffer();
        Map<Integer,List<Item>> itemizedQty = new HashMap<>();
        itemizedQty =  itemList.stream().collect(Collectors.groupingBy(Item::getItemCode));
        itemizedQty.entrySet().stream().forEach(e->buffer.append(getItemizedList(e.getValue())));
        System.out.println(buffer);
        return buffer.toString();
    }

    public int removeItem(Item itemParam) {
        itemList.remove(itemParam);
        return itemList.size();
    }
}
