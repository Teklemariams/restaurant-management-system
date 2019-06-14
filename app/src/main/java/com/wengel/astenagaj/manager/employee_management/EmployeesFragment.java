package com.wengel.astenagaj.manager.employee_management;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.models.Employee;
import com.wengel.astenagaj.models.MenuItem;
import com.wengel.astenagaj.util.App;
import com.wengel.astenagaj.util.Constants;

import java.util.ArrayList;

public class EmployeesFragment extends Fragment {
    public EmployeesFragment() {

    }
    private ArrayList<Employee> employees;
    private ListView employeesListView;
    private Intent intent;
    private Bundle bundle;
    private FloatingActionButton floatingActionButton;
    private App app;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        App app = (App) getActivity().getApplication();
        final View menuRootView = inflater.inflate(R.layout.fragment_employees, container, false);
        bundle = new Bundle();
        //data
        employees = new ArrayList<>();


//        if (employees.size() == 0) {
//            localListPopulater();
//        }
        employees = app.getEmployeeController().getEmployees();


        Toast.makeText(getActivity(), "Loading employees ...", Toast.LENGTH_SHORT).show();

//        getDataFromBackEnd();
        floatingActionButton = menuRootView.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddNewEmployeeActivity.class));
            }
        });

        //view
        employeesListView = menuRootView.findViewById(R.id.employees_listView);
        //adapter
        EmployeeAdapter<Employee> adapter = new EmployeeAdapter<>(getActivity(), employees);
        employeesListView.setAdapter(adapter);
        employeesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Employee employee = employees.get(position);
                intent = new Intent(view.getContext(), EmployeeDetailActivity.class);

                bundle.putString(Constants.KEY_EMPLOYEE_NAMESPACE, employee.getName());
                bundle.putInt(Constants.KEY_EMPLOYEE_AGE, employee.getAge());
                bundle.putInt(Constants.KEY_EMPLOYEE_EMPLOYEE_ID, employee.getEmployeeId());
                bundle.putString(Constants.KEY_EMPLOYEE_HIREDATE, employee.getHireDate());
                bundle.putDouble(Constants.KEY_EMPLOYEE_EFFICIENCY, employee.getEfficiency());
                bundle.putString(Constants.KEY_EMPLOYEE_JOB_TITLE, employee.getJobTitle());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        return menuRootView;
    }
//    private void getDataFromBackEnd() {
//        Activity activity = getActivity();
//        if (activity != null) {
//            getActivity().runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(getActivity(), "Loading employees", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        } else return;
//        //Create the client
//        OkHttpClient client = new OkHttpClient();
//
//        //create attractionRequest
//        Request menuRequest = new Request.Builder().url("https://astenagaj.zematechs.com/api/menu-item/get").build();
//
//        //calling the attractionRequest
//        client.newCall(menuRequest).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
////                showStatus(false);
//                Activity activity = getActivity();
//                if (activity != null) {
//                    getActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getActivity(), "Please retry", Toast.LENGTH_SHORT).show();
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
////
//                            int menuItemImage = R.drawable.beyaynet;
//                            switch (name) {
//                                case "Shiro":
//                                    menuItemImage = R.drawable.shiro;
//                                    break;
//                                case "Beyaynet":
//                                    menuItemImage = R.drawable.beyaynet;
//                                    break;
//                                case "Firfir":
//                                    menuItemImage = R.drawable.firfir;
//                                    break;
//                                case "Suf fitfit":
//                                    menuItemImage = R.drawable.suf_fitfit;
//                                    break;
//                                case "Kikil":
//                                    menuItemImage = R.drawable.kikil;
//                                    break;
//                                case "Tibs":
//                                    menuItemImage = R.drawable.tibs;
//                                    break;
//                                case "Bozena":
//                                    menuItemImage = R.drawable.bozena;
//                                    break;
//                                case "Siga firfir":
//                                    menuItemImage = R.drawable.tibs_firfir;
//                                    break;
//                                case "Dulet":
//                                    menuItemImage = R.drawable.dulet;
//                                    break;
//                                case "Key Wot":
//                                    menuItemImage = R.drawable.key_wot;
//                                    break;
//                                case "Tea":
//                                    menuItemImage = R.drawable.shay;
//                                    break;
//                                case "Coffee":
//                                    menuItemImage = R.drawable.cofee;
//                                    break;
//                                case "Yejebena buna":
//                                    menuItemImage = R.drawable.yejebena_buna;
//                                    break;
//                                case "Espris":
//                                    menuItemImage = R.drawable.espris;
//                                    break;
//                                case "Makiato":
//                                    menuItemImage = R.drawable.makiato;
//                                    break;
//                                case "Wetet":
//                                    menuItemImage = R.drawable.milk;
//                                    break;
//                                case "Kishir(Ginjer tea)":
//                                    menuItemImage = R.drawable.kishir;
//                                    break;
//                                case "Yetsom makiato":
//                                    menuItemImage = R.drawable.makiato;
//                                    break;
//                                case "Enkulal Sandwich":
//                                    menuItemImage = R.drawable.enkulal_andwich;
//                                    break;
//                                case "Ful":
//                                    menuItemImage = R.drawable.ful;
//                                    break;
//                            }
//                            employees.add(new MenuItem(name, menuItemImage, price, quantitySold));
//                        }
//                        Activity activity = getActivity();
//                        if (activity != null) {
//                            activity.runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    //adapter
//                                    MenuItemAdapter<MenuItem> adapter = new MenuItemAdapter<>(getActivity(), employees);
//                                    employeesListView.setAdapter(adapter);
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
//    }

//    private void localListPopulater() {
//        employees.add(new Employee("Tigist", 23, 1, "02/02/2012", 98, "Waiter"));
//        employees.add(new Employee("Gemechu", 23, 01, "02/02/2012", 98, "Waiter"));
//        employees.add(new Employee("Abebe", 23, 01, "02/02/2012", 98, "Waiter"));
//        employees.add(new Employee("Haftom", 23, 01, "02/02/2012", 98, "Waiter"));
//        employees.add(new Employee("Betelhem", 23, 01, "02/02/2012", 98, "Waiter"));
//        employees.add(new Employee("Azeb", 23, 01, "02/02/2012", 98, "Waiter"));
//        employees.add(new Employee("Worke", 23, 01, "02/02/2012", 98, "Waiter"));
//        employees.add(new Employee("Tigist", 23, 01, "02/02/2012", 98, "Waiter"));
//        employees.add(new Employee("Tigist", 23, 01, "02/02/2012", 98, "Waiter"));
//        employees.add(new Employee("Tigist", 23, 01, "02/02/2012", 98, "Waiter"));
//        employees.add(new Employee("Tigist", 23, 01, "02/02/2012", 98, "Waiter"));
//
//        app = (App) getActivity().getApplication();
//        app.getEmployeeController().setEmployees(employees);
//
//    }
}
