package com.example.pizzeria_app;

/**
 * Class for Hawaiian child
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class Hawaiian extends Pizza{
    /**
     * Constant for Hawaiian Pizza price
     */
    private static final double HAWAIIAN_PIZZA = 10.99;
    /**
     * Constant for default amount of toppings
     */
    private static final int TOPPINGS = 2;

    /**
     * Calculates the price of the pizza based on the size and amount of toppings
     * @return price
     */
    @Override
    public double price() {
        double price = HAWAIIAN_PIZZA;
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
        return "Hawaiian";
    }
}
