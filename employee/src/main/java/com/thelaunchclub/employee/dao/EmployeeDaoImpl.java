package com.thelaunchclub.employee.dao;

import com.thelaunchclub.databaseconnection.connection.DatabaseConnection;
import com.thelaunchclub.employee.exception.AccessFailedException;
import com.thelaunchclub.employee.model.Employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

/**
 * Enabling insert, update, select, view and delete in the database using SQL queries.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    /**
     * Adds new employee.
     *
     * @param employee
     */
    public boolean addNewEmployee(final Employee employee) {
        final String addQuery = "INSERT INTO employeedetails (id, name, salary, number, date, is_deleted) values (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addQuery);) {
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDate(5, employee.getDate());
            preparedStatement.setBoolean(6, false);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException exception) {
            throw new AccessFailedException("Database access failed!!");
        }
    }

    /**
     * Deletes new employee.
     *
     * @param employeeId
     */
    public boolean deleteEmployee(final int employeeId) {
        final String deleteQuery = "UPDATE employeedetails set is_deleted = ? WHERE id = ? and is_deleted = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);) {
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, employeeId);
            preparedStatement.setBoolean(3, false);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException exception) {
            throw new AccessFailedException("Database access failed!!");
        }
    }

    /**
     * Gets all employees.
     */
    public Map<Integer, Employee> getEmployees() {
        final Map<Integer, Employee> employees = new HashMap<>();
        final String selectQuery = "SELECT id, name, salary, number, date FROM employeedetails WHERE is_deleted = false";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery();){

            while (resultSet.next()) {
                final int id = resultSet.getInt("id");
                final String name = resultSet.getString("name");
                final double salary = resultSet.getDouble("salary");
                final String number = resultSet.getString("number");
                final Date date = resultSet.getDate("date");

                Employee employee = new Employee(id, name, salary, number, date);
                employees.put(id, employee);
            }
        } catch (SQLException exception) {
            throw new AccessFailedException("Database access failed!!");
        }
        return employees;
    }

    /**
     * Select an employee from database.
     *
     * @param employeeId
     */
    public Employee selectEmployee(final int employeeId) {
        final String getEmployee = "Select id, name, salary, number, date FROM employeedetails WHERE id = ?";
        Employee employee = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(getEmployee);) {
            statement.setInt(1, employeeId);

            try (ResultSet resultSet = statement.executeQuery();) {

                while (resultSet.next()) {
                    final int id = resultSet.getInt("id");
                    final String name = resultSet.getString("name");
                    final double salary = resultSet.getDouble("salary");
                    final String number = resultSet.getString("number");
                    final Date date = resultSet.getDate("date");

                    employee = new Employee(id, name, salary, number, date);
                }
            }
        } catch (SQLException e) {
            throw new AccessFailedException("Database access failed!!");
        }
        return employee;
    }

    /**
     * Updates an employee.
     *
     * @param employee
     */
    public boolean updateEmployeeDetails(final Employee employee) {

        try (Connection connection = DatabaseConnection.getConnection();) {
            final StringBuffer updateQueryBuffer = new StringBuffer();
            updateQueryBuffer.append("UPDATE employeedetails set");
            boolean hasNextValue = false;
            int name = 1, salary = 1, number = 1, date = 1, id = 1, count = 0;

            if (employee.getEmployeeId() != 0) {

                if (employee.getEmployeeName() != null) {
                    updateQueryBuffer.append(" name = ?");
                    hasNextValue = true;
                    count += 1;
                }

                if (employee.getSalary() != 0) {

                    if (hasNextValue) {
                        updateQueryBuffer.append(",");
                    }
                    updateQueryBuffer.append(" salary = ?");
                    hasNextValue = true;
                    salary = count + 1;
                    count += 1;
                }

                if (employee.getPhoneNumber() != null) {

                    if (hasNextValue) {
                        updateQueryBuffer.append(",");
                    }
                    updateQueryBuffer.append(" number = ?");
                    hasNextValue = true;
                    number = count + 1;
                    count += 1;
                }

                if (employee.getDate() != null) {

                    if (hasNextValue) {
                        updateQueryBuffer.append(",");
                    }
                    updateQueryBuffer.append(" date = ?");
                    date = count + 1;
                    count += 1;
                }
            }
            updateQueryBuffer.append(" WHERE id = ?");
            id = count + 1;
            PreparedStatement preparedStatement = connection.prepareStatement(updateQueryBuffer.toString());

            if (employee.getEmployeeName() != null) {
                preparedStatement.setString(name, employee.getEmployeeName());
            }

            if (employee.getSalary() != 0) {
                preparedStatement.setDouble(salary, employee.getSalary());
            }

            if (employee.getPhoneNumber() != null) {
                preparedStatement.setString(number, employee.getPhoneNumber());
            }

            if (employee.getDate() != null) {
                preparedStatement.setDate(date, employee.getDate());
            }
            preparedStatement.setInt(id, employee.getEmployeeId());
            return preparedStatement.executeUpdate() > 0 ;
        } catch (SQLException exception) {
            throw new AccessFailedException("Database access failed!!");
        }
    }
}
