package com.example.carsharingbackend.vaadinviews.admin.cars.filter.impl;

import com.example.carsharingbackend.restClients.RestFirmClient;
import com.example.carsharingbackend.restClients.RestTransmissionClient;
import com.example.carsharingbackend.restClients.RestTypeClient;
import com.example.carsharingbackend.vaadinviews.admin.cars.filter.CarFilterPresenter;
import com.vaadin.flow.spring.annotation.SpringComponent;

import java.util.Collection;

@SpringComponent
public class CarFilterModelImpl implements CarFilterPresenter.CarFilterModel {
    private RestFirmClient firmClient = new RestFirmClient();
    private RestTypeClient typeClient = new RestTypeClient();
    private RestTransmissionClient transmissionClient = new RestTransmissionClient();

    @Override
    public Collection getFirms() {
        return firmClient.list("");
    }

    @Override
    public Collection getTypes() {
        return typeClient.list("");
    }

    @Override
    public Collection getTransmissions() {
        return transmissionClient.list("");
    }
}
