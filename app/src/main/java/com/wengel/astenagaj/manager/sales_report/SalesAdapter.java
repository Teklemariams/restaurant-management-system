package com.wengel.astenagaj.manager.sales_report;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.models.MenuItem;

import java.util.ArrayList;

public class SalesAdapter<MeuItem> extends ArrayAdapter<MeuItem> {


    public SalesAdapter(Context context, ArrayList<MeuItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final com.wengel.astenagaj.models.MenuItem menuItem = (com.wengel.astenagaj.models.MenuItem) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_sales, parent, false);
        }

        TextView itemNameTv = convertView.findViewById(R.id.salesListItem_item);
        TextView priceTv = convertView.findViewById(R.id.salesListItem_price);
        TextView quantityTv = convertView.findViewById(R.id.salesListItem_quantity);
        TextView subtTotalTv = convertView.findViewById(R.id.salesListItem_subTotal);
        // data in to the views
        itemNameTv.setText(String.valueOf(menuItem.getName()));
        priceTv.setText(String.valueOf(menuItem.getPrice()));
        quantityTv.setText(String.valueOf(menuItem.getQuantitySold()));
        subtTotalTv.setText(String.valueOf(menuItem.getSales()));
        return convertView;
    }


}
