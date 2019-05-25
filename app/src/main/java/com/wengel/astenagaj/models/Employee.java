package com.wengel.astenagaj.models;

import java.util.Date;
public class Employee {
    String name;
    int age;
    double employeeId;
    Date hireDate;
    double efficiency;
    String jobTitle;

    public Employee(String name, int age, double employeeId, Date hireDate, double efficiency,  String jobTitle) {
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

    public double getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(double employeeId) {
        this.employeeId = employeeId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
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