package com.thelaunchclub.employee.controller;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.thelaunchclub.databaseconnection.connection.DatabaseConnection;

import com.thelaunchclub.employee.view.EmployeeDetails;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import java.util.Map;

@Component (immediate = true, name = "database")
public class RestService {

    private Server server;
    private final EmployeeDetails EMPLOYEE_DETAILS = new EmployeeDetails();

    @Activate
    public void activate(Map<String, String> properties) {

        try {
            DatabaseConnection.databaseProperty(properties);
            JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();

            bean.setAddress("/employee");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(new EmployeeRestControllerImpl());
            server = bean.create();
            EMPLOYEE_DETAILS.selectChoice();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Deactivate
    public void deactivate() {

        try {

            if (server != null) {
                server.destroy();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
