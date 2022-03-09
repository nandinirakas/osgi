
package com.launchclub;

import com.launchclub.employee.view.EmployeeInformation;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) {
        System.out.println("Starting main bundle");
        Bundle bundle = context.getBundle();
        EmployeeInformation.bundle(bundle);
        EmployeeInformation.selectChoice();
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }
}