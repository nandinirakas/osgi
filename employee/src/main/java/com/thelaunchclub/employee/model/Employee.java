package com.thelaunchclub.employee.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.sql.Date;

/**
 * Gives information about employee
 *
 * @author NandiniRakAS
 */
public class Employee {

    @NotNull(message = "Please enter id", groups = {EmployeeAddChecks.class, EmployeeDeleteChecks.class, EmployeeSearchChecks.class, EmployeeUpdateChecks.class})
    private Integer employeeId;

    @NotNull(message = "Please enter name", groups = {EmployeeAddChecks.class, EmployeeUpdateChecks.class})
    @Pattern(regexp = "[A-Za-z\\s]+", message = "Please enter name with only alphabets", groups = {EmployeeAddChecks.class, EmployeeUpdateChecks.class})
    private String employeeName;

    @NotNull(message = "Please enter salary", groups = {EmployeeAddChecks.class, EmployeeUpdateChecks.class})
    private Double salary;

    @NotNull(message = "Please enter number", groups = {EmployeeAddChecks.class, EmployeeUpdateChecks.class})
    @Pattern(regexp = "[6-9][0-9]{9}", message = "Please enter 10 digit number", groups = {EmployeeAddChecks.class, EmployeeUpdateChecks.class})
    private String phoneNumber;

    @NotNull(message = "Please enter date", groups = {EmployeeAddChecks.class, EmployeeUpdateChecks.class})
    private Date date;

    public Employee() {
        super();
    }

    public Employee(Integer employeeId, String employeeName, Double salary, String phoneNumber, Date date) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.date = date;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString() {
        return String.format("Employee id :%s \nName :%s \nSalary :%s \nPhone number :%s \nJoining date :%s \n", employeeId, employeeName, salary, phoneNumber, date);
    }
}

