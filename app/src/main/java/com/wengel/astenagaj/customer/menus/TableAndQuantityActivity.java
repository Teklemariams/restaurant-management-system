package com.wengel.astenagaj.customer.menus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.models.MenuItem;
import com.wengel.astenagaj.models.Order;
import com.wengel.astenagaj.util.App;

public class TableAndQuantityActivity extends AppCompatActivity {
    private Button continueButton;
    private Spinner mealQuantitySpinner;
    private Spinner tableNoSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_and_quantity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        continueButton = findViewById(R.id.tableno_continue_bn);
        mealQuantitySpinner = findViewById(R.id.customerMealQuantitySpinner);
        tableNoSpinner = findViewById(R.id.customerTableNoSpinner);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedPosition1 = tableNoSpinner.getSelectedItemPosition();
                int tableNo = selectedPosition1++;
                int selectedPosition2 = mealQuantitySpinner.getSelectedItemPosition();
                int mealQuantity = selectedPosition2 + 1;
                App app = (App) getApplication();
                //to get the last menu added -last foodItem selected
                int lastIndex = app.getMenuItemController().getMenus().size() - 1;
                MenuItem lastMenuItem = app.getMenuItemController().getMenus().get(lastIndex);
                Order order = new Order(lastMenuItem, mealQuantity, tableNo, " - ", "pending", false);
                app.getOrderController().addOrder(order);
                Intent intent = new Intent(TableAndQuantityActivity.this, AddOrderActivity.class);
                startActivity(intent);
            }
        });
    }
}
