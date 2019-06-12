package com.example.carsharingbackend.vaadinviews.admin.cars.grid.impl;

import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.restClients.RestCarClient;
import com.example.carsharingbackend.vaadinviews.admin.cars.grid.CarGridPresenter;
import com.vaadin.flow.spring.annotation.SpringComponent;

import java.util.Collection;

@SpringComponent
public class CarGridModelImpl implements CarGridPresenter.CarGridModel {
    private RestCarClient client;

    public CarGridModelImpl(RestCarClient client) {
        this.client = client;
    }

    @Override
    public Collection<CarEntity> getAll() {
        return client.list("");
    }

    @Override
    public Collection<CarEntity> getAllWithFilter(String filter) {
        return client.list(filter);
    }

    @Override
    public void delete(long id) {
        client.delete(id);
    }

    @Override
    public void save(CarEntity car) {
        if (car.getId() == 0) {
            client.create(car);
        } else {
            client.update(car.getId(), car);
        }
    }

    @Override
    public CarEntity newBean() {
        return client.newBean();
    }
}
