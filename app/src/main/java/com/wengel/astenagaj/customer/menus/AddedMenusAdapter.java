package com.wengel.astenagaj.customer.menus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.wengel.astenagaj.R;

import java.util.ArrayList;

public class AddedMenusAdapter<MenuItem> extends ArrayAdapter<MenuItem> {

    public AddedMenusAdapter(Context context, ArrayList<MenuItem> objects) {
        super(context, 0, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        com.wengel.astenagaj.models.MenuItem menuItem = (com.wengel.astenagaj.models.MenuItem)getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_layout_menu_item, parent, false);
        }
        ImageView menuItemImageView = convertView.findViewById(R.id.menuitem_img_Iv);
        TextView menuItemName = convertView.findViewById(R.id.menuitem_name_tv);
        TextView menuItemPrice = convertView.findViewById(R.id.menuitem_price_tv);
        // data in to the views
        //for image to be implemented
        menuItemName.setText(menuItem.getName());
        menuItemPrice.setText(String.valueOf(menuItem.getPrice()+"Br" ));
        return convertView;
    }
}
