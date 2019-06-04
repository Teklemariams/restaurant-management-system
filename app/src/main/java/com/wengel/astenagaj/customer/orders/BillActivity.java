package com.wengel.astenagaj.customer.orders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.models.Order;
import com.wengel.astenagaj.util.App;

import java.util.ArrayList;

public class BillActivity extends AppCompatActivity {

    private ListView priceListlistView;
    private ArrayList<Order> pricedOrders;
    private TextView totalBillTextV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        priceListlistView = findViewById(R.id.billed_orders_list_view);
        totalBillTextV = findViewById(R.id.totalBilledAmount_tv);
        final App app = (App) getApplication();

        double ordersTotalPrices = app.getOrderController().getOrdersTotalPrice();
        totalBillTextV.setText(String.valueOf(ordersTotalPrices + "Br"));

        //data
        pricedOrders = new ArrayList<>();
        pricedOrders = app.getOrderController().getOrders();
        //adapter
        BilledOrdersAdapter<Order> adpater = new BilledOrdersAdapter<>(this, pricedOrders);
        priceListlistView.setAdapter(adpater);


    }
}
