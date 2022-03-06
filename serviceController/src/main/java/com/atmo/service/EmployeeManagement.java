package com.atmo.service;

import com.atmo.model.Employee;

import java.util.Map;

/**
 * Used to add new employee by using employee id, view all employees, delete an employee data by
 * using employee id, and update by using employee.
 */
public interface EmployeeManagement {

    boolean addNewEmployee(final Employee employee);

    Map<Integer, Employee> getEmployees();

    boolean deleteEmployee(final int employeeId);

    boolean updateEmployeeDetails(final Employee employee);
}
