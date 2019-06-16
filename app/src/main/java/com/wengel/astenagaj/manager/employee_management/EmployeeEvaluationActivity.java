package com.wengel.astenagaj.manager.employee_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.main_views.ManagerActivity;
import com.wengel.astenagaj.models.Employee;
import com.wengel.astenagaj.util.App;
import com.wengel.astenagaj.util.Constants;

import java.util.ArrayList;

public class EmployeeEvaluationActivity extends AppCompatActivity {

    App app;
    private Button okBtn;
    private EditText efficEt;
    private double efficiency;
    private int employeeId;
    private Intent intent;
    private Bundle bundle;
    Employee employeeToEvaluate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_evaluation);
        app = (App) getApplication();
        intent = getIntent();
        bundle = intent.getExtras();
        efficEt = findViewById(R.id.evaluatiing_efficET);
        okBtn = findViewById(R.id.evaluatiing_OkBtn);
        employeeId = bundle.getInt(Constants.KEY_EMPLOYEE_EMPLOYEE_ID);
        employeeToEvaluate = new Employee();
        ArrayList<Employee> employees = app.getEmployeeController().getEmployees();
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                employeeToEvaluate = employee;
                break;
            }
        }

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeEvaluationActivity.this, ManagerActivity.class);
                efficiency = Double.parseDouble(String.valueOf(efficEt.getText()));
                employeeToEvaluate.setEfficiency(efficiency);
                Toast.makeText(EmployeeEvaluationActivity.this, "Evaluation Saved", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


    }
}
