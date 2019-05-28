package com.wengel.astenagaj.models;

class Order {
    private MenuItem menuItem;
    private int tableNo;
    private String waiterHandling;
    private String status;
    private boolean isPaid;

    public Order(MenuItem menuItem, int tableNo, String waiterHandling, String status, boolean isPaid) {
        this.menuItem = menuItem;
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

    @Override
    public String toString() {
        return super.toString();
    }
}
