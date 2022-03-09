package com.launchclub.validation.validate;

import com.launchclub.validation.exception.DateNotValidException;

import java.time.LocalDate;

/**
 * Validation for employee id, name, phone number, joining date, salary.
 */
public class Validator {
    /**
     * Checks whether id contains only numbers.
     *
     * @param employeeId
     */
    public boolean validateId(final String employeeId) {
        return employeeId.matches("[0-9]{1,}") ? true : false;
    }

    /** Checks whether the name contains only alphabets.
     *
     * @param employeeName
     */
    public boolean validateName(final String employeeName) {
        return employeeName.matches("[A-Za-z\\s]{1,}") ? true : false;
    }

    /**
     * Checks whether phone number contains only numbers.
     *
     * @param phoneNumber
     */
    public boolean validatePhoneNumber(final String phoneNumber) {
        return phoneNumber.matches("[6-9][0-9]{9}") ? true : false;
    }

    /**
     * Checks whether the date is correct or not.
     *
     * @param joiningDate
     */
    public static boolean validateDate(final String joiningDate) {

        try {
            final LocalDate parsedDate = LocalDate.parse(joiningDate);
            final LocalDate todayDate = LocalDate.now();

            return todayDate.plusDays(1).isAfter(parsedDate) ? true : false;
        } catch (Exception exception) {
            throw new DateNotValidException("Invalid date!!");
        }
    }
}

