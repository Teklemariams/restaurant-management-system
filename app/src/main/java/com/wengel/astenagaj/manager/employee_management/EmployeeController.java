package com.wengel.astenagaj.manager.employee_management;

import com.wengel.astenagaj.models.Employee;

import java.util.ArrayList;

public class EmployeeController {
    private ArrayList<Employee> employees;

    public EmployeeController() {
        employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees()
    {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
