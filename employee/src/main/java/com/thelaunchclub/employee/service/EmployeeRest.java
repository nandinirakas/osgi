package com.thelaunchclub.employee.service;

import com.thelaunchclub.employee.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRest {

    Map addNewEmployee(final Employee employee);

    List getEmployees(final int page, final int limit);

    Map deleteEmployee(final int employeeId);

    Map updateEmployeeDetails(final Employee employee);

    List selectEmployee(final int employeeId);
}
