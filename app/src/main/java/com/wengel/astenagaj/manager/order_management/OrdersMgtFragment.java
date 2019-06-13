package com.wengel.astenagaj.manager.order_management;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.models.Order;
import com.wengel.astenagaj.util.App;
import com.wengel.astenagaj.util.Constants;

import java.util.ArrayList;

public class OrdersMgtFragment extends Fragment {
    private ArrayList<Order> submittedOrders;
    private ArrayList<Order> ordersByTable;
    private ListView ordersListView;

    private Intent intent;
    private Bundle bundle;


    public OrdersMgtFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bundle = new Bundle();
        App app = (App) getActivity().getApplication();
        View ordermgtRootView = inflater.inflate(R.layout.fragment_orders_mgt, container, false);

        //data
        submittedOrders = new ArrayList<>();
        ordersByTable = new ArrayList<>();
//        localListPopulater();
        submittedOrders = app.getOrderController().getSubmittedOrders();
        ArrayList<Integer> orderedTables = new ArrayList<>();
        for (Order order : submittedOrders) {
            if (!orderedTables.contains(order.getTableNo())) {
                orderedTables.add(order.getTableNo());
                ordersByTable.add(order);
            }
        }
//        Toast.makeText(getActivity(), "Loading menus ...", Toast.LENGTH_LONG).show();
//        listFillerFromApi();
        //view
        ordersListView = ordermgtRootView.findViewById(R.id.ordersmgt_list_view);
        //adapter
        ManagedOrdersAdapter<Order> adapter = new ManagedOrdersAdapter<>(getActivity(), ordersByTable);
        ordersListView.setAdapter(adapter);
        ordersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Order order = ordersByTable.get(position);
                int tappedTableNo = order.getTableNo();
                intent = new Intent(view.getContext(), OrderDetailActivity.class);
                bundle.putInt(Constants.KEY_ORDER_TABLE_NO, tappedTableNo + 1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return ordermgtRootView;
    }

}
