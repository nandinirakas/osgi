package com.atmo;

public interface Validation {

    boolean employeeIdValidation(final String employeeId);

    boolean employeeNameValidation(final String employeeName);

    boolean phoneNumberValidation(final String phoneNumber);

    boolean dateValidation(final String joiningDate);

    boolean employeeSalaryValidation(final String employeeSalary);

    boolean validateChoice(final String choice);
}
