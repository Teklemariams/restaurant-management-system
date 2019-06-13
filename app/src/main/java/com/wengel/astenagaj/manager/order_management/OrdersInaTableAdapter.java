package com.wengel.astenagaj.manager.order_management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wengel.astenagaj.R;

import java.util.ArrayList;

public class OrdersInaTableAdapter<Order> extends ArrayAdapter<Order> {

    public OrdersInaTableAdapter(Context context, ArrayList<Order> objects) {
        super(context, 0, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final com.wengel.astenagaj.models.Order order = (com.wengel.astenagaj.models.Order) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_layout_addedmenu_item, parent, false);
        }
        ImageView orderImageView = convertView.findViewById(R.id.addedmenuitem_img_Iv);
        TextView menuItemName = convertView.findViewById(R.id.addedmenuitem_name_tv);
        TextView menuItemQuantity = convertView.findViewById(R.id.addedmenuitem_quantity_label);
        // data in to the views
        menuItemName.setText(order.getMenuItem().getName());
        menuItemQuantity.setText(String.valueOf(order.getQuantityOrdered()));
        orderImageView.setImageResource(order.getMenuItem().getImageId());
        return convertView;
    }
}
