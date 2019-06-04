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
//total price for orders- more than 1 order by adding each sub total price of an order)
    public double getOrdersTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < orders.size(); i++) {
            double orderPrice = orders.get(i).getTotalPrice();
            totalPrice += orderPrice;
        }
        return totalPrice;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
