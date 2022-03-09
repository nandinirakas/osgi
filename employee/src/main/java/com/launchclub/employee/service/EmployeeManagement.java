package com.launchclub.employee.service;

import com.launchclub.employee.model.Employee;

import java.util.Map;

public interface EmployeeManagement {

    boolean addNewEmployee(final Employee employee);

    Map<Integer, Employee> getEmployees();

    boolean deleteEmployee(final int employeeId);

    boolean updateEmployeeDetails(final Employee employee);
}
