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
import com.wengel.astenagaj.models.Employee;
import com.wengel.astenagaj.util.App;
import com.wengel.astenagaj.util.Constants;

import java.util.ArrayList;

public class EmployeeDetailActivity extends AppCompatActivity {
    private Intent intent1;
    private Bundle bundle1;
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
        intent1 = getIntent(); //this intent brings data from employees frag
        bundle1 = intent1.getExtras();
        app = (App) getApplication();


        nameTv = findViewById(R.id.employeDetail_name);
        ageTv = findViewById(R.id.employeDetail_age);
        employeeIdTv = findViewById(R.id.employeDetail_id);
        hireDateTv = findViewById(R.id.employeDetail_hireDate);
        efficiencyTv = findViewById(R.id.employeDetail_efficiency);
        jobTitleTv = findViewById(R.id.employeDetail_title);
        evaluateBtn = findViewById(R.id.employeDetail_evaluateBtn);
        fireBtn = findViewById(R.id.employeDetail_fireBtn);

        name = bundle1.getString(Constants.KEY_EMPLOYEE_NAMESPACE);
        age = bundle1.getInt(Constants.KEY_EMPLOYEE_AGE);
        employeeId = bundle1.getInt(Constants.KEY_EMPLOYEE_EMPLOYEE_ID);
        hireDate = bundle1.getString(Constants.KEY_EMPLOYEE_HIREDATE);
        efficiency = bundle1.getDouble(Constants.KEY_EMPLOYEE_EFFICIENCY);
        jobTitle = bundle1.getString(Constants.KEY_EMPLOYEE_JOB_TITLE);


        nameTv.setText(name);
        ageTv.setText(String.valueOf(age));
        employeeIdTv.setText(String.valueOf(employeeId));
        hireDateTv.setText(hireDate);
        efficiencyTv.setText(String.valueOf(efficiency));
        jobTitleTv.setText(jobTitle);

        evaluateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this intent takes data to EmployeeEvaluationActivity
                Intent intent2 = new Intent(EmployeeDetailActivity.this, EmployeeEvaluationActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putInt(Constants.KEY_EMPLOYEE_EMPLOYEE_ID, employeeId);
                intent2.putExtras(bundle2);
                startActivity(intent2);
            }
        });

        fireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee employeeToDelete = new Employee();
                ArrayList<Employee> employees = app.getEmployeeController().getEmployees();
                for (Employee employee : employees) {
                    if (employee.getEmployeeId() == employeeId) {
                        employeeToDelete = employee;
                    }
                }
                app.getEmployeeController().deleteEmployee(employeeToDelete);
                Toast.makeText(EmployeeDetailActivity.this, "Employee fired succesfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(EmployeeDetailActivity.this, ManagerActivity.class));
            }
        });


    }
}
