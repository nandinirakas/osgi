package com.thelaunchclub;

import com.thelaunchclub.databaseconnection.connection.DatabaseConnection;
import com.thelaunchclub.employee.view.EmployeeDetails;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.util.Map;

public class Activator implements BundleActivator {

    //private final EmployeeDetails EMPLOYEE_DETAILS = new EmployeeDetails();

    /**
     * For starting bundle and to begin crud operation.
     *
     * @param context
     */
    public void start(BundleContext context) {
        System.out.println("starting bundle");
       // EMPLOYEE_DETAILS.selectChoice();
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }

}