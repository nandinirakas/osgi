package com.thelaunchclub.employee.dao;

import com.thelaunchclub.employee.model.Employee;

import java.util.Map;

public interface EmployeeDao {

    boolean addNewEmployee(final Employee employee);

    boolean deleteEmployee(final int employeeId);

    Map<Integer, Employee> getEmployees();

    boolean updateEmployeeDetails(final Employee employee);
}
