package com.thelaunchclub.employee.controller;

import com.thelaunchclub.employee.model.Employee;
import com.thelaunchclub.employee.model.EmployeeValidator;
import com.thelaunchclub.employee.service.EmployeeRest;
import com.thelaunchclub.employee.service.EmployeeRestImpl;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.GET;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/")
public class EmployeeRestControllerImpl implements EmployeeRestController  {

    private static final EmployeeRest EMPLOYEE_REST = new EmployeeRestImpl();

    /**
     * Adds new employee using api.
     *
     * @param employee
     */
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Map addNewEmployee(@Valid final Employee employee) {
        final List employeeList = EmployeeValidator.addValidator(employee);

        if (!employeeList.isEmpty()) {
            Map map = new HashMap();

            map.put("message", employeeList);
            return map;
        }
        return EMPLOYEE_REST.addNewEmployee(employee);
    }

    /**
     * Shows all employees using api and pagination.
     *
     * @param page
     * @param limit
     */
    @Path("/allemployees")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List getEmployees(@QueryParam("page") final int page, @DefaultValue("3") @QueryParam("limit") final int limit) {
       return EMPLOYEE_REST.getEmployees(page, limit);
    }

    /**
     * Deletes employee using api.
     *
     * @param employeeId
     */
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete")
    @DELETE
    public Map deleteEmployee(@Valid @QueryParam("employeeId") final Integer employeeId) {
        final List employeeList = EmployeeValidator.deleteValidator(employeeId);

        if (!employeeList.isEmpty()) {
            Map map = new HashMap();

            map.put("message", employeeList);
            return map;
        }
        return EMPLOYEE_REST.deleteEmployee(employeeId);
    }

    /**
     * Updates employee using api.
     *
     * @param employee
     */
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public Map updateEmployeeDetails(@Valid final Employee employee) {
        final List employeeList = EmployeeValidator.updateValidator(employee);

        if (!employeeList.isEmpty()) {
            Map map = new HashMap();

            map.put("message", employeeList);
            return map;
        }
        return EMPLOYEE_REST.updateEmployeeDetails(employee);
    }

    /**
     * Selects Employee using id.
     */
    @Path("/select")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List selectEmployee(@Valid @QueryParam("employeeId") final Integer employeeId) {
        final List employeeList = EmployeeValidator.selectValidator(employeeId);

        if (employeeList.isEmpty()) {
            return EMPLOYEE_REST.selectEmployee(employeeId);
        }
        return employeeList;
    }
}
