package com.wengel.astenagaj.customer.menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.main_views.CustomerActivity;
import com.wengel.astenagaj.models.Order;
import com.wengel.astenagaj.util.App;

import java.util.ArrayList;

public class AddOrderActivity extends AppCompatActivity {
    private ListView addedOrderslistView;
    private Button addOrderButton;
    private Button cancelOrderButton;
    private Button orderButton;
    private ArrayList<Order> orders;
    private ArrayList<Order> submittedOrders;
    App app;

    private Spinner tableNoSpinner;

    Intent quantiyAndTableNoIntent;
    Bundle quantiyAndTableNoBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
        app = (App) getApplication();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addedOrderslistView = findViewById(R.id.added_orders_listView);
        addOrderButton = findViewById(R.id.addorder_add_bn);
        cancelOrderButton = findViewById(R.id.addorder_cancel_bn);
        orderButton = findViewById(R.id.addorder_order_bn);
        tableNoSpinner = findViewById(R.id.customerTableNoSpinner);

        quantiyAndTableNoIntent = getIntent();
        quantiyAndTableNoBundle = quantiyAndTableNoIntent.getExtras();
//        submittedOrders = new ArrayList<>();

        //data
//        orders = new ArrayList<>();
        orders = app.getOrderController().getOrders();
        submittedOrders = app.getOrderController().getSubmittedOrders(); //those orders that are submitted
        //adapter
        AddedOrdersAdapter<Order> adapter = new AddedOrdersAdapter<>(this, orders);
        addedOrderslistView.setAdapter(adapter);

        addOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));
            }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lastIndex = app.getOrderController().getOrders().size() - 1;
                Order lastOrder = app.getOrderController().getOrders().get(lastIndex);
                int lastSelectedTable = lastOrder.getTableNo();
                for (int i = 0; i < orders.size(); i++) {
                    if (orders.get(i).getTableNo() == lastSelectedTable) {
                        app.getOrderController().addSubmittedOrder(orders.get(i));
                    } else {
                        app.getOrderController().deleteSubmittedOrder(i);
                    }
                }
                //TODO - to be sent to api
//                sendOrderToBackEnd();

                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));
                Toast.makeText(AddOrderActivity.this, "Your Order is submitted", Toast.LENGTH_LONG).show();
            }
        });

        cancelOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.getOrderController().getOrders().clear();
                app.getOrderController().getSubmittedOrders().clear();
                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));

            }
        });
    }

//    private void sendOrderToBackEnd() {
//        if (AddOrderActivity.this != null) {
//            AddOrderActivity.this.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(AddOrderActivity.this, "Sending order", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        } else return;
//        //Create the client
//        OkHttpClient client = new OkHttpClient();
//
//        //create attractionRequest
//        Request orderRequest = new Request.Builder().url("https://astenagaj.zematechs.com/api/order/create").build();
//
//        //calling the attractionRequest
//        client.newCall(orderRequest).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
////                showStatus(false);
//                if (AddOrderActivity.this != null) {
//                    AddOrderActivity.this.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(AddOrderActivity.this, "Pleasse retry", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                } else return;
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//                String menuJson = response.body().string();
//
//                if (response.isSuccessful()) {
//                    try {
//                        JSONObject rootJSONonj = new JSONObject(menuJson);
//                        JSONArray rootJSONarray = rootJSONonj.getJSONArray("data");
//                        for (int i = 0; i < rootJSONarray.length(); i++) {
//                            JSONObject menuItem = rootJSONarray.getJSONObject(i);
//                            String name = menuItem.getString("name");
//                            double price = menuItem.getDouble("price");
//                            int quantitySold = menuItem.getInt("quantity_sold");
////                            showStatus(true);
//                            if (AddOrderActivity.this != null) {
//                                AddOrderActivity.this.runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Toast.makeText(AddOrderActivity.this, "Order sent succesfully", Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//
//                            } else return;
//
//
//                            menus.add(new MenuItem(name, menuItemImage, price, quantitySold));
//
//                        }
//                        Activity activity = getActivity();
//                        if (activity != null) {
//                            activity.runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    //adapter
//                                    MenuItemAdapter<MenuItem> adapter = new MenuItemAdapter<>(getActivity(), menus);
//                                    menusListView.setAdapter(adapter);
//                                }
//                            });
//
//                        } else return;
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
////                        showStatus(false);
//
//                    }
//                } else {
////                    showStatus(false);
//                }
//            }
//        });
//
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        app = (App) getApplication();
//
//        addedOrderslistView = findViewById(R.id.added_orders_listView);
//        addOrderButton = findViewById(R.id.addorder_add_bn);
//        cancelOrderButton = findViewById(R.id.addorder_cancel_bn);
//        orderButton = findViewById(R.id.addorder_order_bn);
//        quantiyAndTableNoIntent = getIntent();
//        quantiyAndTableNoBundle = quantiyAndTableNoIntent.getExtras();
//
//        //data
////        orders = new ArrayList<>();
//        orders = app.getOrderController().getOrders();
//        submittedOrders = app.getOrderController().getSubmittedOrders(); //those orders that are submitted
//        //adapter
//        AddedOrdersAdapter<Order> adpater = new AddedOrdersAdapter<>(this, orders);
//        addedOrderslistView.setAdapter(adpater);
//
//        addOrderButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));
//            }
//        });
//        orderButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int lastIndex = app.getOrderController().getOrders().size() - 1;
//                Order lastOrder = app.getOrderController().getOrders().get(lastIndex);
//                int lastSelectedTable = lastOrder.getTableNo();
//                for (int i = 0; i < orders.size(); i++) {
//                    if (orders.get(i).getTableNo() == lastSelectedTable) {
//                        app.getOrderController().addSubmittedOrder(orders.get(i));
//                    } else {
//                        app.getOrderController().deleteSubmittedOrder(i);
//                    }
//                }
//                //TODO - to best sent to api
////                Intent i = new Intent(AddOrderActivity.this, CustomerActivity.class);
////                Bundle b = new Bundle();
////                b.putString(Constants.KEY_CUSTOMER_FRG_TO_LOAD, "Menus frag");
////                i.putExtras(b);
//                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));
//                Toast.makeText(AddOrderActivity.this, "Your Order is submitted", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        cancelOrderButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                app.getOrderController().getOrders().clear();
//                app.getOrderController().getSubmittedOrders().clear();
//                startActivity(new Intent(AddOrderActivity.this, CustomerActivity.class));
//
//            }
//        });
//    }
}