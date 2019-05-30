package com.wengel.astenagaj.customer.orders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wengel.astenagaj.R;

import java.util.ArrayList;

public class PricedOrdersAdapter<Order> extends ArrayAdapter<Order> {

    public PricedOrdersAdapter(Context context, ArrayList<Order> objects) {
        super(context, 0, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final com.wengel.astenagaj.models.Order order = (com.wengel.astenagaj.models.Order) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_layout_pricedorder_item, parent, false);
        }
        ImageView pricedOrderImageView = convertView.findViewById(R.id.pricedOrder_img_Iv);
        TextView pricedOrderName = convertView.findViewById(R.id.pricedOrder_name_tv);
        TextView pricedMenuItemQuantity = convertView.findViewById(R.id.pricedMenuItem_quantity_label);
        TextView pricedMenuItemQuantity2 = convertView.findViewById(R.id.pricedMenuItem_quantity_label2);
        TextView pricedMenuItemPrice = convertView.findViewById(R.id.pricedOrder_price_tv);
        TextView pricedOrderSubtotalPrice = convertView.findViewById(R.id.pricedOrder_subtotal_price_tv);

        // data in to the views
        pricedOrderImageView.setImageResource(order.getMenuItem().getImageId());
        pricedOrderName.setText(order.getMenuItem().getName());
        pricedMenuItemQuantity.setText(String.valueOf(order.getQuantityOrdered()));
        pricedMenuItemQuantity2.setText(String.valueOf(order.getQuantityOrdered()));
        pricedMenuItemPrice.setText(String.valueOf(order.getMenuItem().getPrice()));
        pricedOrderSubtotalPrice.setText(String.valueOf(order.getQuantityOrdered()*order.getMenuItem().getPrice()));
        return convertView;
    }
}
