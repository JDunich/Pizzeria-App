package com.example.pizzeria_app;

/**
 * Class for Pepperoni child
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class Pepperoni extends Pizza{
    /**
     * Constant for Pepperoni Pizza price
     */
    private static final double PEPPERONI_PIZZA = 8.99;
    /**
     * Constant for default amount of toppings
     */
    private static final int TOPPINGS = 1;

    /**
     * Calculates the price of the pizza based on the size and amount of toppings
     * @return price
     */
    @Override
    public double price() {
        double price = PEPPERONI_PIZZA;
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
        return "Pepperoni";
    }
}
