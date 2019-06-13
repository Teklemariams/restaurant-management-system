package com.wengel.astenagaj.util;

import android.app.Application;

import com.wengel.astenagaj.customer.menus.MeuItemController;
import com.wengel.astenagaj.customer.menus.OrderController;
import com.wengel.astenagaj.manager.employee_management.EmployeeController;

public class App extends Application {
    private MeuItemController meuItemController;
    private OrderController orderController;
    private EmployeeController employeeController;

    @Override
    public void onCreate() {
        super.onCreate();
        meuItemController = new MeuItemController();
        orderController = new OrderController();
        employeeController = new EmployeeController();
    }

    public MeuItemController getMenuItemController() {
        return meuItemController;
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public EmployeeController getEmployeeController() {
        return employeeController;
    }
}
