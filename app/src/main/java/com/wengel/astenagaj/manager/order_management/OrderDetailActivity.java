package com.wengel.astenagaj.manager.order_management;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.main_views.ManagerActivity;
import com.wengel.astenagaj.models.Order;
import com.wengel.astenagaj.util.App;
import com.wengel.astenagaj.util.Constants;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {
    private Intent intent;
    private Bundle bundle;
    private ListView ordersInaTablelistView;
    private ArrayList<Order> submittedOrders;
    private ArrayList<Order> ordersInaTable;
    private TextView tableNo;
    private ListView ordersListView;
    private Button okButton;
    private Spinner waiterSpinner;
    private Spinner statusSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        intent = getIntent();
        bundle = intent.getExtras();
        App app = (App) getApplication();
        ordersInaTablelistView = findViewById(R.id.orderDetail_listView);
        tableNo = findViewById(R.id.orderDetail_tableno_tv);
        int tappedTableNo = bundle.getInt(Constants.KEY_ORDER_TABLE_NO);
        tableNo.setText(String.valueOf(tappedTableNo));
        waiterSpinner = findViewById(R.id.orderDetail_waiterSpinner);
        statusSpinner = findViewById(R.id.orderDetail_statusSpinner);
        ordersListView = findViewById(R.id.orderDetail_listView);
        okButton = findViewById(R.id.orderDetail_okBtn);
        Toast.makeText(OrderDetailActivity.this, "Tapped table" + tappedTableNo, Toast.LENGTH_LONG).show();

        submittedOrders = new ArrayList<>();
        ordersInaTable = new ArrayList<>();
        submittedOrders = app.getOrderController().getSubmittedOrders();
        --tappedTableNo;
        for (Order order : submittedOrders) {
            if (order.getTableNo() == tappedTableNo) {
                ordersInaTable.add(order);
            }
        }

        OrdersInaTableAdapter<Order> adapter = new OrdersInaTableAdapter<>(OrderDetailActivity.this, ordersInaTable);
        ordersInaTablelistView.setAdapter(adapter);




        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailActivity.this, ManagerActivity.class));
            }
        });


    }
}
