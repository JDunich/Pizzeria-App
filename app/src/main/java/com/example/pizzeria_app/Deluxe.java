package com.example.pizzeria_app;
/**
 * Class for Deluxe child
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class Deluxe extends Pizza{
    /**
     * Constant for Deluxe Pizza price
     */
    private static final double DELUXE_PIZZA = 12.99;
    /**
     * Constant for default amount of toppings
     */
    private static final int TOPPINGS = 5;

    /**
     * Calculates the price of the pizza based on the size and amount of toppings
     * @return price
     */
    @Override
    public double price() {
        double price = DELUXE_PIZZA;
        if(toppings.size() > TOPPINGS)
            price += (MAX_TOPPINGS - TOPPINGS) * EXTRA_TOPPING;
        if(size == Size.Medium)
            price += MEDIUM;
        if(size == Size.Large)
            price += LARGE;
        return price;
    }

    /**
     * Getter for the name of the pizza type
     * @return pizza type
     */
    @Override
    public String getName(){
        return "Deluxe";
    }
}
