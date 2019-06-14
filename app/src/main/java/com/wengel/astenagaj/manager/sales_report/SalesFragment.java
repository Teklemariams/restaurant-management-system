package com.wengel.astenagaj.manager.sales_report;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.wengel.astenagaj.R;

public class SalesFragment extends Fragment {
    private TextView totalTv;
    private ListView saleseListView;


    public SalesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View salesRootView = inflater.inflate(R.layout.fragment_sales, container, false);
        totalTv = salesRootView.findViewById(R.id.salesReport_TotalTv);
        saleseListView = salesRootView.findViewById(R.id.salesReport_salesListView);
        return salesRootView;
    }
}
