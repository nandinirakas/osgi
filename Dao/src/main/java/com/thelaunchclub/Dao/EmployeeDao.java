package com.thelaunchclub.Dao;

import java.util.Map;

import com.thelaunchclub.Model.Employee;

public interface EmployeeDao {

    boolean addNewEmployee(final Employee employee);
    
    boolean deleteEmployee(final int employeeId);
    
    Map<Integer, Employee> getEmployees();
    
    boolean updateEmployeeDetails(final Employee employee);
}
