package com.example.pizzeria_app;

import java.util.ArrayList;

/**
 * Class for Pizza Super
 * @author Jack Dunich
 * @author Kiana Perst
 */
public abstract class Pizza {
    /**
     * Constant for price per extra topping
     */
    protected static final double EXTRA_TOPPING = 1.49;
    /**
     * Constant for price increase for medium pizza
     */
    protected static final double MEDIUM = 2.00;
    /**
     * Constant for price increase for large pizza
     */
    protected static final double LARGE = 4.00;
    /**
     * Constant for max amount of toppings
     */
    protected static final int MAX_TOPPINGS = 7;
    /**
     * List of toppings
     */
    protected ArrayList<Topping> toppings;
    /**
     * Size for pizza
     */
    protected Size size;

    /**
     * Method for calculating the price depending on pizzaType
     * @return price
     */
    public abstract double price();

    /**
     * Method for returning the name depending on pizzaType
     * @return name
     */
    public abstract String getName();

    /**
     * Setter for toppings of pizza
     * @param toppings toppings
     */
    public void setToppings(ArrayList<Topping> toppings){
        this.toppings = toppings;
    }

    /**
     * Setter for size of pizza
     * @param size
     */
    public void setSize(Size size){
        this.size = size;
    }

    /**
     * Method for sending the pizza to a String
     * @return
     */
    @Override
    public String toString(){
        String separator = "->";
        return getName() + separator + getToppings();
    }

    /**
     * Getter for the size of a pizza
     * @return size
     */
    public Size getSize(){
        return size;
    }

    /**
     * Getter for the toppings of a pizza
     * @return
     */
    public ArrayList<Topping> getToppings(){
        return toppings;
    }
}
