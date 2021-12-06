package com.example.pizzeria_app;

import java.util.ArrayList;

/**
 * Order Class, holds information about an individual pizza order
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class Order {
    /**
     * new instance of pizzaList
     */
    private final ArrayList<Pizza> pizzaList = new ArrayList<>();
    /**
     * price of order
     */
    private double price;
    /**
     * phone number of order
     */
    private String phoneNumber;

    /**
     * adds pizza to the order
     * @param pizza pizza
     */
    public void add(Pizza pizza){
        pizzaList.add(pizza);
        price += pizza.price();
    }

    /**
     * removes pizza from the order
     * @param pizza pizza
     */
    public void remove(Pizza pizza){
        pizzaList.remove(pizza);
        price -= pizza.price();
    }

    /**
     * returns list of pizzas in order
     * @return pizzaList
     */
    public ArrayList<Pizza> getPizzaList(){
        return pizzaList;
    }

    /**
     * getter for the price of the order
     * @return price
     */
    public double getPrice(){
        return price;
    }

    /**
     * getter for the phone number of an order
     * @return phone number
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * setter for the phone number
     * @param number
     */
    public void setPhoneNumber(String number){
        phoneNumber = number;
    }

    /**
     * getter for the final total
     * @return finalTotal
     */
    public double getFinalTotal(){
        return price * 1.06625;
    }
}
