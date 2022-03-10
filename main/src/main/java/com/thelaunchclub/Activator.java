package com.thelaunchclub;

import com.thelaunchclub.employee.view.EmployeeDetails;
import org.apache.log4j.PropertyConfigurator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Activator implements BundleActivator {

    private final EmployeeDetails EMPLOYEE_DETAILS = new EmployeeDetails();

    public void start(BundleContext context) {
        EMPLOYEE_DETAILS.selectChoice();
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }

}