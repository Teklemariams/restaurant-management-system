package com.wengel.astenagaj.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import com.wengel.astenagaj.R;
import com.wengel.astenagaj.customer.menus.AddedMenusAdapter;
import com.wengel.astenagaj.main_views.CustomerActivity;
import com.wengel.astenagaj.models.MenuItem;
import com.wengel.astenagaj.util.App;
import java.util.ArrayList;

public class AddOrderActivity extends AppCompatActivity {
    private ListView addedOrderslistView;
    private Button addOrderButton;
    private Button cancelOrderButton;
    private Button orderButton;
    ArrayList<MenuItem> addedMenus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        addedOrderslistView = findViewById(R.id.added_orders_list_view);
        addOrderButton = findViewById(R.id.addorder_add_bn);
        cancelOrderButton = findViewById(R.id.addorder_cancel_bn);
        orderButton = findViewById(R.id.addorder_order_bn);
        //data
        addedMenus = new ArrayList<>();
        //adapter
        AddedMenusAdapter<MenuItem> adpater = new AddedMenusAdapter<>(this, addedMenus);
        addedOrderslistView.setAdapter(adpater);

        addOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });


        cancelOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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
        //data
        addedMenus = new ArrayList<>();
        App app = (App) getApplication();
        addedMenus = app.getMenuItemController().getMenus();
        //adapter
        AddedMenusAdapter<MenuItem> adpater = new AddedMenusAdapter<>(this, addedMenus);
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
                //TODO
            }
        });
        cancelOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));
            }
        });



    }

}
