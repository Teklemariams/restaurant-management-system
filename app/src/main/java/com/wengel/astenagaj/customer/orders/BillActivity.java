package com.wengel.astenagaj.customer.orders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.customer.menus.AddOrderActivity;
import com.wengel.astenagaj.customer.menus.AddedOrdersAdapter;
import com.wengel.astenagaj.main_views.CustomerActivity;
import com.wengel.astenagaj.models.Order;
import com.wengel.astenagaj.util.App;

import java.util.ArrayList;

public class BillActivity extends AppCompatActivity {

    private ListView priceListlistView;
    private ArrayList<Order> pricedOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        priceListlistView = findViewById(R.id.priced_orders_list_view);
        final App app = (App) getApplication();

        //data
        pricedOrders = new ArrayList<>();
        pricedOrders = app.getOrderController().getOrders();
        //adapter
        PricedOrdersAdapter<Order> adpater = new PricedOrdersAdapter<>(this, pricedOrders);
        priceListlistView.setAdapter(adpater);


    }
}
