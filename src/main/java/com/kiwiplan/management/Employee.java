package com.kiwiplan.management;

import java.util.List;

class Employee  {
    long empId;
    String name;
    long managerId;
    List<Employee> subordinates;

    public Employee(long empId, String name, long mId) {
        try {
            this.empId = empId;
            this.name = name;
            this.managerId = mId;
        }  catch (Exception e) {
            System.err.println("Exception creating employee:" + e);
        }
    }

    List<Employee> getSubordinates() {
        return subordinates;
    }

    void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    long getId() {
        return empId;
    }

    void setId(int id) {
        this.empId = id;
    }

    String getName() {
        return name;
    }

    void setName(String n) {
        name = n;
    }

    long getManagerId() {
        return managerId;
    }




}

