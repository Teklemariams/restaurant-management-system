package com.wengel.astenagaj.manager.employee_management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wengel.astenagaj.R;
import com.wengel.astenagaj.models.Employee;

import java.util.ArrayList;

public class EmployeeAdapter<Employee> extends ArrayAdapter<Employee> {


    public EmployeeAdapter(Context context, ArrayList<Employee> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final com.wengel.astenagaj.models.Employee employee = (com.wengel.astenagaj.models.Employee) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.employee_list_item, parent, false);
        }

        TextView employeeId = convertView.findViewById(R.id.employees_listitem_emplpyee_id);
        TextView employeeName = convertView.findViewById(R.id.employees_listitem_emplpyee_name);
        TextView employeeTitle = convertView.findViewById(R.id.employees_listitem_emplpyee_title);
        // data in to the views
        employeeId.setText(String.valueOf(employee.getEmployeeId()));
        employeeName.setText(String.valueOf(employee.getName()));
        employeeTitle.setText(String.valueOf(employee.getJobTitle()));
        return convertView;
    }


}
