package com.thelaunchclub.employee.service;

import com.thelaunchclub.employee.dao.EmployeeDao;
import com.thelaunchclub.employee.dao.EmployeeDaoImpl;
import com.thelaunchclub.employee.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Add, select, view, update and delete employee details.
 *
 * @author NandiniRakAS
 */
public class EmployeeRestImpl implements EmployeeRest {

    private static final EmployeeDao EMPLOYEE_DATABASE = new EmployeeDaoImpl();

    /**
     * Add new employee.
     *
     * @param employee
     */
    public Map addNewEmployee(final Employee employee) {
        final Map employeeList = new HashMap<>();
        boolean isAdded = false;

        if (!EMPLOYEE_DATABASE.getEmployees().containsKey(employee.getEmployeeId())) {
            isAdded = EMPLOYEE_DATABASE.addNewEmployee(employee);
        }
        employeeList.put("Employee added", isAdded);
        return employeeList;
    }

    /**
     * Get all employees present in database.
     *
     * @param page
     * @param limit
     */
    public List getEmployees(final int page, final int limit) {
        final List<Employee> list = new ArrayList<>(EMPLOYEE_DATABASE.getEmployees().values());
        int start = 0, end = 0;

        if (page > 0 && limit >= 0) {
            start = (page - 1) * limit;
            end = limit * page;
        }

        if (start < list.size() && end < list.size()) {
            return list.subList(start, end);
        } else if (start < list.size()) {
            return list.subList(start, list.size());
        } else {
            final List emptyList = new ArrayList();

            emptyList.add("Page not found");
            return emptyList;
        }
    }

    /**
     * Delete employee using id.
     *
     * @param employeeId
     */
    public Map deleteEmployee(final int employeeId) {
        final Map employeeList = new HashMap<>();
        final boolean isDeleted = EMPLOYEE_DATABASE.deleteEmployee(employeeId);

        employeeList.put("Employee deleted",isDeleted);
        return employeeList;
    }

    /**
     * Update employee details.
     *
     * @param employee
     */
    public Map updateEmployeeDetails(final Employee employee) {
        final Map employeeList = new HashMap<>();
        final boolean isUpdated = EMPLOYEE_DATABASE.updateEmployeeDetails(employee);

        employeeList.put("Employee updated",isUpdated);
        return employeeList;
    }

    /**
     * Get an employee by using id.
     *
     * @param employeeId
     */
    public List selectEmployee(final int employeeId) {
        final List employeeList = new ArrayList();
        final Employee selectEmployee = EMPLOYEE_DATABASE.selectEmployee(employeeId);

        if (selectEmployee == null) {
            employeeList.add("Employee Id not found");
        } else {
            employeeList.add(selectEmployee);
        }
        return employeeList;
    }
}
