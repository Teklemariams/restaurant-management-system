package com.wengel.astenagaj.customer.menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.main_views.CustomerActivity;
import com.wengel.astenagaj.models.Order;
import com.wengel.astenagaj.util.App;

import java.util.ArrayList;

public class AddOrderActivity extends AppCompatActivity {
    private ListView addedOrderslistView;
    private Button addOrderButton;
    private Button cancelOrderButton;
    private Button orderButton;
    private ArrayList<Order> addedOrders;
    private ArrayList<Order> orders;
    private Spinner tableNoSpinner;

    Intent quantiyAndTableNoIntent;
    Bundle quantiyAndTableNoBundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        addedOrderslistView = findViewById(R.id.added_orders_list_view);
        addOrderButton = findViewById(R.id.addorder_add_bn);
        cancelOrderButton = findViewById(R.id.addorder_cancel_bn);
        orderButton = findViewById(R.id.addorder_order_bn);
        tableNoSpinner = findViewById(R.id.customerTableNoSpinner);

        quantiyAndTableNoIntent = getIntent();
        quantiyAndTableNoBundle = quantiyAndTableNoIntent.getExtras();

        //data
        addedOrders = new ArrayList<>();
//        orders = new ArrayList<>();
//        int tableNo = quantiyAndTableNoBundle.getInt(Constants.KEY_ORDER_TABLE_NO);
//        int mealQuantity = quantiyAndTableNoBundle.getInt(Constants.KEY_ORDER_QUANTITY);
        //adapter
        AddedOrdersAdapter<Order> adpater = new AddedOrdersAdapter<>(this, addedOrders);
        addedOrderslistView.setAdapter(adpater);

        addOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));
            }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO - to best sent to api
//                Intent i = new Intent(AddOrderActivity.this, CustomerActivity.class);
//                Bundle b = new Bundle();
//                b.putString(Constants.KEY_CUSTOMER_FRG_TO_LOAD, "Menus frag");
//                i.putExtras(b);
                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));
                Toast.makeText(AddOrderActivity.this, "Your Order is submitted", Toast.LENGTH_LONG).show();


            }
        });

        cancelOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App app = (App) getApplication();
                app.getOrderController().getOrders().clear();
                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addedOrderslistView = findViewById(R.id.added_orders_list_view);
        addOrderButton = findViewById(R.id.addorder_add_bn);
        cancelOrderButton = findViewById(R.id.addorder_cancel_bn);
        orderButton = findViewById(R.id.addorder_order_bn);
        quantiyAndTableNoIntent = getIntent();
        quantiyAndTableNoBundle = quantiyAndTableNoIntent.getExtras();

        //data
        addedOrders = new ArrayList<>();
//        orders = new ArrayList<>();
        final App app = (App) getApplication();
        addedOrders = app.getOrderController().getOrders();
        //adapter
        AddedOrdersAdapter<Order> adpater = new AddedOrdersAdapter<>(this, addedOrders);
        addedOrderslistView.setAdapter(adpater);

        addOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));
            }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO -- to best sent to api
                Toast.makeText(AddOrderActivity.this, "Your Order is submitted", Toast.LENGTH_LONG).show();
                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));

            }
        });
        cancelOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.getOrderController().getOrders().clear();
                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));

            }
        });


    }

}
