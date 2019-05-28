package com.wengel.astenagaj.util;

import android.app.Application;

import com.wengel.astenagaj.customer.menus.MeuItemController;
import com.wengel.astenagaj.customer.menus.OrderController;

public class App extends Application {
    private MeuItemController meuItemController;
    private OrderController orderController;

    @Override
    public void onCreate() {
        super.onCreate();
        meuItemController = new MeuItemController();
        orderController = new OrderController();
    }

    public MeuItemController getMenuItemController() {
        return meuItemController;
    }

    public OrderController getOrderController() {
        return orderController;
    }
}
