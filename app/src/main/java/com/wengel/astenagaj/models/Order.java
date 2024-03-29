package com.wengel.astenagaj.models;

/**
 * Model for Order
 */
public class Order {
    private MenuItem menuItem;
    private int quantityOrdered;
    private int tableNo;
    private String waiterHandling;
    private String status;
    private boolean isPaid;

    public Order(MenuItem menuItem, int quantity, int tableNo, String waiterHandling, String status, boolean isPaid) {
        this.menuItem = menuItem;
        this.quantityOrdered = quantity;
        this.tableNo = tableNo;
        this.waiterHandling = waiterHandling;
        this.status = status;
        this.isPaid = isPaid;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public String getWaiterHandling() {
        return waiterHandling;
    }

    public void setWaiterHandling(String waiterHandling) {
        this.waiterHandling = waiterHandling;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getTotalPrice() {
        int quantity = getQuantityOrdered();
        double price = getMenuItem().getPrice();
        return quantity * price;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
