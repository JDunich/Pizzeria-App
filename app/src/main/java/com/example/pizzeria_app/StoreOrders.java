package com.example.pizzeria_app;

import java.util.ArrayList;

/**
 * Class for keeping a list of orders
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class StoreOrders {
    /**
     * Instance of orders
     */
    private final ArrayList<Order> orders = new ArrayList<>();

    /**
     * Adds order to orders
     * @param order
     */
    public void add(Order order){
        orders.add(order);

    }

    /**
     * Removes order from orders
     * @param order
     */
    public void cancel(Order order){
        orders.remove(order);
    }

    /**
     * Getter for order with same number
     * @param number number
     * @return order
     */
    public Order getSameNumber(String number){
        number = number.replaceAll("[^\\d.]", "");
        for(Order item : orders){
            if(item.getPhoneNumber().equals(number))
                return item;
        }
        return null;
    }

    /**
     * Getter for First Instance in list
     * @return
     */
    public Order getFirstNumber(){
        return orders.get(0);
    }

    /**
     * Getter for all orders in list
     * @return orderList
     */
    public ArrayList<Order> getOrdersList(){
        return orders;
    }

}
