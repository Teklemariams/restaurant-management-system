package com.wengel.astenagaj.customer.menus;

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
