package com.wengel.astenagaj.customer.orders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.pnikosis.materialishprogress.ProgressWheel;
import com.wengel.astenagaj.R;
import com.wengel.astenagaj.customer.menus.AddOrderActivity;
import com.wengel.astenagaj.customer.menus.AddedOrdersAdapter;
import com.wengel.astenagaj.customer.menus.MenuItemAdapter;
import com.wengel.astenagaj.customer.menus.TableAndQuantityActivity;
import com.wengel.astenagaj.models.MenuItem;
import com.wengel.astenagaj.models.Order;
import com.wengel.astenagaj.util.App;

import java.util.ArrayList;

public class OrdersFragment extends Fragment {
    ArrayList<Order> myOrders;
    ListView myOrdersListView;
    private ProgressWheel progressWheel;
    private TextView statusInfoLabel;
    private TextView totalPriceTv;
    private Button requestBillButton;
    private Button updateOrderButton;

//    private Bundle bundle = new Bundle();

    public OrdersFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myOrdersRootView = inflater.inflate(R.layout.fragment_orders, container, false);

//        progressWheel = menuRootView.findViewById(R.id.menu_progress_wheel);
//        statusInfoLabel = menuRootView.findViewById(R.id.menu_statusInfoLabel);
//        statusInfoLabel.setTextColor(getResources().getColor(R.color.green));
//        statusInfoLabel.setText("Loading menus");
        totalPriceTv = myOrdersRootView.findViewById(R.id.myOrders_totalPrice_label);
        requestBillButton = myOrdersRootView.findViewById(R.id.myOrders_requestbill_bn);
        updateOrderButton = myOrdersRootView.findViewById(R.id.myOrder_update_bn);

        updateOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddOrderActivity.class));
            }
        });
        //data
        myOrders = new ArrayList<>();
        App app = (App) getActivity().getApplication();
        myOrders = app.getOrderController().getOrders();

//        listFillerFromApi();

//        Toast.makeText(getActivity(), "Loading your orders ...", Toast.LENGTH_LONG).show();

//        listFillerFromApi();

        //view
        myOrdersListView = myOrdersRootView.findViewById(R.id.orders_list_view);
        //adapter
        MyOrdersAdapter<Order> adapter = new MyOrdersAdapter<>(getActivity(), myOrders);
        myOrdersListView.setAdapter(adapter);
        return myOrdersRootView;

    }


}
