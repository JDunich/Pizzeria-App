package com.example.pizzeria_app;

/**
 * Class for PizzaMaker
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class PizzaMaker {
    /**
     * Creates Pizza based on type
     * @param flavor type
     * @return pizza
     */
    public static Pizza createPizza(String flavor) {
        if(flavor.equals("Deluxe"))
            return new Deluxe();
        if(flavor.equals("Hawaiian"))
            return new Hawaiian();
        return new Pepperoni();
    }

}
