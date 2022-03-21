package com.thelaunchclub.employee.controller;

import com.thelaunchclub.employee.model.Employee;

import java.util.List;

public interface EmployeeRestController {

    boolean addNewEmployee(final Employee employee);

    List<Employee> getEmployeesDetails(final int start, final int size);

    boolean deleteEmployee(final int employeeId);

    boolean updateEmployeeDetails(final Employee employee);

    String getString();
}
