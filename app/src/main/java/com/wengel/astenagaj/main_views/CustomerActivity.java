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
import com.wengel.astenagaj.customer.CommentFragment;
import com.wengel.astenagaj.customer.MenusFragment;
import com.wengel.astenagaj.customer.OrdersFragment;

public class CustomerActivity extends AppCompatActivity {
    private DrawerLayout customerDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        Toolbar customerToolbar = findViewById(R.id.customerToolbar);
        setSupportActionBar(customerToolbar);
        customerDrawer = findViewById(R.id.customerDrawer_layout);
        NavigationView customerNavigationView = findViewById(R.id.customerNav_view);
        customerNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_foodmenu:
                        getSupportActionBar().setTitle("Menus");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container,
                                        new CommentFragment()).commit();
                        break;
                    case R.id.navigation_myOrders:
                        getSupportActionBar().setTitle("My orders");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container,
                                        new OrdersFragment()).commit();
                        break;
                    case R.id.navigation_comment:
                        getSupportActionBar().setTitle("My comment");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container,
                                        new CommentFragment()).commit();
                        break;

                    // to be implemented later
//                    case R.id.aboout_us:
//                        startActivity(new Intent(ManagerActivity.this, AboutActivity.class));

                }
                customerDrawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, customerDrawer, customerToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        customerDrawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,
                        new MenusFragment()).commit();
        customerNavigationView.setCheckedItem(R.id.navigation_foodmenu);

    }

}
