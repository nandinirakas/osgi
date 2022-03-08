package com.launchclub.service;

import com.launchclub.model.Employee;

import java.util.Map;

public interface EmployeeManagement {

    boolean addNewEmployee(final Employee employee);

    Map<Integer, Employee> getEmployees();

    boolean deleteEmployee(final int employeeId);

    boolean updateEmployeeDetails(final Employee employee);
}
