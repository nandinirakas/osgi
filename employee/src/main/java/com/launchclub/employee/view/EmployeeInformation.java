package com.launchclub.employee.view;

import com.launchclub.employee.controller.EmployeeController;
import com.launchclub.employee.model.Employee;
import com.launchclub.getinputs.UserInputs;
import com.launchclub.exception.CustomException;
import com.launchclub.validation.validate.Validator;
import org.osgi.framework.Bundle;

import java.sql.Date;
import java.util.Map;

public class EmployeeInformation {

    private static Bundle bundleStop;
    private static final Validator VALIDATE = new Validator();

    public static void selectChoice() {
        int choice;

        do {
            System.out.println("EMPLOYEE MANAGEMENT\n1.ADD DETAILS\n2.VIEW DETAILS\n3.DELETE DETAILS\n4.UPDATE DETAILS\n5.EXIT");
            choice = Integer.parseInt(EmployeeInformation.getChoice());

            switch (choice) {
                case 1:
                    EmployeeInformation.addNewEmployee();
                    break;
                case 2:
                    EmployeeInformation.viewEmployees();
                    break;
                case 3:
                    EmployeeInformation.deleteEmployee();
                    break;
                case 4:
                    EmployeeInformation.updateEmployeeDetails();
                    break;
                case 5:
                    UserInputs.SCANNER.close();

                    try {
                        bundleStop.stop();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
            }
        } while (choice < 5);
    }

    public static void bundle(final Bundle bundle) {
        bundleStop = bundle;
    }

    /**
     * Gets employee id
     */
    public static int getEmployeeId() {
        final String id = UserInputs.getString("Enter employee Id: \nPress ~ to exit to main menu");

        EmployeeInformation.returnToMainMenu(id);

        if (VALIDATE.validateId(id)) {
            return Integer.parseInt(id);
        } else {
            System.out.println("Please enter valid id that contains only numbers");
            return EmployeeInformation.getEmployeeId();
        }
    }

    /**
     * Gets employee name
     */
    public static String getEmployeeName() {
        final String name = UserInputs.getString("Enter employee Name: \nPress ~ to exit to main menu");

        EmployeeInformation.returnToMainMenu(name);

        if (VALIDATE.validateName(name)) {
            return name;
        } else {
            System.out.println("Invalid, Please enter a valid Name");
            return EmployeeInformation.getEmployeeName();
        }
    }

    /**
     * Gets employee salary
     */
    public static double getEmployeeSalary() {
        final String salary = UserInputs.getString("Enter employee salary: \nPress ~ to exit to main menu");

        EmployeeInformation.returnToMainMenu(salary);

        if (EmployeeValidator.validateSalary(salary)) {
            final double totalSalary = Double.parseDouble(salary);
            double grossSalary = 0;

            if (totalSalary > 50000) {
                final double providentFund = 6000;
                grossSalary =  totalSalary - providentFund;
                //System.out.println(String.format("Provident fund tax = %s", providentFund));
            }

            if (totalSalary < 50000) {
                final double providentFund = 3000;
                grossSalary =  totalSalary - providentFund;
                //System.out.println(String.format("Provident fund = %s", providentFund));
            }
            return grossSalary;
        } else {
            System.out.println("Please enter valid salary detail that contains decimal values");
            return EmployeeInformation.getEmployeeSalary();
        }
    }

    /**
     * Gets employee phone number
     */
    public static String getEmployeePhoneNumber() {
        final String phoneNumber = UserInputs.getString("Enter employee phone number: \nPress ~ to exit to main menu");

        EmployeeInformation.returnToMainMenu(phoneNumber);

        if (VALIDATE.validatePhoneNumber(phoneNumber)) {
            return phoneNumber;
        } else {
            System.out.println("Please enter valid 10 digit phone number");
            return EmployeeInformation.getEmployeePhoneNumber();
        }
    }

    /**
     * Gets employee joining date
     */
    public static Date getEmployeeJoiningDate() {
        final String date = UserInputs.getString("Enter employee joining date(yyyy-MM-dd): \nPress ~ to exit to main menu");

        EmployeeInformation.returnToMainMenu(date);
        boolean isValidDate = false;

        try {
            isValidDate = VALIDATE.validateDate(date);
        } catch (CustomException e){
            System.out.println(e);
        }

        if (isValidDate) {
            return Date.valueOf(date);
        } else {
            System.out.println("Please enter valid date");
            return EmployeeInformation.getEmployeeJoiningDate();
        }
    }

    /**
     * Gets choice for CRUD operation from user
     */
    public static String getChoice() {
        final String choice = UserInputs.getString("Enter your choice:");

        if (EmployeeValidator.validateChoice(choice)) {
            return choice;
        } else {
            System.out.println("Please enter valid choice between 1 - 5");
            return EmployeeInformation.getChoice();
        }
    }

    /**
     * Adds employee details by getting data from the user.
     */
    public static void addNewEmployee() {
        final int employeeId = EmployeeInformation.getEmployeeId();

        try {
            EmployeeController.checkEmployeeIdAdd(employeeId);
        } catch (CustomException e) {
            System.out.println(e);
            EmployeeInformation.addNewEmployee();
            EmployeeInformation.selectChoice();
        }
        final String employeeName = EmployeeInformation.getEmployeeName();
        final double salary = EmployeeInformation.getEmployeeSalary();
        final String phoneNumber = EmployeeInformation.getEmployeePhoneNumber();
        final Date date = EmployeeInformation.getEmployeeJoiningDate();

        final Employee employee = new Employee(employeeId, employeeName, salary, phoneNumber, date);

        try {

            if (EmployeeController.addNewEmployee(employee)) {
                System.out.println("Data added in database successfully");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * Shows all employee details.
     */
    public static void viewEmployees() {

        try {

            for (Map.Entry<Integer, Employee> entry : EmployeeController.getEmployees().entrySet()) {
                System.out.println(entry.getValue());
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * Deletes employee detail by using id.
     */
    public static void deleteEmployee() {

        try {
            final int employeeId = EmployeeInformation.getEmployeeId();

            if(EmployeeController.deleteEmployee(employeeId)) {
                System.out.println("Data deleted in database successfully");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * Updates employee detail by using id.
     */
    public static void updateEmployeeDetails() {
        final String name = "name";
        final String salary = "salary";
        final String date = "date";
        final String number = "number";
        final Employee employee = new Employee();
        final int employeeId = EmployeeInformation.getEmployeeId();

        try {
            EmployeeController.checkEmployeeIdUpdate(employeeId);
        } catch (CustomException e) {
            System.out.println(e);
            EmployeeInformation.updateEmployeeDetails();
            EmployeeInformation.selectChoice();
        }
        employee.setEmployeeId(employeeId);

        System.out.println("Do you want to change name ?\t yes or no\nPress ~ to exit to main menu");
        EmployeeInformation.getUpdatedData(employee, name);

        System.out.println("Do you want to change salary ?\t yes or no\nPress ~ to exit to main menu");
        EmployeeInformation.getUpdatedData(employee, salary);

        System.out.println("Do you want to change phone number ?\t yes or no\nPress ~ to exit to main menu");
        EmployeeInformation.getUpdatedData(employee, number);

        System.out.println("Do you want to change joining date ?\t yes or no\nPress ~ to exit to main menu");
        EmployeeInformation.getUpdatedData(employee, date);

        try {

            if (EmployeeController.updateEmployeeDetails(employee)) {
                System.out.println("Data updated in database successfully");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * Returns to main menu.
     *
     * @param option
     */
    public static void returnToMainMenu(String option) {

        if ("~".equals(option)) {
            EmployeeInformation.selectChoice();
        }
    }

    /**
     * Updating various details of employee based on requirement.
     *
     * @param employee
     * @param employeeDetail
     */
    public static Employee getUpdatedData(final Employee employee, final String employeeDetail) {
        final String choiceYes = "yes";
        final String choiceNo = "no";

        while (true) {
            final String option = UserInputs.getString("Enter your option:");

            EmployeeInformation.returnToMainMenu(option);

            if (choiceYes.equalsIgnoreCase(option)) {

                if ("name".equalsIgnoreCase(employeeDetail)) {
                    employee.setEmployeeName(EmployeeInformation.getEmployeeName());
                    break;
                } else if ("salary".equalsIgnoreCase(employeeDetail)) {
                    employee.setSalary(EmployeeInformation.getEmployeeSalary());
                    break;
                } else if ("number".equalsIgnoreCase(employeeDetail)) {
                    employee.setPhoneNumber(EmployeeInformation.getEmployeePhoneNumber());
                    break;
                } else if ("date".equalsIgnoreCase(employeeDetail)) {
                    employee.setDate(EmployeeInformation.getEmployeeJoiningDate());
                    break;
                }
            } else if (choiceNo.equalsIgnoreCase(option)) {
                break;
            } else {
                System.out.println("Invalid option, please enter valid option");
                continue;
            }
        }
        return employee;
    }
}


