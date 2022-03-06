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
    private static final Validator VALIDATE = new Validator();

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
     * Validating given employee id.
     *
     * @param employeeId
     */
    public static boolean employeeIdValidation(final String employeeId) {
        return VALIDATE.employeeIdValidation(employeeId);
    }

    /**
     * Validating given employee name.
     *
     * @param employeeName
     */
    public static boolean employeeNameValidation(final String employeeName) {
        return VALIDATE.employeeNameValidation(employeeName);
    }

    /**
     * Validating given employee salary.
     *
     * @param employeeSalary
     */
    public static boolean employeeSalaryValidation(final String employeeSalary) {
        return VALIDATE.employeeSalaryValidation(employeeSalary);
    }

    /**
     * Validating given employee phone number.
     *
     * @param phoneNumber
     */
    public static boolean phoneNumberValidation(final String phoneNumber) {
        return VALIDATE.phoneNumberValidation(phoneNumber);
    }

    /**
     * Validating given employee joining date.
     *
     * @param joiningDate
     */
    public static boolean dateValidation(final String joiningDate) {
        return VALIDATE.dateValidation(joiningDate);
    }

    /**
     * Validating given employee choice given by user.
     *
     * @param choice
     */
    public static boolean validateChoice(final String choice) {
        return VALIDATE.validateChoice(choice);
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
