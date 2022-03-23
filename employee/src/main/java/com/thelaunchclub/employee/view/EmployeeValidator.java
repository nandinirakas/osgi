package com.thelaunchclub.employee.view;

public class EmployeeValidator {

    /**
     * Checks whether salary contains only decimal.
     *
     * @param employeeSalary
     */
    public static boolean validateSalary(final String employeeSalary) {
        return employeeSalary.matches("(\\d+\\.\\d+)") ? true : false;
    }

    /**
     * Validation for choice given by user.
     *
     * @param choice
     */
    public static boolean validateChoice(final String choice) {
        return choice.matches("[1-5]") ? true : false;
    }
}
