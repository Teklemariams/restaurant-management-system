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

public class MyOrdersAdapter<Order> extends ArrayAdapter<Order> {

    public MyOrdersAdapter(Context context, ArrayList<Order> objects) {
        super(context, 0, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final com.wengel.astenagaj.models.Order order = (com.wengel.astenagaj.models.Order) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_layout_myorders, parent, false);
        }
        ImageView orderImageView = convertView.findViewById(R.id.myorder_img_Iv);
        TextView orderName = convertView.findViewById(R.id.myorder_name_tv);
        TextView orderedQuantity = convertView.findViewById(R.id.myorder_quantity_label);
        TextView myOrderStatus = convertView.findViewById(R.id.myorder_status_label);

        // data in to the views
        orderName.setText(order.getMenuItem().getName());
        orderedQuantity.setText(String.valueOf(order.getQuantityOrdered()));
        orderImageView.setImageResource(order.getMenuItem().getImageId());
        myOrderStatus.setText(order.getStatus());
        return convertView;
    }
}
