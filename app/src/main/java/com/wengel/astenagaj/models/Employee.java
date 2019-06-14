package com.wengel.astenagaj.models;

import java.util.Date;


public class Employee {
    private String name;
    private int age;
    private int employeeId;
    private String hireDate;
    private double efficiency;
    private String jobTitle;

    public Employee() {
    }

    public Employee(String name, int age, int employeeId, String hireDate, double efficiency, String jobTitle) {
        this.name = name;
        this.age = age;
        this.employeeId = employeeId;
        this.hireDate = hireDate;
        this.efficiency = efficiency;
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
