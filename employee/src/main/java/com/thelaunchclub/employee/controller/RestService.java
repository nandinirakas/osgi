package com.thelaunchclub.employee.controller;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component
public class RestService {

    private Server server;

    @Activate
    public void activate() {

        try {
            JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();

            bean.setAddress("/employee");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(new EmployeeRestControllerImpl());
            server = bean.create();
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
