package com.wengel.astenagaj.manager.employee_management;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.main_views.ManagerActivity;
import com.wengel.astenagaj.models.Employee;
import com.wengel.astenagaj.util.App;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNewEmployeeActivity extends AppCompatActivity {

    private EditText nameEt, ageEt, jobTitleEt, employeIdEd;
    private Button hireBtn;
    private String name;
    private int age;
    private int employeeId;
    private String hireDate;
    private double efficiency;
    private String jobTitle;
    App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_employee);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nameEt = findViewById(R.id.hiring_nameEt);
        ageEt = findViewById(R.id.hiring_ageEt);
        jobTitleEt = findViewById(R.id.hiring_titleEt);
        employeIdEd = findViewById(R.id.hiring_idEt);
        hireBtn = findViewById(R.id.hiring_hireBtn);


        hireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNewEmployeeActivity.this, ManagerActivity.class);
                name = nameEt.getText().toString();
                age = Integer.parseInt(ageEt.getText().toString());
                jobTitle = jobTitleEt.getText().toString();
                employeeId = Integer.parseInt(employeIdEd.getText().toString());

                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                String publicDate = dateFormat.format(date);
                hireDate = String.valueOf(publicDate);

                Employee newEmployee = new Employee(name, age, employeeId, hireDate, 0, jobTitle);
                app = (App) getApplication();
                app.getEmployeeController().addEmployee(newEmployee);

                Toast.makeText(AddNewEmployeeActivity.this, "Employee hired !! ", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });


    }
}
