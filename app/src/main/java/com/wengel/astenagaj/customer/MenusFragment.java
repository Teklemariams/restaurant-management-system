package com.wengel.astenagaj.customer;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.pnikosis.materialishprogress.ProgressWheel;
import com.wengel.astenagaj.R;
import com.wengel.astenagaj.customer.menus.MenuItemAdapter;
import com.wengel.astenagaj.customer.menus.TableAndQuantityActivity;
import com.wengel.astenagaj.models.MenuItem;
import com.wengel.astenagaj.util.App;
import com.wengel.astenagaj.util.Constants;

import java.util.ArrayList;

public class MenusFragment extends Fragment {
    ArrayList<MenuItem> menus;
    ListView menusListView;
    private ProgressWheel progressWheel;
    private TextView statusInfoLabel;
//    private Bundle bundle = new Bundle();

    public MenusFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        return inflater.inflate(R.layout.fragment_menus, container, false);
        View menuRootView = inflater.inflate(R.layout.fragment_menus, container, false);

//        progressWheel = menuRootView.findViewById(R.id.menu_progress_wheel);
//        statusInfoLabel = menuRootView.findViewById(R.id.menu_statusInfoLabel);
//        statusInfoLabel.setTextColor(getResources().getColor(R.color.green));
//        statusInfoLabel.setText("Loading menus");

        //data
        menus = new ArrayList<>();

        localListPopulater();

//        Toast.makeText(getActivity(), "Loading menus ...", Toast.LENGTH_LONG).show();

//        listFillerFromApi();

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
//                bundle.putString(Constants.KEY_MENUITEM_NAME_SPACE, menu.getName());
//                bundle.putDouble(Constants.KEY_MENUITEM_PRICE, menu.getPrice());
//                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return menuRootView;
    }

    private void localListPopulater() {
        menus.add(new MenuItem("Beyaynet", 30.00));
        menus.add(new MenuItem("Tibs", 30.00));
        menus.add(new MenuItem("Firfir", 30.00));
        menus.add(new MenuItem("Firfir", 30.00));
        menus.add(new MenuItem("Firfir", 30.00));
        menus.add(new MenuItem("Firfir", 30.00));
        menus.add(new MenuItem("Firfir", 30.00));
        menus.add(new MenuItem("Firfir", 30.00));
        menus.add(new MenuItem("Firfir", 30.00));
    }

}
