package com.wengel.astenagaj.manager.sales_report;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wengel.astenagaj.R;

public class SalesReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_report);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
