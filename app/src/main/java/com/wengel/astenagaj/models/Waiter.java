package com.wengel.astenagaj.models;

import java.util.ArrayList;

/**
 * Model for representing Employee
 */
public class Waiter extends Employee {
    private ArrayList<Order> ordersHandled;

    public Waiter(String name, int age, int employeeId, String hireDate, double efficiency, ArrayList<Order> ordersHandled) {
        super(name, age, employeeId, hireDate, efficiency, "Waiter");
        this.ordersHandled = ordersHandled;
    }

    public ArrayList<Order> getOrdersHandled() {
        return ordersHandled;
    }

    public void setOrdersHandled(ArrayList<Order> ordersHandled) {
        this.ordersHandled = ordersHandled;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
