package com.wengel.astenagaj.main_views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wengel.astenagaj.R;

public class WelcomeActivity extends AppCompatActivity {
    private Button continueCustomerBtn;
    private Button continueManagerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        continueCustomerBtn = findViewById(R.id.welcome_customerBtn);
        continueManagerBtn = findViewById(R.id.welcome_managerBtn);

        continueCustomerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, CustomerActivity.class));
            }
        });
        continueManagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, ManagerActivity.class));
            }
        });


    }
}
