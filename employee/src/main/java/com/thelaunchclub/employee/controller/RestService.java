package com.thelaunchclub.employee.controller;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import com.thelaunchclub.employee.view.EmployeeDetails;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import org.apache.log4j.Logger;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * For server activation and deactivation.
 *
 * @author NandiniRakAS
 */
@Component (immediate = true)
public class RestService {

    private Server server;
    private final EmployeeDetails EMPLOYEE_DETAILS = new EmployeeDetails();
    private static final Logger LOGGER = Logger.getLogger(RestService.class);

    /**
     * Activate the server.
     */
    @Activate
    public void activate() {

        try {
            JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();

            bean.setAddress("/employee");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(new EmployeeRestControllerImpl());
            server = bean.create();

//          EMPLOYEE_DETAILS.selectChoice();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    /**
     * Deactivate the server by destroying it.
     */
    @Deactivate
    public void deactivate() {
        try {

            if (server != null) {
                server.destroy();
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
