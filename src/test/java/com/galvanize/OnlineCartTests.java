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
    @Test
    public void isCartEmpty() {
       assertEquals(true,cart.isCartEmpty());
    }

    @Test
    public void addItem(){
        cart.addItem(new Item(100,"Bag",100,true));
        assertEquals(1,cart.getItemCount());
    }

    @Test
    public void getTotalPrice(){
        cart.addItem(new Item(100,"Bag",10.0,true));
        cart.addItem(new Item(100,"Bag",10.0,true));
        cart.addItem(new Item(101,"Watch",20.50,true));
        assertEquals(40.50,cart.getTotalPrice());
    }
}