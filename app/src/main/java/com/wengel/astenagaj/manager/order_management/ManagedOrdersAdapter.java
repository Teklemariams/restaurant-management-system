package com.wengel.astenagaj.manager.order_management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.models.Order;
import com.wengel.astenagaj.util.App;

import java.util.ArrayList;

public class ManagedOrdersAdapter<Order> extends ArrayAdapter<Order> {
    private ArrayList<Order> orders;

    public ManagedOrdersAdapter(Context context, ArrayList<Order> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        App app = (App) getContext().getApplicationContext();
//        orders = new ArrayList<>();
//        orders = (ArrayList<Order>) app.getOrderController().getSubmittedOrders();
//        int lastIndex;
//        if (orders.size() >= 1) {
//            lastIndex = orders.size() - 1;
//            com.wengel.astenagaj.models.Order lastOrder = (com.wengel.astenagaj.models.Order) orders.get(lastIndex);
//            int lastSelectedTable = lastOrder.getTableNo();
//            Order order = orders.get(position);
//            if (order.  == lastSelectedTable){
//                app.getOrderController().addSubmittedOrder(orders.get(i));
//            } else{
//                app.getOrderController().deleteSubmittedOrder(i);
//            }
//        }
        final com.wengel.astenagaj.models.Order order = (com.wengel.astenagaj.models.Order) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_layout_managed_order, parent, false);
        }
        ImageView orderImageIv = convertView.findViewById(R.id.managed_orderimage_iv);
        TextView orderTableNoTv = convertView.findViewById(R.id.managed_order_tableno_tv);
        TextView orderWaiterNoTv = convertView.findViewById(R.id.managed_order_waiterno_tv);
        TextView orderStatusTv = convertView.findViewById(R.id.managed_order_status_tv);
        // data in to the views
        orderTableNoTv.setText(String.valueOf(order.getTableNo()));
        orderWaiterNoTv.setText(String.valueOf(order.getWaiterHandling()));
        orderStatusTv.setText(String.valueOf(order.getStatus()));
        orderImageIv.setImageResource(R.drawable.ic_ordermgt);
        return convertView;
    }


}
