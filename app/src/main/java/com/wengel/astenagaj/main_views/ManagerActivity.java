package com.wengel.astenagaj.main_views;

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

public class ManagerActivity extends AppCompatActivity {
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_foodmenu:
                        getSupportActionBar().setTitle("Menus");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container,
                                        new MenusFragment()).commit();
                        break;
                    case R.id.navigation_orders:
                        getSupportActionBar().setTitle("Orders");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container,
                                        new OrdersFragment()).commit();
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
                                        new SalesFragment());
                        break;

                    // to be implemented later
//                    case R.id.aboout_us:
//                        startActivity(new Intent(ManagerActivity.this, AboutActivity.class));

                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_container,
//                        new HomeFragment()).commit();
        navigationView.setCheckedItem(R.id.navigation_foodmenu);

    }
}
