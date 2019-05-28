package com.wengel.astenagaj.customer.menus;

import com.wengel.astenagaj.models.MenuItem;

import java.util.ArrayList;

public class MeuItemController {
    private ArrayList<MenuItem> menus;

    public MeuItemController() {
        menus = new ArrayList<>();
    }

    public ArrayList<MenuItem> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<MenuItem> menus) {
        this.menus = menus;
    }

    public void addMenuItem(MenuItem menuItem) {
        menus.add(menuItem);
    }
}
