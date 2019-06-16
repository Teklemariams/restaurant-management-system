package com.wengel.astenagaj.main_views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.manager.employee_management.EmployeesFragment;
import com.wengel.astenagaj.manager.MenusMgtFragment;
import com.wengel.astenagaj.manager.order_management.OrdersMgtFragment;
import com.wengel.astenagaj.manager.sales_report.SalesFragment;

public class ManagerActivity extends AppCompatActivity {
    private DrawerLayout mgrDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        Toolbar toolbar = findViewById(R.id.mgrToolbar);
        setSupportActionBar(toolbar);
        mgrDrawer = findViewById(R.id.manager_drawer_layout);
        NavigationView navigationView = findViewById(R.id.mgrNav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_orders:
                        getSupportActionBar().setTitle("Orders");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container,
                                        new OrdersMgtFragment()).commit();
                        break;
                    case R.id.navigation_employees:
                        getSupportActionBar().setTitle("Employees");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container,
                                        new EmployeesFragment()).commit();
                        break;
                    case R.id.navigation_sales:
                        getSupportActionBar().setTitle("Sales");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container,
                                        new SalesFragment()).commit();
                        break;


                    // to be implemented later
                    case R.id.aboout_us:
                        startActivity(new Intent(ManagerActivity.this, AboutManagerActivity.class));

                }
                mgrDrawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, mgrDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mgrDrawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,
                        new OrdersMgtFragment()).commit();
        navigationView.setCheckedItem(R.id.navigation_orders);

    }
}
