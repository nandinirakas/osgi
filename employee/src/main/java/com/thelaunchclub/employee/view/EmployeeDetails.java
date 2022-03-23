package com.thelaunchclub.employee.view;

import com.thelaunchclub.employee.controller.EmployeeController;
import com.thelaunchclub.employee.model.Employee;
import com.thelaunchclub.exception.CustomException;
import com.thelaunchclub.userinput.UserInput;
import com.thelaunchclub.validation.Validator;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.util.Map;

public class EmployeeDetails {

    private static final Validator VALIDATE = new Validator();
    private static final Logger LOGGER = Logger.getLogger(EmployeeDetails.class);
    private static final EmployeeController EMPLOYEE_CONTROLLER = new EmployeeController();

    /**
     * Selecting choice for performing CRUD operations.
     */
    public void selectChoice() {
        int choice;

        do {
            System.out.println("EMPLOYEE MANAGEMENT\n1.ADD DETAILS\n2.VIEW DETAILS\n3.SELECT EMPLOYEE\n4.DELETE DETAILS\n5.UPDATE DETAILS\n6.EXIT");
            choice = Integer.parseInt(getChoice());

            switch (choice) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    selectEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    updateEmployeeDetails();
                    break;
                case 6:
                    UserInput.SCANNER.close();
                    System.exit(0);
            }
        } while (choice < 6);
    }

    /**
     * Gets employee id.
     */
    public int getEmployeeId() {
        final String id = UserInput.getString("Enter employee Id: \nPress ~ to exit to main menu");

        returnToMainMenu(id);

        if (VALIDATE.validateId(id)) {
            return Integer.parseInt(id);
        } else {
            LOGGER.warn("Please enter valid id that contains only numbers");
            return getEmployeeId();
        }
    }

    /**
     * Gets employee name.
     */
    public String getEmployeeName() {
        final String name = UserInput.getString("Enter employee Name: \nPress ~ to exit to main menu");

        returnToMainMenu(name);

        if (VALIDATE.validateName(name)) {
            return name;
        } else {
            LOGGER.warn("Invalid, Please enter a valid Name");
            return getEmployeeName();
        }
    }

    /**
     * Gets employee salary.
     */
    public double getEmployeeSalary() {
        final String salary = UserInput.getString("Enter employee salary: \nPress ~ to exit to main menu");

        returnToMainMenu(salary);

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
            LOGGER.warn("Please enter valid salary detail that contains decimal values");
            return getEmployeeSalary();
        }
    }

    /**
     * Gets employee phone number.
     */
    public String getEmployeePhoneNumber() {
        final String phoneNumber = UserInput.getString("Enter employee phone number: \nPress ~ to exit to main menu");

        returnToMainMenu(phoneNumber);

        if (VALIDATE.validatePhoneNumber(phoneNumber)) {
            return phoneNumber;
        } else {
            LOGGER.warn("Please enter valid 10 digit phone number");
            return getEmployeePhoneNumber();
        }
    }

    /**
     * Gets employee joining date.
     */
    public Date getEmployeeJoiningDate() {
        final String date = UserInput.getString("Enter employee joining date(yyyy-MM-dd): \nPress ~ to exit to main menu");

        returnToMainMenu(date);
        boolean isValidDate = false;

        try {
            isValidDate = VALIDATE.validateDate(date);
        } catch (CustomException e){
            LOGGER.error(e);
        }

        if (isValidDate) {
            return Date.valueOf(date);
        } else {
            LOGGER.warn("Please enter valid date");
            return getEmployeeJoiningDate();
        }
    }

    /**
     * Gets choice for CRUD operation from user.
     */
    public String getChoice() {
        final String choice = UserInput.getString("Enter your choice:");

        if (EmployeeValidator.validateChoice(choice)) {
            return choice;
        } else {
            LOGGER.warn("Please enter valid choice between 1 - 5");
            return getChoice();
        }
    }

    /**
     * Adds employee details by getting data from the user.
     */
    public void addNewEmployee() {
        final int employeeId = getEmployeeId();

        try {
            EmployeeController.checkEmployeeIdAdd(employeeId);
        } catch (CustomException e) {
            LOGGER.error(e);
            addNewEmployee();
            selectChoice();
        }
        final String employeeName = getEmployeeName();
        final double salary = getEmployeeSalary();
        final String phoneNumber = getEmployeePhoneNumber();
        final Date date = getEmployeeJoiningDate();

        final Employee employee = new Employee(employeeId, employeeName, salary, phoneNumber, date);

        try {

            if (EMPLOYEE_CONTROLLER.addNewEmployee(employee)) {
                LOGGER.info("Data added in database successfully");
            }
        } catch (CustomException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Shows all employee details.
     */
    public void viewEmployees() {

        try {

            for (Map.Entry<Integer, Employee> entry : EMPLOYEE_CONTROLLER.getEmployees().entrySet()) {
                LOGGER.info(entry.getValue());
            }
        } catch (CustomException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Select an employee from list.
     */
    public void selectEmployee() {

        try {
            System.out.println(EMPLOYEE_CONTROLLER.searchEmployeeDetail(getEmployeeId()));
        } catch (CustomException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Deletes employee detail by using id.
     */
    public void deleteEmployee() {

        try {
            final int employeeId = getEmployeeId();

            if(EMPLOYEE_CONTROLLER.deleteEmployee(employeeId)) {
                LOGGER.info("Data deleted in database successfully");
            }
        } catch (CustomException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Updates employee detail by using id.
     */
    public void updateEmployeeDetails() {
        final String name = "name";
        final String salary = "salary";
        final String date = "date";
        final String number = "number";
        final Employee employee = new Employee();
        final int employeeId = getEmployeeId();

        try {
            EmployeeController.checkEmployeeIdUpdate(employeeId);
        } catch (CustomException e) {
            LOGGER.error(e);
            updateEmployeeDetails();
            selectChoice();
        }
        employee.setEmployeeId(employeeId);

        LOGGER.info("Do you want to change name ?\t yes or no\nPress ~ to exit to main menu");
        getUpdatedData(employee, name);

        LOGGER.info("Do you want to change salary ?\t yes or no\nPress ~ to exit to main menu");
        getUpdatedData(employee, salary);

        LOGGER.info("Do you want to change phone number ?\t yes or no\nPress ~ to exit to main menu");
        getUpdatedData(employee, number);

        LOGGER.info("Do you want to change joining date ?\t yes or no\nPress ~ to exit to main menu");
        getUpdatedData(employee, date);

        try {

            if (EMPLOYEE_CONTROLLER.updateEmployeeDetails(employee)) {
                LOGGER.info("Data updated in database successfully");
            }
        } catch (CustomException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Returns to main menu.
     *
     * @param option
     */
    public void returnToMainMenu(String option) {

        if ("~".equals(option)) {
            selectChoice();
        }
    }

    /**
     * Updating various details of employee based on requirement.
     *
     * @param employee
     * @param employeeDetail
     */
    public Employee getUpdatedData(final Employee employee, final String employeeDetail) {
        final String choiceYes = "yes";
        final String choiceNo = "no";

        while (true) {
            final String option = UserInput.getString("Enter your option:");

            returnToMainMenu(option);

            if (choiceYes.equalsIgnoreCase(option)) {

                if ("name".equalsIgnoreCase(employeeDetail)) {
                    employee.setEmployeeName(getEmployeeName());
                    break;
                } else if ("salary".equalsIgnoreCase(employeeDetail)) {
                    employee.setSalary(getEmployeeSalary());
                    break;
                } else if ("number".equalsIgnoreCase(employeeDetail)) {
                    employee.setPhoneNumber(getEmployeePhoneNumber());
                    break;
                } else if ("date".equalsIgnoreCase(employeeDetail)) {
                    employee.setDate(getEmployeeJoiningDate());
                    break;
                }
            } else if (choiceNo.equalsIgnoreCase(option)) {
                break;
            } else {
                LOGGER.warn("Invalid option, please enter valid option");
                continue;
            }
        }
        return employee;
    }
}

