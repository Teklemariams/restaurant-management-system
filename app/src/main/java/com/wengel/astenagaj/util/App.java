package com.wengel.astenagaj.util;

import android.app.Application;

import com.wengel.astenagaj.customer.menus.MeuItemController;

public class App extends Application {
    private MeuItemController meuItemController;

    @Override
    public void onCreate() {
        super.onCreate();
        meuItemController = new MeuItemController();
    }

    public MeuItemController getMenuItemController() {
        return meuItemController;
    }
}
