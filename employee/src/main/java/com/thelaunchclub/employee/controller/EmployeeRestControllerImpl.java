package com.thelaunchclub.employee.controller;

import com.thelaunchclub.employee.model.Employee;

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
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class EmployeeRestControllerImpl extends EmployeeController implements EmployeeRestController  {

    /**
     * For adding new employee.
     *
     * @param employee
     */
    @Path("/add")
    @Consumes("application/json")
    @POST
    public boolean addNewEmployee(final Employee employee) {
        return super.addNewEmployee(employee);
    }

    /**
     * For showing all employees.
     *
     * @param page
     * @param limit
     */
    @Path("/allemployees")
    @Produces("application/json")
    @GET
    public List<Employee> getEmployeesDetails(@QueryParam("page") final int page, @DefaultValue("3") @QueryParam("limit") final int limit) {

        List<Employee> list = new ArrayList<>(super.getEmployees().values());
        int start = 0, end = 0;

        if(page > 0 && limit >= 0) {
            start = (page - 1) * limit;
            end = limit * page;
        }

        if(start < list.size() && end < list.size()) {
            return list.subList(start, end);
        } else if(start < list.size()) {
            return list.subList(start, list.size());
        }
        return null;
    }

    /**
     * For deleting employee.
     *
     * @param employeeId
     */
    @Path("/{employeeId}")
    @DELETE
    public boolean deleteEmployee(@PathParam("employeeId") final int employeeId) {
        return super.deleteEmployee(employeeId);
    }

    /**
     * For updating employee.
     *
     * @param employee
     */
    @Override
    @Path("/update")
    @Consumes("application/json")
    @PUT
    public boolean updateEmployeeDetails(final Employee employee) {
        return super.updateEmployeeDetails(employee);
    }

    @Path("/get")
    @Produces("application/json")
    @GET
    public String getString(){
        return "Nandini";
    }
}
