package com.atmo.controller;

import com.atmo.model.Employee;
import com.atmo.service.EmployeeManagementImplVersion2;
import com.atmo.Validator;

import java.util.Map;

/**
 *  Gets request from view and send response to service.
 */
public class EmployeeController {

    private static final EmployeeManagementImplVersion2 EMPLOYEE_DATABASE = new EmployeeManagementImplVersion2();

    /**
     * Adding new employee details.
     *
     * @param employee
     */
    public static boolean addNewEmployee(final Employee employee) {
        return EMPLOYEE_DATABASE.addNewEmployee(employee);
    }

    /**
     * For showing all employee details.
     */
    public static Map<Integer, Employee> getEmployees() {
        return EMPLOYEE_DATABASE.getEmployees();
    }

    /**
     * Deleting employee detail by using id.
     *
     * @param employeeId
     */
    public static boolean deleteEmployee(final int employeeId) {
        return EMPLOYEE_DATABASE.deleteEmployee(employeeId);
    }

    /**
     * Update employee detail by using id.
     *
     * @param employee
     */
    public static boolean updateEmployeeDetails(final Employee employee) {
        return EMPLOYEE_DATABASE.updateEmployeeDetails(employee);
    }

    /**
     * Checking whether employee id is already present for addition.
     *
     * @param employeeId
     */
    public static boolean checkEmployeeIdAdd(final int employeeId) {
        return EMPLOYEE_DATABASE.checkEmployeeIdAdd(employeeId);
    }

    /**
     * Checking whether employee id is present for update.
     *
     * @param employeeId
     */
    public static boolean checkEmployeeIdUpdate(final int employeeId) {
        return EMPLOYEE_DATABASE.checkEmployeeIdUpdate(employeeId);
    }
}
