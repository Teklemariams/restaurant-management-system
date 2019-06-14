package com.wengel.astenagaj.manager.sales_report;

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
import android.widget.TextView;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.customer.menus.MenuItemAdapter;
import com.wengel.astenagaj.customer.menus.TableAndQuantityActivity;
import com.wengel.astenagaj.models.MenuItem;
import com.wengel.astenagaj.models.Order;
import com.wengel.astenagaj.util.App;

import java.util.ArrayList;

public class SalesFragment extends Fragment {

    private ArrayList<MenuItem> soldMenuItems;
    private TextView totalTv;
    private ListView saleseListView;
    private App app;


    public SalesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View salesRootView = inflater.inflate(R.layout.fragment_sales, container, false);
        app = (App) getActivity().getApplication();
        totalTv = salesRootView.findViewById(R.id.salesReport_TotalTv);
        saleseListView = salesRootView.findViewById(R.id.salesReport_salesListView);

        //data
        soldMenuItems = new ArrayList<>();
        ArrayList<Order> submittedOrders = app.getOrderController().getSubmittedOrders();
        for (Order order : submittedOrders) {
            String orderStatus = order.getStatus();
            if (orderStatus.equals("paid")) {
                MenuItem soldMenuItem = order.getMenuItem();
                soldMenuItems.add(soldMenuItem);
            }
        }

//        localListPopulater();

//        getDataFromBackEnd();

        //adapter
        SalesAdapter<MenuItem> adapter = new SalesAdapter<>(getActivity(), soldMenuItems);
        saleseListView.setAdapter(adapter);

        return salesRootView;
    }
}
