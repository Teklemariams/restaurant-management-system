package com.wengel.astenagaj.manager.employee_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.main_views.ManagerActivity;
import com.wengel.astenagaj.util.App;

public class EmployeeEvaluationActivity extends AppCompatActivity {

    App app;
    private Button okBtn;
    private EditText efficEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_evaluation);
        app = (App) getApplication();
        efficEt = findViewById(R.id.evaluatiing_efficET);
        okBtn = findViewById(R.id.evaluatiing_OkBtn);

        double efficiency = Double.parseDouble(efficEt.getText().toString());
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeEvaluationActivity.this, ManagerActivity.class);
            }
        });


    }
}
