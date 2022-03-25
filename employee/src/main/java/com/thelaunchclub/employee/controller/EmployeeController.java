package com.thelaunchclub.employee.controller;

import com.thelaunchclub.employee.model.Employee;
import com.thelaunchclub.employee.service.EmployeeManagementImplVersion2;

import java.util.Map;

/**
 *  Gets request from view and send response to service.
 *
 *  @author NandiniRakAS
 */
public class EmployeeController {

    private static final EmployeeManagementImplVersion2 EMPLOYEE_SERVICE = new EmployeeManagementImplVersion2();

    /**
     * Adding new employee details.
     *
     * @param employee
     */
    public boolean addNewEmployee(final Employee employee) {
        return EMPLOYEE_SERVICE.addNewEmployee(employee);
    }

    /**
     * For showing all employee details.
     */
    public Map<Integer, Employee> getEmployees() {
        return EMPLOYEE_SERVICE.getEmployees();
    }

    /**
     * Select an employee from all employee details.
     *
     * @param employeeId
     */
    public Employee searchEmployeeDetail(final int employeeId) {
        return EMPLOYEE_SERVICE.selectEmployee(employeeId);
    }
    /**
     * Deleting employee detail by using id.
     *
     * @param employeeId
     */
    public boolean deleteEmployee(final int employeeId) {
        return EMPLOYEE_SERVICE.deleteEmployee(employeeId);
    }

    /**
     * Update employee detail by using id.
     *
     * @param employee
     */
    public boolean updateEmployeeDetails(final Employee employee) {
        return EMPLOYEE_SERVICE.updateEmployeeDetails(employee);
    }

    /**
     * Checking whether employee id is already present for addition.
     *
     * @param employeeId
     */
    public static boolean checkEmployeeIdAdd(final int employeeId) {
        return EMPLOYEE_SERVICE.checkEmployeeIdAdd(employeeId);
    }

    /**
     * Checking whether employee id is present for update.
     *
     * @param employeeId
     */
    public static boolean checkEmployeeIdUpdate(final int employeeId) {
        return EMPLOYEE_SERVICE.checkEmployeeIdUpdate(employeeId);
    }
}


