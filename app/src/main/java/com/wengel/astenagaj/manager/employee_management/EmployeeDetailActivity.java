package com.wengel.astenagaj.manager.employee_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.main_views.ManagerActivity;
import com.wengel.astenagaj.manager.order_management.OrderDetailActivity;
import com.wengel.astenagaj.models.Employee;
import com.wengel.astenagaj.util.App;
import com.wengel.astenagaj.util.Constants;

import java.util.ArrayList;

public class EmployeeDetailActivity extends AppCompatActivity {
    private Intent intent;
    private Bundle bundle;
    private String name;
    private int age;
    private int employeeId;
    private String hireDate;
    private double efficiency;
    private String jobTitle;
    private TextView nameTv;
    private TextView ageTv;
    private TextView employeeIdTv;
    private TextView hireDateTv;
    private TextView efficiencyTv;
    private TextView jobTitleTv;
    private Button evaluateBtn;
    private Button fireBtn;
    App app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);
        intent = getIntent();
        bundle = intent.getExtras();
        app = (App) getApplication();


        nameTv = findViewById(R.id.employeDetail_name);
        ageTv = findViewById(R.id.employeDetail_age);
        employeeIdTv = findViewById(R.id.employeDetail_id);
        hireDateTv = findViewById(R.id.employeDetail_hireDate);
        efficiencyTv = findViewById(R.id.employeDetail_efficiency);
        jobTitleTv = findViewById(R.id.employeDetail_title);
        evaluateBtn = findViewById(R.id.employeDetail_evaluateBtn);
        fireBtn = findViewById(R.id.employeDetail_fireBtn);

        name = bundle.getString(Constants.KEY_EMPLOYEE_NAMESPACE);
        age = bundle.getInt(Constants.KEY_EMPLOYEE_AGE);
        employeeId = bundle.getInt(Constants.KEY_EMPLOYEE_EMPLOYEE_ID);
        hireDate = bundle.getString(Constants.KEY_EMPLOYEE_HIREDATE);
        efficiency = bundle.getDouble(Constants.KEY_EMPLOYEE_EFFICIENCY);
        jobTitle = bundle.getString(Constants.KEY_EMPLOYEE_JOB_TITLE);


        nameTv.setText(name);
        ageTv.setText(String.valueOf(age));
        employeeIdTv.setText(String.valueOf(employeeId));
        hireDateTv.setText(hireDate);
        efficiencyTv.setText(String.valueOf(efficiency));
        jobTitleTv.setText(jobTitle);

        evaluateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee employeeToEvaluate = new Employee();
                startActivity(new Intent(EmployeeDetailActivity.this, EmployeeEvaluationActivity.class));
            }
        });
        fireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee employeeToDelete = new Employee();
                ArrayList<Employee> employees = app.getEmployeeController().getEmployees();
                for (Employee emplyee : employees) {
                    if (emplyee.getEmployeeId() == employeeId) {
                        employeeToDelete = emplyee;
                    }
                }
                app.getEmployeeController().deleteEmployee(employeeToDelete);
                Toast.makeText(EmployeeDetailActivity.this, "Employee fired succesfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(EmployeeDetailActivity.this, ManagerActivity.class));
            }
        });


    }
}
