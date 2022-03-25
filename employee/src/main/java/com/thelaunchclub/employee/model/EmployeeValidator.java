package com.thelaunchclub.employee.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Hibernate validator for employee.
 *
 * @author NandiniRakAS
 */
public class EmployeeValidator {

    private static final ValidatorFactory FACTORY = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
    private static final Validator VALIDATOR = FACTORY.getValidator();

    /**
     * Validator for adding new employee.
     *
     * @param employee
     */
    public static List addValidator(final Employee employee) {
        final Set<ConstraintViolation<Employee>> constraintViolations = VALIDATOR.validate(employee, EmployeeAddChecks.class, EmployeeUpdateChecks.class);

        final List employeeList = new ArrayList();

        for (ConstraintViolation<Employee> violation: constraintViolations){
            employeeList.add(violation.getMessage());
        }
        return employeeList;
    }

    /**
     * Validator for updating employee.
     *
     * @param employee
     */
    public static List updateValidator(final Employee employee) {
        final Set<ConstraintViolation<Employee>> constraintViolations = VALIDATOR.validate(employee, EmployeeUpdateChecks.class);

        final List employeeList = new ArrayList();

        for (ConstraintViolation<Employee> violation: constraintViolations){
            employeeList.add(violation.getMessage());
        }
        return employeeList;
    }

    /**
     * Validator for deleting employee.
     *
     * @param employeeId
     */
    public static List deleteValidator(final Integer employeeId) {
        final Employee employee = new Employee();

        employee.setEmployeeId(employeeId);
        final Set<ConstraintViolation<Employee>> constraintViolations = VALIDATOR.validate(employee, EmployeeDeleteChecks.class);

        final List employeeList = new ArrayList();

        for (ConstraintViolation<Employee> violation: constraintViolations){
            employeeList.add(violation.getMessage());
        }
        return employeeList;
    }

    /**
     * Validator for selecting an employee.
     *
     * @param employeeId
     */
    public static List selectValidator(final Integer employeeId) {
        final Employee employee = new Employee();

        employee.setEmployeeId(employeeId);
        final Set<ConstraintViolation<Employee>> constraintViolations = VALIDATOR.validate(employee, EmployeeSearchChecks.class);

        final List employeeList = new ArrayList();

        for (ConstraintViolation<Employee> violation: constraintViolations){
            employeeList.add(violation.getMessage());
        }
        return employeeList;
    }
}

