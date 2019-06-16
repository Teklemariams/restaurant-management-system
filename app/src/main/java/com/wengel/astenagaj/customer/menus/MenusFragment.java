package com.wengel.astenagaj.customer.menus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.pnikosis.materialishprogress.ProgressWheel;
import com.wengel.astenagaj.R;
import com.wengel.astenagaj.models.MenuItem;
import com.wengel.astenagaj.util.App;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MenusFragment extends Fragment {
    ArrayList<MenuItem> menus;
    ListView menusListView;

    public MenusFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View menuRootView = inflater.inflate(R.layout.fragment_menus, container, false);

        //data
        menus = new ArrayList<>();

//        localListPopulater();

        Toast.makeText(getActivity(), "Loading menus ...", Toast.LENGTH_LONG).show();

        getDataFromBackEnd();

        //view
        menusListView = menuRootView.findViewById(R.id.menus_list_view);
        //adapter
        MenuItemAdapter<MenuItem> adapter = new MenuItemAdapter<>(getActivity(), menus);
        menusListView.setAdapter(adapter);
        menusListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final MenuItem menu = menus.get(position);
                Intent intent = new Intent(view.getContext(), TableAndQuantityActivity.class);
                App app = (App) getActivity().getApplication();
                app.getMenuItemController().addMenuItem(menu);
                startActivity(intent);
            }
        });

        return menuRootView;
    }

    private void getDataFromBackEnd() {
        Activity activity = getActivity();
        if (activity != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity(), "Loading menus", Toast.LENGTH_SHORT).show();
                }
            });

        } else return;
        //Create the client
        OkHttpClient client = new OkHttpClient();

        //create attractionRequest
        Request menuRequest = new Request.Builder().url("https://astenagaj.zematechs.com/api/menu-item/get").build();

        //calling the attractionRequest
        client.newCall(menuRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
//                showStatus(false);
                Activity activity = getActivity();
                if (activity != null) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "Please retry", Toast.LENGTH_SHORT).show();
                        }
                    });

                } else return;

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String menuJson = response.body().string();

                if (response.isSuccessful()) {
                    try {
                        JSONObject rootJSONonj = new JSONObject(menuJson);
                        JSONArray rootJSONarray = rootJSONonj.getJSONArray("data");
                        for (int i = 0; i < rootJSONarray.length(); i++) {
                            JSONObject menuItem = rootJSONarray.getJSONObject(i);
                            String name = menuItem.getString("name");
                            double price = menuItem.getDouble("price");
                            int quantitySold = menuItem.getInt("quantity_sold");
//
                            int menuItemImage = R.drawable.beyaynet;
                            switch (name) {
                                case "Shiro":
                                    menuItemImage = R.drawable.shiro;
                                    break;
                                case "Beyaynet":
                                    menuItemImage = R.drawable.beyaynet;
                                    break;
                                case "Firfir":
                                    menuItemImage = R.drawable.firfir;
                                    break;
                                case "Suf fitfit":
                                    menuItemImage = R.drawable.suf_fitfit;
                                    break;
                                case "Kikil":
                                    menuItemImage = R.drawable.kikil;
                                    break;
                                case "Tibs":
                                    menuItemImage = R.drawable.tibs;
                                    break;
                                case "Bozena":
                                    menuItemImage = R.drawable.bozena;
                                    break;
                                case "Siga firfir":
                                    menuItemImage = R.drawable.tibs_firfir;
                                    break;
                                case "Dulet":
                                    menuItemImage = R.drawable.dulet;
                                    break;
                                case "Key Wot":
                                    menuItemImage = R.drawable.key_wot;
                                    break;
                                case "Tea":
                                    menuItemImage = R.drawable.shay;
                                    break;
                                case "Coffee":
                                    menuItemImage = R.drawable.cofee;
                                    break;
                                case "Yejebena buna":
                                    menuItemImage = R.drawable.yejebena_buna;
                                    break;
                                case "Espris":
                                    menuItemImage = R.drawable.espris;
                                    break;
                                case "Makiato":
                                    menuItemImage = R.drawable.makiato;
                                    break;
                                case "Wetet":
                                    menuItemImage = R.drawable.milk;
                                    break;
                                case "Kishir(Ginjer tea)":
                                    menuItemImage = R.drawable.kishir;
                                    break;
                                case "Yetsom makiato":
                                    menuItemImage = R.drawable.makiato;
                                    break;
                                case "Enkulal Sandwich":
                                    menuItemImage = R.drawable.enkulal_andwich;
                                    break;
                                case "Ful":
                                    menuItemImage = R.drawable.ful;
                                    break;
                                case "Anchote":
                                    menuItemImage = R.drawable.anchotte;
                                    break;
                            }
                            menus.add(new MenuItem(name, menuItemImage, price, quantitySold));
                        }
                        Activity activity = getActivity();
                        if (activity != null) {
                            activity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //adapter
                                    MenuItemAdapter<MenuItem> adapter = new MenuItemAdapter<>(getActivity(), menus);
                                    menusListView.setAdapter(adapter);
                                }
                            });

                        } else return;

                    } catch (JSONException e) {
                        e.printStackTrace();
//                        showStatus(false);

                    }
                } else {
//                    showStatus(false);
                }
            }
        });
    }

    private void localListPopulater() {
        menus.add(new MenuItem("Beyaynet", R.drawable.beyaynet, 40.00, 0));
        menus.add(new MenuItem("Shiro", R.drawable.shiro, 40.00, 0));
        menus.add(new MenuItem("Firfir", R.drawable.firfir, 35.00, 0));
        menus.add(new MenuItem("Suf fitfit", R.drawable.suf_fitfit, 35.00, 0));
        menus.add(new MenuItem("Kikil", R.drawable.kikil, 50.00, 0));
        menus.add(new MenuItem("Tibs", R.drawable.tibs, 50.00, 0));
        menus.add(new MenuItem("Bozena", R.drawable.bozena, 50.00, 0));
        menus.add(new MenuItem("Siga firfir", R.drawable.tibs_firfir, 45.00, 0));
        menus.add(new MenuItem("Dulet", R.drawable.dulet, 50.00, 0));
        menus.add(new MenuItem("Key Wot", R.drawable.key_wot, 50.00, 0));
        menus.add(new MenuItem("Tea", R.drawable.shay, 5.00, 0));
        menus.add(new MenuItem("Coffee", R.drawable.cofee, 5.00, 0));
        menus.add(new MenuItem("Yejebena buna", R.drawable.yejebena_buna, 5.00, 0));
        menus.add(new MenuItem("Espris ", R.drawable.espris, 5.00, 0));
        menus.add(new MenuItem("Makiato ", R.drawable.makiato, 7.00, 0));
        menus.add(new MenuItem("Wetet ", R.drawable.milk, 10.00, 0));
        menus.add(new MenuItem("Kishir(Ginjer tea)", R.drawable.kishir, 5.00, 0));

    }

}
