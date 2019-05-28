package com.wengel.astenagaj.customer.menus;

import com.wengel.astenagaj.models.Order;

import java.util.ArrayList;

public class OrderController {
    private ArrayList<Order> orders;

    public OrderController() {
        orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
