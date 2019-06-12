package com.wengel.astenagaj.manager.order_management;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.wengel.astenagaj.R;

public class OrderDetailActivity extends AppCompatActivity {
    private TextView tableNo;
    private TextView waiter;
    private TextView status;
    private ListView ordersListView;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        tableNo = findViewById(R.id.orderDetail_tableno_tv);
        waiter = findViewById(R.id.orderDetail_waiter_tv);
        status = findViewById(R.id.orderDetail_orderStatus_tv);
        ordersListView = findViewById(R.id.orderDetail_listView);
        okButton = findViewById(R.id.orderDetail_okBtn);






    }
}
