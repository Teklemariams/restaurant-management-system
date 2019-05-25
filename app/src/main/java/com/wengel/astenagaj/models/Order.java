package com.wengel.astenagaj.models;

class Order {
    FoodItem foodItem;
    int tableNo;
    String waiterHandling;
    String status;
    boolean isPaid;

    public Order(FoodItem foodItem, int tableNo, String waiterHandling, String status, boolean isPaid) {
        this.foodItem = foodItem;
        this.tableNo = tableNo;
        this.waiterHandling = waiterHandling;
        this.status = status;
        this.isPaid = isPaid;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
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
