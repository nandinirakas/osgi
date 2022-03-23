package com.thelaunchclub.employee.controller;

import com.thelaunchclub.employee.model.Employee;
import com.thelaunchclub.employee.service.EmployeeRest;
import com.thelaunchclub.employee.service.EmployeeRestImpl;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.GET;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

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
    @Consumes("application/json")
    @Produces("application/json")
    @POST
    public Map addNewEmployee(final Employee employee) {
        return EMPLOYEE_REST.addNewEmployee(employee);
    }

    /**
     * Shows all employees using api and pagination.
     *
     * @param page
     * @param limit
     */
    @Path("/allemployees")
    @Produces("application/json")
    @GET
    public List getEmployees(@QueryParam("page") final int page, @DefaultValue("3") @QueryParam("limit") final int limit) {
       return EMPLOYEE_REST.getEmployees(page, limit);
    }


    /**
     * Deletes employee using api.
     *
     * @param employeeId
     */
    @Produces("application/json")
    @Path("/{employeeId}")
    @DELETE
    public Map deleteEmployee(@PathParam("employeeId") final int employeeId) {
        return EMPLOYEE_REST.deleteEmployee(employeeId);
    }

    /**
     * Update employee using api.
     *
     * @param employee
     */
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    @PUT
    public Map updateEmployeeDetails(final Employee employee) {
        return EMPLOYEE_REST.updateEmployeeDetails(employee);
    }

    /**
     * Select Employee using id.
     */
    @Path("/{employeeId}")
    @Produces("application/json")
    @GET
    public List selectEmployee(@PathParam("employeeId") final int employeeId) {
        return EMPLOYEE_REST.selectEmployee(employeeId);
    }
}
