package com.atmo.database;

import com.atmo.model.Employee;

import java.util.Map;

public interface EmployeeDao {

    boolean addNewEmployee(final Employee employee);

    boolean deleteEmployee(final int employeeId);

    Map<Integer, Employee> getEmployees();

    boolean updateEmployeeDetails(final Employee employee);
}

