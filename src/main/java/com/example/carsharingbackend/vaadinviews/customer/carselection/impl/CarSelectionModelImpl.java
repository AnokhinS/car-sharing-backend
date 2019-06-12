package com.example.carsharingbackend.vaadinviews.customer.carselection.impl;

import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.restClients.RestCarClient;
import com.example.carsharingbackend.vaadinviews.customer.carselection.CarSelectionPresenter;
import com.vaadin.flow.spring.annotation.SpringComponent;

import java.util.Collection;

@SpringComponent
public class CarSelectionModelImpl implements CarSelectionPresenter.CarSelectionModel {

    private RestCarClient client;

    public CarSelectionModelImpl(RestCarClient client) {
        this.client = client;
    }

    @Override
    public Collection<CarEntity> getCars(String filter) {
        return client.list(filter);
    }
}
