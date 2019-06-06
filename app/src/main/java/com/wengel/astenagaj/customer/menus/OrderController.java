package com.wengel.astenagaj.customer.menus;

import com.wengel.astenagaj.models.Order;

import java.util.ArrayList;

public class OrderController {
    private ArrayList<Order> orders;
    private ArrayList<Order> submittedOrders;

    public OrderController() {
        orders = new ArrayList<>();
        submittedOrders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    //total price for submitted orders- more than 1 order by adding each sub total price of an order)
    public double getOrdersTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < submittedOrders.size(); i++) {
            double orderPrice = submittedOrders.get(i).getTotalPrice();
            totalPrice += orderPrice;
        }
        return totalPrice;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Order> getSubmittedOrders() {
        return submittedOrders;
    }

    public void setSubmittedOrders(ArrayList<Order> submittedOrders) {
        this.submittedOrders = submittedOrders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
//to avoid index out of bound exception
    public void deleteSubmittedOrder(int orderIndex) {
        if (submittedOrders.size() > orderIndex) {
            submittedOrders.remove(orderIndex);
        }
    }

    public void addSubmittedOrder(Order submittedOrder) {
        submittedOrders.add(submittedOrder);
    }


}
