package com.galvanize;

import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class OnlineCartTests {

    public Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    //Given that I a new shopper, when I begin shopping, then I expect my cart to be empty.
    @Test
    public void isCartEmpty() {
       assertEquals(true,cart.isCartEmpty());
    }


    @Test
    public void addItem(){
        cart.addItem(new Item(100,"Bag",100,true));
        assertEquals(1,cart.getItemCount());
    }

    //Given I have an empty cart, when I add an Item, then I expect to the price reflect the sum of all the Items in my cart.
    @Test
    public void getTotalPrice(){
        cart.addItem(new Item(100,"Bag",10.0,true));
        cart.addItem(new Item(100,"Bag",10.0,true));
        cart.addItem(new Item(101,"Watch",20.50,true));
        assertEquals(40.50,cart.getTotalPrice());
    }

    //Given I have cart with one item, when I add more of that item, then I expect to see its quantity update on the cart.
    @Test
    public void getCartQuantity(){
        cart.addItem(new Item(100,"Bag",10.0,true));
        cart.addItem(new Item(100,"Bag",10.0,true));

        assertEquals(2,cart.getCartQuantity());
        cart.addItem(new Item(101,"Watch",20.50,true));
        cart.addItem(new Item(101,"Watch",20.50,true));
        assertEquals(3,cart.getCartQuantity());
    }

    //Given I have an empty cart, when I add items, then I expect it to see an itemized list of the items along with their price and quantity.
    @Test
    public void getItemizedListWithQtyAndPrice(){
        cart.addItem(new Item(100,"Bag",10.0,true));
        cart.addItem(new Item(100,"Bag",10.0,true));
        cart.addItem(new Item(101,"Watch",20.50,true));
        cart.addItem(new Item(101,"Watch",20.50,true));

        StringBuffer buffer = new StringBuffer("Item name: Bag Item count: 2 Item price 20.0 Item name: Watch Item count: 2 Item price 41.0 ");
        assertEquals(buffer.toString(),cart.getItemizedListWithQtyAndPrice());

    }

    //Given I have a cart with items that are not on sale, when I add an item that's on sale, I expect to see it highlighted.
    @Test
    public void getItemNotOnSale(){

        cart.addItem(new Item(100,"Bag",10.0,false));
        cart.addItem(new Item(101,"Watch",20.50,true));

        assertEquals("[Bag]",cart.getItemNotOnSale());

    }

    //Given I have a cart with items, when I remove an item, then I expect the cart to display the updated itemized list.
    @Test
    public void getUpdatedItemizedList(){

        cart.addItem(new Item(100,"Bag",10.0,false));
        cart.addItem(new Item(101,"Watch",20.50,true));
        cart.removeItem(new Item(101,"Watch",20.50,true));

        assertEquals("[Bag]",cart.getUpdatedItemizedList());

    }

    //Given I have one item in my cart with a quantity of 3, when I remove one, then I expect the cart to have 2 of that item.
    @Test
    public void removeItemFromCart(){

        cart.addItem(new Item(100,"Bag",10.0,false));
        cart.addItem(new Item(101,"Watch",20.50,true));
        cart.removeItem(new Item(101,"Watch",20.50,true));

        assertEquals(2,cart.removeItem(new Item(101,"Watch",20.50,true)));

    }
}